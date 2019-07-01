package Dao;


import Bean.BeanClientes;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCliente {
    
    public static BeanClientes consultarCliente(String codigo){
        BeanClientes buscar=null;
        try{
            Connection cn;
            Conexion con = new Conexion();
            cn = con.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente where COD_CLIENTE='"+codigo+"'");
            while(rs.next()){
                buscar = new BeanClientes(rs.getString("COD_CLIENTE"),rs.getInt("ESTADO_CLIENTE"),rs.getString("RUC"),rs.getString("NOMBRE"),rs.getString("DIRECCION"),rs.getString("CIUDAD"),rs.getString("FECHA_INGRESO"),rs.getInt("TIPO_CLIENTE"),rs.getDouble("LIMITE_CREDITO_S"),rs.getDouble("LIMITE_CREDITO_D"),rs.getString("EMAIL"),rs.getString("TELEFONO"));
                
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return buscar;
    }
    
    
    public static ArrayList<BeanClientes>ListarClientes(){
        ArrayList<BeanClientes>lstCliente = new ArrayList<BeanClientes>();
       Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("select * from cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BeanClientes beanclient = new BeanClientes(rs.getString("COD_CLIENTE"),rs.getInt("ESTADO_CLIENTE"),rs.getString("RUC"),rs.getString("NOMBRE"),rs.getString("DIRECCION"),rs.getString("CIUDAD"),rs.getString("FECHA_INGRESO"),rs.getInt("TIPO_CLIENTE"),rs.getDouble("LIMITE_CREDITO_S"),rs.getDouble("LIMITE_CREDITO_D"),rs.getString("EMAIL"),rs.getString("TELEFONO"));
                lstCliente.add(beanclient);
            }
        }catch(Exception e){
             System.out.println(e);
        }
        return lstCliente;
    }
    
    
    public static boolean insertarCliente(BeanClientes bc){
        boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        
        try{
            PreparedStatement ps=cn.prepareStatement("insert into cliente(COD_CLIENTE,ESTADO_CLIENTE,RUC,NOMBRE,DIRECCION,CIUDAD,FECHA_INGRESO,TIPO_CLIENTE,LIMITE_CREDITO_S,LIMITE_CREDITO_D,EMAIL,TELEFONO) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,bc.getCOD_CLIENTE());
            ps.setInt(2,bc.getESTADO_CLIENTE());
            ps.setString(3,bc.getRUC());
            ps.setString(4,bc.getNOMBRE());
            ps.setString(5,bc.getDIRECCION());
            ps.setString(6,bc.getCIUDAD());
             ps.setString(7, bc.getFECHA_INGRESO());
            ps.setInt(8,bc.getTIPO_CLIENTE());
            ps.setDouble(9,bc.getLIMITE_CREDITO_S());
            ps.setDouble(10,bc.getLIMITE_CREDITO_D());
            ps.setString(11,bc.getEMAIL());
            ps.setString(12,bc.getTELEFONO());
            
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
    
    public static boolean actualizarCliente(BeanClientes bc){
        boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("update cliente set ESTADO_CLIENTE=? ,RUC=? ,NOMBRE=?, DIRECCION=? ,CIUDAD=?, FECHA_INGRESO=? ,TIPO_CLIENTE=? ,LIMITE_CREDITO_S=? ,LIMITE_CREDITO_D=? ,EMAIL=? ,TELEFONO=?  where COD_CLIENTE=?");
           
            ps.setInt(1,bc.getESTADO_CLIENTE());
            ps.setString(2,bc.getRUC());
            ps.setString(3,bc.getNOMBRE());
            ps.setString(4,bc.getDIRECCION());
            ps.setString(5,bc.getCIUDAD());
            ps.setString(6, bc.getFECHA_INGRESO());
            ps.setInt(7,bc.getTIPO_CLIENTE());
            ps.setDouble(8,bc.getLIMITE_CREDITO_S());
            ps.setDouble(9,bc.getLIMITE_CREDITO_D());
            ps.setString(10,bc.getEMAIL());
            ps.setString(11,bc.getTELEFONO());
             ps.setString(12,bc.getCOD_CLIENTE());
             
//              System.out.println("getESTADO_CLIENTE."+bc.getESTADO_CLIENTE());
//              System.out.println("getRUC."+bc.getRUC());
//              System.out.println("getNOMBRE."+bc.getNOMBRE());
//              System.out.println("getDIRECCION."+bc.getDIRECCION());
//              System.out.println("getCIUDAD."+bc.getCIUDAD());
//              System.out.println("getFECHA_INGRESO."+bc.getFECHA_INGRESO());
//              System.out.println("getTIPO_CLIENTE."+bc.getTIPO_CLIENTE());
//              System.out.println("getLIMITE_CREDITO_S."+bc.getLIMITE_CREDITO_S());
//              System.out.println("getLIMITE_CREDITO_D."+bc.getLIMITE_CREDITO_D());
//              System.out.println("getEMAIL."+bc.getEMAIL());
//              System.out.println("getTELEFONO."+bc.getTELEFONO());
//              System.out.println("getCOD_CLIENTE."+bc.getCOD_CLIENTE());
              
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
    
    
    public static boolean EliminarCliente(BeanClientes bc){
        boolean resp=false;
        Connection cn;
        Conexion con=new Conexion();
        cn=con.conectar();
        try{
            PreparedStatement ps=cn.prepareStatement("delete from cliente where COD_CLIENTE=?");
            ps.setString(1,bc.getCOD_CLIENTE());
                       
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
