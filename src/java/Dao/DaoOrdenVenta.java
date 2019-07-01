
package Dao;

import Bean.BeanOrdenVenta;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoOrdenVenta {
    
    public static ArrayList<BeanOrdenVenta>ListarOrdenVenta(){
        ArrayList<BeanOrdenVenta> lstOrdenVenta = new ArrayList<BeanOrdenVenta>();
        Connection cn;
        Conexion con = new Conexion();
          cn = con.conectar();
          try{
              PreparedStatement ps = cn.prepareStatement("select * from orden_de_venta");
              ResultSet rs=ps.executeQuery();
              while(rs.next()){
                  BeanOrdenVenta bov = new BeanOrdenVenta(rs.getInt("NUM_ORDEN_VENTA"),rs.getString("COD_CLIENTE"),rs.getString("FECHA_ORDEN"),rs.getDouble("DESCUENTO_ORDEN"));
                  lstOrdenVenta.add(bov);
              }
          }catch(Exception e){
               System.out.println(e);
          }
          return lstOrdenVenta;
    }
    
    
    // NUMERO DE ORDEN DE BOLETA
    
     public static ArrayList<BeanOrdenVenta>UltimaOrdenVenta(){
        ArrayList<BeanOrdenVenta> lstOrdenVenta = new ArrayList<BeanOrdenVenta>();
        Connection cn;
        Conexion con = new Conexion();
          cn = con.conectar();
          try{
              PreparedStatement ps = cn.prepareStatement("SELECT * FROM orden_de_venta WHERE NUM_ORDEN_VENTA = (SELECT MAX(NUM_ORDEN_VENTA) FROM orden_de_venta)");
              ResultSet rs=ps.executeQuery();
              while(rs.next()){
                  BeanOrdenVenta bov = new BeanOrdenVenta(rs.getInt("NUM_ORDEN_VENTA"),rs.getString("COD_CLIENTE"),rs.getString("FECHA_ORDEN"),rs.getDouble("DESCUENTO_ORDEN"));
                  lstOrdenVenta.add(bov);
              }
          }catch(Exception e){
               System.out.println(e);
          }
          return lstOrdenVenta;
    }
    
     
//insertar cliente en tabla orden de venta
     public static boolean insertarOrdenVenta(BeanOrdenVenta bov){
         boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("insert into orden_de_venta(NUM_ORDEN_VENTA,COD_CLIENTE,FECHA_ORDEN,DESCUENTO_ORDEN) values(?,?,?,?)");
            ps.setInt(1,bov.getNUM_ORDEN_VENTA());
            ps.setString(2,bov.getCOD_CLIENTE());
            ps.setString(3,bov.getFECHA_ORDEN());
            ps.setDouble(4,bov.getDESCUENTO_ORDEN());
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
    
}
