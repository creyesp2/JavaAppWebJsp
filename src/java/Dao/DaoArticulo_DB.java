package Dao;

import Bean.BeanArticulo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoArticulo_DB {
    
    public static ArrayList<BeanArticulo>ObtenerArticulos(){
        ArrayList<BeanArticulo> lstArticulo=new  ArrayList<BeanArticulo>();
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
             PreparedStatement ps=cn.prepareStatement("select * from articulo");
               ResultSet rs=ps.executeQuery();
             while(rs.next()){
                BeanArticulo beanArt = new BeanArticulo(rs.getString("COD_ARTICULO"),rs.getString("DESCRIPCION"), rs.getInt("STOCK_FISICO"),rs.getDouble("PRECIO_UNITARIO"),rs.getString("COD_PROVEEDOR"));
                lstArticulo.add(beanArt);
            }
        }catch(Exception e){
             System.out.println(e);
        }
         return lstArticulo;
    }
    
    
    public static boolean insertarArticulo(BeanArticulo ba){
        boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("insert into articulo(COD_ARTICULO,DESCRIPCION,STOCK_FISICO,PRECIO_UNITARIO,COD_PROVEEDOR)values(?,?,?,?,?)");
            ps.setString(1,ba.getCOD_ARTICULO());
            
            ps.setString(2,ba.getDESCRIPCION());
            ps.setInt(3,ba.getSTOCK_FISICO());
            ps.setDouble(4,ba.getPRECIO_UNITARIO());
           ps.setString(5,ba.getCOD_PROVEEDOR());
           int i=ps.executeUpdate();
           if(i==1)
               resp=true;
           else
               resp=false;
            
        }catch(Exception e){
        System.out.println(e);
       }
        return resp;
    }
    
    
    public static boolean actualizarArticulo(BeanArticulo ba){
         boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        
         try{
            // PreparedStatement ps=cn.prepareStatement("update articulo set DESCRIPCION="+ba.getDESCRIPCION()+", STOCK_FISICO="+ba.getSTOCK_FISICO()+", PRECIO_UNITARIO="+ba.getPRECIO_UNITARIO()+"  where COD_ARTICULO="+ba.getCOD_ARTICULO()+"");
           PreparedStatement ps=cn.prepareStatement("update articulo set DESCRIPCION = ? , STOCK_FISICO = ? , PRECIO_UNITARIO = ?  where COD_ARTICULO = ? ");
          //  PreparedStatement ps=cn.prepareStatement("update articulo set DESCRIPCION = 'ESCRITORIO NEGRO' , STOCK_FISICO = 150 , PRECIO_UNITARIO = 125  where COD_ARTICULO = 2 ");
            ps.setString(1,ba.getDESCRIPCION());
            ps.setInt(2,ba.getSTOCK_FISICO());
            ps.setDouble(3,ba.getPRECIO_UNITARIO());
            ps.setString(4,ba.getCOD_ARTICULO());
            ps.setString(5,ba.getCOD_PROVEEDOR());
           int i=ps.executeUpdate();
           if(i==1)
               resp=true;
           else
               resp=false;
            
                }catch(Exception e){
                System.out.println(e);
               }
        return resp;
    }
    
    
    public static boolean darBajaArticulo(BeanArticulo ba){
         boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        
        try{
            PreparedStatement ps=cn.prepareStatement("delete from articulo where COD_ARTICULO=?");
            ps.setString(1,ba.getCOD_ARTICULO());
                       
           int i=ps.executeUpdate();
           if(i==1)
               resp=true;
           else
               resp=false;
            
                }catch(Exception e){
                System.out.println(e);
               }
        return resp;
        
    }
    
    
    
    
    
}// FIN DaoArticulo_DB
