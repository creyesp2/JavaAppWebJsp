/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanClientes;
import Dao.DaoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_Cliente extends HttpServlet {

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
            if(accion.equals("insertarcliente")){
              //   System.out.println("ingreso");
                this.RegistrarCliente(request, response);
            }
            if(accion.equals("actualizar")){
                //out.println("parametro."+accion);
                this.ActualizarCliente(request, response); 
            }
            if(accion.equals("eliminar")){
                this.EliminarCliente(request, response); 
            }
            if(accion.equals("buscar")){
                this.BuscarCliente(request, response); 
            }
        }
    }
    
    
    private void RegistrarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         BeanClientes bc=new BeanClientes();
         bc.setCOD_CLIENTE(request.getParameter("txt_codigo"));
         bc.setESTADO_CLIENTE(Integer.parseInt(request.getParameter("txt_estadocliente")));
         bc.setRUC(request.getParameter("txt_ruc"));
         bc.setNOMBRE(request.getParameter("txt_nombre"));
         bc.setDIRECCION(request.getParameter("txt_direccion"));
         bc.setCIUDAD(request.getParameter("txt_ciudad"));
         bc.setFECHA_INGRESO(request.getParameter("txt_fecha"));
         bc.setTIPO_CLIENTE(Integer.parseInt(request.getParameter("txt_tipocliente")));
         bc.setLIMITE_CREDITO_S(Double.parseDouble(request.getParameter("txt_credito_s")));
         bc.setLIMITE_CREDITO_D(Double.parseDouble(request.getParameter("txt_credito_d")));
         bc.setEMAIL(request.getParameter("txt_email"));
         bc.setTELEFONO(request.getParameter("txt_telefono"));
         

         boolean resp=DaoCliente.insertarCliente(bc);
         if(resp){
             response.sendRedirect("cliente.jsp?mens=Se registro Cliente&&std=1");
         }else{
              response.sendRedirect("cliente.jsp?mens=Error al Registrar Cliente&&std=0");
         }
     }
    
    
    
    private void ActualizarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
     BeanClientes bc=new BeanClientes();
     
      bc.setCOD_CLIENTE(request.getParameter("txt_codigo"));
         bc.setESTADO_CLIENTE(Integer.parseInt(request.getParameter("txt_estadocliente")));
         bc.setRUC(request.getParameter("txt_ruc"));
         bc.setNOMBRE(request.getParameter("txt_nombre"));
         bc.setDIRECCION(request.getParameter("txt_direccion"));
         bc.setCIUDAD(request.getParameter("txt_ciudad"));
         bc.setFECHA_INGRESO(request.getParameter("txt_fecha"));
         bc.setTIPO_CLIENTE(Integer.parseInt(request.getParameter("txt_tipocliente")));
         bc.setLIMITE_CREDITO_S(Double.parseDouble(request.getParameter("txt_credito_s")));
         bc.setLIMITE_CREDITO_D(Double.parseDouble(request.getParameter("txt_credito_d")));
         bc.setEMAIL(request.getParameter("txt_email"));
         bc.setTELEFONO(request.getParameter("txt_telefono"));
         
//                    System.out.println("txt_codigo."+request.getParameter("txt_codigo"));
//                    System.out.println("txt_estadocliente."+request.getParameter("txt_estadocliente"));
//                    System.out.println("txt_ruc."+request.getParameter("txt_ruc"));
//                     System.out.println("txt_nombre."+request.getParameter("txt_nombre"));
//                      System.out.println("txt_direccion."+request.getParameter("txt_direccion"));
//                       System.out.println("txt_ciudad."+request.getParameter("txt_ciudad"));
//                        System.out.println("txt_fecha."+request.getParameter("txt_fecha"));
//                         System.out.println("txt_tipocliente."+request.getParameter("txt_tipocliente"));
//                          System.out.println("txt_credito_s."+request.getParameter("txt_credito_s"));
//                           System.out.println("txt_credito_d."+request.getParameter("txt_credito_d"));
//                            System.out.println("txt_email."+request.getParameter("txt_email"));
//                             System.out.println("txt_telefono."+request.getParameter("txt_telefono"));
          boolean resp=DaoCliente.actualizarCliente(bc);
         if(resp){
             response.sendRedirect("cliente.jsp?mens='Se Actualizo Cliente'&&std=1");
         }else{
              response.sendRedirect("cliente.jsp?mens='Error al Actualizar Cliente'&&std=0");
         }
     
    }
    
    
    
    private void EliminarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
          BeanClientes bc=new BeanClientes();
          bc.setCOD_CLIENTE(request.getParameter("codigCliente"));
          
            boolean resp=DaoCliente.EliminarCliente(bc);
         if(resp){
             PrintWriter out=response.getWriter();
              out.println("Error, no se encontro el usuario.");
             response.sendRedirect("cliente.jsp?mens='Se Elimino Producto'");
         }else{
             PrintWriter out=response.getWriter();
              out.println("Error, no se encontro el usuario.");
              response.sendRedirect("cliente.jsp?mens='Error al Eliminar Producto'");
         }
    }
    
    
     private void BuscarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
          String cliente = request.getParameter("codigoCliente");
          BeanClientes buscaCliente=DaoCliente.consultarCliente(cliente);
          if(buscaCliente!=null){
              request.setAttribute("buscaCliente", buscaCliente);
              request.getRequestDispatcher("COLOCAR URL").forward(request, response);
          }else{
              PrintWriter out=response.getWriter();
              //out.println("Error, no se encontro el usuario.");
              response.sendRedirect("articulo.jsp?mens='No se encontro cliente'");
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
