package com.examentitulo.uv.mx;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.examentitulo.uv.mx.DB.*;

//Puerto de Acceso es 4567

public class App 
{
    public static void main( String[] args )
    {
        staticFiles.location("/");
        init();
        options("/*", (request, response) ->{
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if(accessControlRequestHeaders != null){
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Acess-Control-Request-Method");
            if(accessControlRequestMethod != null){
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((req, res) -> res.header("Access-Control-Allow-Origin", "*"));

        get("/", (req, res) ->{
        res.redirect("Login.html");
        return null;
        });

        post("/Registrar", (req, res) ->{
            Gson gson = new Gson();
            Usuario usuarioNew= gson.fromJson(req.body(), Usuario.class);
            if(DAO.Registrar(usuarioNew)){
                return "SI";
            }else{
                return "NO";
            }
        });

        post("/Ingresar", (req, res) -> {
            Gson gson = new Gson();
            Usuario usuarioNew = gson.fromJson(req.body(), Usuario.class);
            Usuario u = DAO.validarUsuario(usuarioNew.getCorreo(), usuarioNew.getContraseña());
            if(u!=null){
                return "SI";
            }else{
                return "NO";
            }
        });
    }
}
