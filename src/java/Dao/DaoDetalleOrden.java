/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.BeanClientes;
import Bean.BeanDetalleOrden;
import Conexion.Conexion;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LEO
 */
public class DaoDetalleOrden {
    
    public static  ArrayList<BeanDetalleOrden>ListarDetalleOrden(){
        ArrayList<BeanDetalleOrden>lstDetalleOrden = new ArrayList<BeanDetalleOrden>();
        Connection cn;
        Conexion con = new Conexion();
          cn = con.conectar();
          try{
              PreparedStatement ps = cn.prepareStatement("select * from detalle_orden");
              ResultSet rs=ps.executeQuery();
              
              while(rs.next()){
                  BeanDetalleOrden beando = new BeanDetalleOrden(rs.getInt("NUM_ORDEN_VENTA"),rs.getInt("NUMERO_POSICION"),rs.getString("COD_ARTICULO"),rs.getInt("CANTIDAD_PEDIDA"),rs.getInt("CANTIDAD_DESPACHADA"),rs.getDouble("PRECIO_TOTAL"),rs.getDouble("VALOR_VENTA"),rs.getDouble("IGV"),rs.getDouble("importe_total"));
                  lstDetalleOrden.add(beando);
              }
              
          }catch(Exception e){
             System.out.println(e);
        }    
          return lstDetalleOrden;
    }
    
//   *************   LISTAR CLIENTES  ******************
    public static ArrayList<BeanClientes>ClienteLista(){
        ArrayList<BeanClientes>lstClientes = new ArrayList<BeanClientes>();
        Connection cn;
        Conexion con = new Conexion();
          cn = con.conectar();
          try{
               PreparedStatement ps = cn.prepareStatement("select *  from cliente");
               ResultSet rs = ps.executeQuery();
               System.out.println(rs);
               while(rs.next()){
                   BeanClientes bc = new BeanClientes(rs.getString("COD_CLIENTE"),rs.getInt("ESTADO_CLIENTE"),rs.getString("RUC"),rs.getString("NOMBRE"),rs.getString("DIRECCION"),rs.getString("CIUDAD"),rs.getString("FECHA_INGRESO"),rs.getInt("TIPO_CLIENTE"),rs.getDouble("LIMITE_CREDITO_S"),rs.getDouble("LIMITE_CREDITO_D"),rs.getString("EMAIL"),rs.getString("TELEFONO"));
                   lstClientes.add(bc);
                   //System.out.println(lstClientes);
               }
          }catch(Exception e){
              System.out.println(e);
          }
         return lstClientes;        
          
    }
    
    //insertar datelle de venta
    public static boolean insertarDetalleOrden(BeanDetalleOrden bdo){
         boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("insert into detalle_orden(NUM_ORDEN_VENTA,NUMERO_POSICION,COD_ARTICULO,CANTIDAD_PEDIDA,CANTIDAD_DESPACHADA,PRECIO_TOTAL,VALOR_VENTA,IGV,IMPORTE_TOTAL) values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, bdo.getNUM_ORDEN_VENTA());
            ps.setInt(2, bdo.getNUMERO_POSICION());
            ps.setString(3, bdo.getCOD_ARTICULO());
            ps.setInt(4, bdo.getCANTIDAD_PEDIDA());
            ps.setInt(5, bdo.getCANTIDAD_DESPACHADA());
            ps.setDouble(6, bdo.getPRECIO_TOTAL());
       
            ps.setDouble(7, bdo.getVALOR_VENTA());
            ps.setDouble(8, bdo.getIVA());
            ps.setDouble(9, bdo.getIMPORTE_TOTAL());
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
