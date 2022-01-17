package com.examentitulo.uv.mx;

import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {
        get("/hello", (req, res) -> "Hello World");
    }
}
