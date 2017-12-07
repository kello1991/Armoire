/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.*;

/**
 *
 * @author ahmed
 */
public class connection {
    
    
    
    public  Connection connecterDB() {
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver oki");
        String url="jdbc:mysql://localhost:3306/rfid";
        String user="root";
        String password="root";
        Connection cnx=DriverManager.getConnection(url,user,password);
        System.out.println("connection bien etablie");
        return cnx;
    }catch(Exception e){
    e.printStackTrace();
    return null;}
    
    
    
    
        
    }
    
}
