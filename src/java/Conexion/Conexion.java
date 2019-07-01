/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LEO
 */
public class Conexion {
    Connection conectar=null;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
           conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","");
          // conectar = DriverManager.getConnection("jdbc:mysql://node21669-ta-luiscabrel.jelastic.cloudhosted.es:3306/uap","root","KCFkfn07791");
           // conectar = DriverManager.getConnection("jdbc:mysql://node21654-taluiscabrel.jelastic.cloudhosted.es/uap","uap","uap");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar: "+e.getMessage());
        }
        return conectar;
    }
}
