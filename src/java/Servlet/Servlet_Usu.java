package Servlet;

import Conexion.Conexion;
import Dao.BeanUsuario;
import Dao.DaoUsuario_DB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LEO
 */
public class Servlet_Usu extends HttpServlet {

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
         String accion=request.getParameter("accion");
        try (PrintWriter out = response.getWriter()) {         
          if(accion.equals("login")){
              Login(request,response);
            //  return;
          }if(accion.equals("logout")){              
              Logout(request, response);  
          }
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

    private void Login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
         Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
        String usuario = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
        Integer estadousu=1;
        
        try{
            BeanUsuario beanusu=DaoUsuario_DB.VerificarUsuario(usuario,clave);
            if(usuario.equals(beanusu.getUsuario())){
                if(clave.equals(beanusu.getPassword())){
                    if(estadousu.equals(beanusu.getEstado())){
                      //  request.setAttribute("v","1");
                        request.getSession().setAttribute("parametroCodigo",beanusu.getUsuario());
                           response.sendRedirect("panel.jsp");
                    }else{ response.sendRedirect("index.jsp?mens='Usted ha sido inhabilitado del sistema"); request.setAttribute("v","0"); }
                }else{ response.sendRedirect("index.jsp?mens='Credenciales Incorrectas'"); request.setAttribute("v","0");}
            }else{ response.sendRedirect("index.jsp?mens='Credenciales Incorrectas'"); request.setAttribute("v","0");}
        }catch (Exception ex){
            out.println(ex);
            
        }
    }
    
    
    private void Logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
    
    
    
    
    

}
