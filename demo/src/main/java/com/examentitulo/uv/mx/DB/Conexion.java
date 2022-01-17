package com.examentitulo.uv.mx.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection Con = null;
    private static String uri = "jdbc::mysql://db4free.net::3306/powerfultest";
    private static String user = "root2395";
    private static String password = "3..g2cD!PB6U4Tu";

    public static Connection getConexion(){
        try{
            Con = DriverManager.getConnection(uri, user, password);
        }catch (SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
        }
        return Con;
    }
}
