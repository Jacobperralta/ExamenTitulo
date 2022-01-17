package com.examentitulo.uv.mx;

import static spark.Spark.*;

//Puerto de Acceso es 4567

public class App 
{
    public static void main( String[] args )
    {
        staticFiles.location("/");
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
    }
}
