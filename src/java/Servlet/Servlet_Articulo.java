/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanArticulo;
import Dao.DaoArticulo_DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LEO
 */
public class Servlet_Articulo extends HttpServlet {

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
                this.RegistrarArticulo(request, response);
            }
            if(accion.equals("actualizar")){
                this.ActualizarArticulo(request, response); 
            }
            if(accion.equals("eliminar")){
                this.EliminarArticulo(request, response); 
            }
            
        }
    }

    
    
     private void RegistrarArticulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         BeanArticulo ba=new BeanArticulo();
         ba.setCOD_ARTICULO(request.getParameter("txt_codigo"));
         ba.setDESCRIPCION(request.getParameter("txt_descripcion"));
         ba.setSTOCK_FISICO(Integer.parseInt(request.getParameter("txt_stock")));
         ba.setPRECIO_UNITARIO(Double.parseDouble(request.getParameter("txt_precio")));
          ba.setCOD_PROVEEDOR(request.getParameter("txt_proveedor"));
         boolean resp=DaoArticulo_DB.insertarArticulo(ba);
         if(resp){
             response.sendRedirect("articulo.jsp?mens=Se registro Producto&&std=1");
         }else{
              response.sendRedirect("articulo.jsp?mens=Error al Registrar Producto&&std=0");
         }
     }
    
    
     
      private void ActualizarArticulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
          BeanArticulo ba=new BeanArticulo();
         ba.setCOD_ARTICULO(request.getParameter("mtxt_codigo"));
         
         ba.setDESCRIPCION(request.getParameter("mtxt_descripcion"));
         ba.setSTOCK_FISICO(Integer.parseInt(request.getParameter("mtxt_stock")));
         ba.setPRECIO_UNITARIO(Double.parseDouble(request.getParameter("mtxt_precio")));
        ba.setCOD_PROVEEDOR(request.getParameter("mtxt_proveedor"));
          boolean resp=DaoArticulo_DB.actualizarArticulo(ba);
         if(resp){
             response.sendRedirect("articulo.jsp?mens='Se Actualizo Producto'&&std=1");
         }else{
              response.sendRedirect("articulo.jsp?mens='Error al Actualizar Producto'&&std=0");
         }
         
      
      }
      
      
       private void EliminarArticulo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
              BeanArticulo ba=new BeanArticulo();
              ba.setCOD_ARTICULO(request.getParameter("codigArt"));
              
                boolean resp=DaoArticulo_DB.darBajaArticulo(ba);
         if(resp){
             response.sendRedirect("articulo.jsp?mens='Se Elimino Producto'");
         }else{
              response.sendRedirect("articulo.jsp?mens='Error al Eliminar Producto'");
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
