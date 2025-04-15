package com.henrique.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/jsp_produto_app";
        String user = "root";
        String password = "123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}