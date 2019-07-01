
package Servlet;

import Bean.BeanDetalleOrden;
import Bean.BeanOrdenVenta;
import Dao.DaoDetalleOrden;
import Dao.DaoOrdenVenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet_DetalleOrden extends HttpServlet {

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
                //System.out.println("prueba: "+accion);
                 this.GuardarOrdenVenta(request,response);
               // this.GuardarDetalleVenta(request,response);
            }
           
        }
    }
    
     private void GuardarOrdenVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        
        BeanOrdenVenta bov  = new BeanOrdenVenta();
        bov.setNUM_ORDEN_VENTA(Integer.parseInt(request.getParameter("NOV")));
        bov.setCOD_CLIENTE(request.getParameter("CO"));
        bov.setFECHA_ORDEN(request.getParameter("FO"));
        bov.setDESCUENTO_ORDEN(Double.parseDouble(request.getParameter("DO")));
        
         System.out.println("Guardar Orden nov."+request.getParameter("NOV"));
                  System.out.println("co."+request.getParameter("CO"));
                 System.out.println("fo."+request.getParameter("FO"));
                  System.out.println("do."+request.getParameter("DO"));
        
        boolean resp=DaoOrdenVenta.insertarOrdenVenta(bov);
              if(resp){
                    System.out.println("ingreso correcto");
                     this.GuardarDetalleVenta(request,response);
            // response.sendRedirect("orden_venta.jsp?mens=Se envio Cliente&&std=1");
         }else{
                  System.out.println("error al ingresar datos");
            //  response.sendRedirect("orden_venta.jsp?mens=Error al enviar cliente&&std=0");
         }
    }
     
    private void GuardarDetalleVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BeanDetalleOrden bdo = new BeanDetalleOrden();
        bdo.setNUM_ORDEN_VENTA(Integer.parseInt(request.getParameter("NOV")));
        bdo.setNUMERO_POSICION(Integer.parseInt(request.getParameter("NP")));
        bdo.setCOD_ARTICULO(request.getParameter("codigo"));
        bdo.setCANTIDAD_PEDIDA(Integer.parseInt(request.getParameter("cantidad")));
        bdo.setCANTIDAD_DESPACHADA(Integer.parseInt(request.getParameter("cantidad")));
        bdo.setPRECIO_TOTAL(Double.parseDouble(request.getParameter("precio")));
       
        bdo.setVALOR_VENTA(Double.parseDouble(request.getParameter("igv")));
        bdo.setIVA(Double.parseDouble(request.getParameter("subtotal")));
        bdo.setIMPORTE_TOTAL(Double.parseDouble(request.getParameter("total")));
        
        System.out.println("NOV."+request.getParameter("NOV"));
        System.out.println("NP."+request.getParameter("NP"));
        System.out.println("codigo."+request.getParameter("codigo"));
        System.out.println("cantidad."+request.getParameter("cantidad"));
        System.out.println("cantidad."+request.getParameter("cantidad"));
        System.out.println("precio."+request.getParameter("precio"));
        System.out.println("igv."+request.getParameter("igv"));
        System.out.println("subtotal."+request.getParameter("subtotal"));
        System.out.println("total."+request.getParameter("total"));
        boolean resp=DaoDetalleOrden.insertarDetalleOrden(bdo);
              if(resp){
                 //  System.out.println("ingreso correcto");
             response.sendRedirect("orden_venta.jsp?mens=Se envio Cliente&&std=1");
         }else{
                //   System.out.println("error al ingresar datos");
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
