/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LEO
 */
public class DaoUsuario_DB {
    
    public static BeanUsuario VerificarUsuario(String usuario,String clave){
        BeanUsuario daousu=new BeanUsuario();
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        
        try{
          //  CallableStatement cs=cn.prepareCall("CALL LOGEAR_USUARIO (?)");
         //   cs.setString(1,usuario);
            //capturamos los valores enviados del formulario
            PreparedStatement ps=cn.prepareStatement("select * from usuarios where usuario=? and password=?");
            ps.setString(1, usuario);
             ps.setString(2, clave);
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                //capturamos el valor de cabeceras de la tabla con rs.getString("nombres")
                daousu.setNombres(rs.getString("nombres")); 
                daousu.setApellidos(rs.getString("apellidos"));
                daousu.setUsuario(rs.getString("usuario"));
                daousu.setPassword(rs.getString("password")); 
                daousu.setEstado(rs.getInt("estado"));
            }
            
        }catch (Exception e){
            System.out.println(e);
        }
        return daousu;
    }
    
    
    
    public static BeanUsuario listarUsuario(String usuario){
        BeanUsuario daousu=new BeanUsuario();
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
             PreparedStatement ps=cn.prepareStatement("select * from usuarios where usuario=? ");
            ps.setString(1, usuario);
            
          
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                //capturamos el valor de cabeceras de la tabla con rs.getString("nombres")
                daousu.setNombres(rs.getString("nombres")); 
                daousu.setApellidos(rs.getString("apellidos"));
                daousu.setUsuario(rs.getString("usuario"));
                daousu.setPassword(rs.getString("password")); 
                daousu.setEstado(rs.getInt("estado"));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return daousu;
        }
    
    
    
    
    
    
}
