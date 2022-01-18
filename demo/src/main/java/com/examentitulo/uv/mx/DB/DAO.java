package com.examentitulo.uv.mx.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
    private static final String table="Usuario";
    public static boolean Registrar(Usuario u){
        boolean result =false;
    try{
        String query = " insert into "+table+" (correo, contraseña)" + " VALUES (?, ?)";
        PreparedStatement PS = Conexion.getConexion().prepareStatement(query);
        PS.setString(1, u.getCorreo());
        PS.setString(2, u.getContraseña());
        PS.execute();
        System.out.println("Usuario fue agregado");
        result = true;
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
    return result;
    }

    public static Usuario validarUsuario(String correo, String contraseña){
        Statement ST;
        Usuario usuario = null;
        try{
            ST = Conexion.getConexion().createStatement();
            ResultSet rs = ST.executeQuery("SELECT * FROM "+table+" WHERE correo = '"+correo+"' and contraseña ='"+contraseña+"';");
            if(rs.next()){
                usuario = new Usuario(rs.getString("correo"), rs.getString("contraseña"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return usuario;
    }
}
