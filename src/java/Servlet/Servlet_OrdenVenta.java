/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanOrdenVenta;
import Dao.DaoOrdenVenta;
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
public class Servlet_OrdenVenta extends HttpServlet {

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
            String accion  = request.getParameter("accion");
            if(accion.equals("registrarVenta")){
                System.out.println(accion);
              //  this.RegistrarOrdenVenta(request,response);
            }
           
        }
    }
    
    
    private void RegistrarOrdenVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        BeanOrdenVenta bov  = new BeanOrdenVenta();
        bov.setNUM_ORDEN_VENTA(Integer.parseInt(request.getParameter("NOV")));
        bov.setCOD_CLIENTE(request.getParameter("CO"));
        bov.setFECHA_ORDEN(request.getParameter("FO"));
        bov.setDESCUENTO_ORDEN(Double.parseDouble(request.getParameter("DO")));
        
          System.out.println("nov."+request.getParameter("NOV"));
                   System.out.println("co."+request.getParameter("CO"));
                  System.out.println("fo."+request.getParameter("FO"));
                  System.out.println("do."+request.getParameter("DO"));
        
        boolean resp=DaoOrdenVenta.insertarOrdenVenta(bov);
              if(resp){
             response.sendRedirect("orden_venta.jsp?mens=Se envio Cliente&&std=1");
         }else{
              response.sendRedirect("orden_venta.jsp?mens=Error al enviar cliente&&std=0");
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
