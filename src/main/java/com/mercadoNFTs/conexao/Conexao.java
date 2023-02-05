package com.mercadoNFTs.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    static Connection connection=null;
    static String usuario = "root";
    static String senha = "root";
    static String url = "jdbc:mysql://localhost:3306/db_mercadonft?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection conectar(){
        try{
            Class.forName(driver);
            connection = DriverManager.
                    getConnection(url, usuario, senha);
            System.out.println("Conexao com sucesso");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Falha com conexao "+ex);
        }
        return connection;
    }
    
}
