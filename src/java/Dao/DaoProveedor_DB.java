package Dao;

import Bean.BeanProveedor;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoProveedor_DB {
    
    public static ArrayList<BeanProveedor>ObtenerProveedor(){
        ArrayList<BeanProveedor> lstProveedor=new  ArrayList<BeanProveedor>();
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
             PreparedStatement ps=cn.prepareStatement("select * from proveedor");
               ResultSet rs=ps.executeQuery();
             while(rs.next()){
                BeanProveedor beanArt = new BeanProveedor(rs.getString("COD_PROVEEDOR"),rs.getString("NOMBRE_PROVEEDOR"),rs.getString("DPI"),rs.getInt("CANTIDAD"),rs.getDouble("PRECIO"));
                lstProveedor.add(beanArt);
            }
        }catch(Exception e){
             System.out.println(e);
        }
         return lstProveedor;
    }
    
    
    public static boolean insertarProveedor(BeanProveedor ba){
        boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("insert into proveedor(COD_PROVEEDOR,NOMBRE_PROVEEDOR,DPI,CANTIDAD,PRECIO)values(?,?,?,?,?)");
            ps.setString(1,ba.getCOD_PROVEEDOR());
            ps.setString(2,ba.getNOMBRE_PROVEEDOR());
            ps.setString(3,ba.getDPI());
            ps.setInt(4,ba.getCANTIDAD());
            ps.setDouble(5,ba.getPRECIO());
           
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
    
    
    public static boolean actualizarProveedor(BeanProveedor ba){
         boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        
         try{
            // PreparedStatement ps=cn.prepareStatement("update articulo set DESCRIPCION="+ba.getDESCRIPCION()+", STOCK_FISICO="+ba.getSTOCK_FISICO()+", PRECIO_UNITARIO="+ba.getPRECIO_UNITARIO()+"  where COD_ARTICULO="+ba.getCOD_ARTICULO()+"");
           PreparedStatement ps=cn.prepareStatement("update proveedor set NOMBRE_PROVEEDOR = ? , DPI = ? ,CANTIDAD = ?, PRECIO = ?  where COD_PROVEEDOR = ? ");
          //  PreparedStatement ps=cn.prepareStatement("update articulo set DESCRIPCION = 'ESCRITORIO NEGRO' , STOCK_FISICO = 150 , PRECIO_UNITARIO = 125  where COD_ARTICULO = 2 ");
           
          ps.setString(1,ba.getNOMBRE_PROVEEDOR());
             ps.setString(2,ba.getDPI());
            ps.setInt(3,ba.getCANTIDAD());
            ps.setDouble(4,ba.getPRECIO());
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
    
    
    public static boolean darBajaProveedor(BeanProveedor ba){
         boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        
        try{
            PreparedStatement ps=cn.prepareStatement("delete from proveedor where COD_PROVEEDOR=?");
            ps.setString(1,ba.getCOD_PROVEEDOR());
                       
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