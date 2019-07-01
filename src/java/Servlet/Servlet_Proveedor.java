/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanProveedor;
import Dao.DaoProveedor_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax. servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LEO
 */
public class Servlet_Proveedor extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a
     * servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter()) {
         String accion = request.getParameter("accion");
             if(accion.equals("insertar")){
                this.insertarProveedor(request, response);
            }
            if(accion.equals("actualizar")){
                this.ActualizarProveedor(request, response); 
            }
            if(accion.equals("eliminar")){
                this.EliminarProveedor(request, response); 
            }
            
        }
    }

    
    
     private void insertarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         BeanProveedor ba=new BeanProveedor();
         ba.setCOD_PROVEEDOR(request.getParameter("txt_codigo"));
         ba.setNOMBRE_PROVEEDOR(request.getParameter("txt_proveedor"));
         ba.setDPI(request.getParameter("txt_dpi"));
         ba.setCANTIDAD(Integer.parseInt(request.getParameter("txt_cantidad")));
         ba.setPRECIO(Double.parseDouble(request.getParameter("txt_precio")));
         
         boolean resp=DaoProveedor_DB.insertarProveedor(ba);
         if(resp){
             response.sendRedirect("proveedor.jsp?mens=Se registro Proveedor&&std=1");
         }else{
              response.sendRedirect("proveedor.jsp?mens=Error al Registrar Proveedor&&std=0");
         }
     }
    
    
     
      private void ActualizarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
          BeanProveedor ba=new BeanProveedor();
         ba.setCOD_PROVEEDOR(request.getParameter("mtxt_codigo"));
         
         ba.setNOMBRE_PROVEEDOR(request.getParameter("mtxt_proveedor"));
          ba.setDPI(request.getParameter("mtxt_dpi"));
         ba.setCANTIDAD(Integer.parseInt(request.getParameter("mtxt_cantidad")));
         ba.setPRECIO(Double.parseDouble(request.getParameter("mtxt_precio")));
       
          boolean resp=DaoProveedor_DB.actualizarProveedor(ba);
         if(resp){
             response.sendRedirect("proveedor.jsp?mens='Se Actualizo Proveedor'&&std=1");
         }else{
              response.sendRedirect("proveedor.jsp?mens='Error al Actualizar Proveedor'&&std=0");
         }
         
      
      }
      
      
       private void EliminarProveedor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
              BeanProveedor ba=new BeanProveedor();
              ba.setCOD_PROVEEDOR(request.getParameter("codigPro"));
              
                boolean resp=DaoProveedor_DB.darBajaProveedor(ba);
         if(resp){
             response.sendRedirect("proveedor.jsp?mens='Se Elimino Producto'");
         }else{
              response.sendRedirect("proveedor.jsp?mens='Error al Eliminar Producto'");
         }
           
       }
      
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a
     * servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a
     * servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet
     * description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
