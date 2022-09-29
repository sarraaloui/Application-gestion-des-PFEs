/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sarah
 */
class connectionClass {
        // public  Connection  conn;

    public static Connection getConnection()throws SQLException, ClassNotFoundException{
        
        
        String dbName="projet_java";
        String userName="root";
        String password="";
   
            Class.forName("com.mysql.jdbc.Driver");
         Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            return conn;  
        } 
 
    
    

}