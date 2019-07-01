/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.BeanCarrito;
import Bean.BeanOrdenVenta;
import Conexion.Conexion;
import Dao.DaoOrdenVenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LEO
 */
public class Servlet_Carrito extends HttpServlet {

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
             
             if (accion.equals("anadirClientecarrito")) {
                this.AnadirClienteCarrito(request, response);
            }
            if (accion.equals("anadirCarrito")) {
                this.AnadirCarrito(request, response);
            }
            if (accion.equals("elimina_de_Carrito")) {
                this.EliminaDeCarrito(request, response);
            }
             if (accion.equals("registrarVenta")) {
                this.RegistrarVenta(request, response);
            }
        }
    }
    
    /* AÑADIR CLIENTE SESSION */
    @SuppressWarnings("unchecked")
    private void AnadirClienteCarrito(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException{
        
        HttpSession sessionCliente;
       BeanCarrito bcliente;
        ArrayList<BeanCarrito> listasesioncliente;
        sessionCliente= request.getSession(false);
        listasesioncliente=(ArrayList<BeanCarrito>) sessionCliente.getAttribute("carroclienteCompras");
        if(listasesioncliente == null){
            listasesioncliente=new ArrayList<BeanCarrito>();
            sessionCliente.setAttribute("carroclienteCompras", listasesioncliente);        
        }
         bcliente=new BeanCarrito();
         System.out.println(request.getParameter("codCliente")+"-"+request.getParameter("nomCliente")+request.getParameter("dirCliente")+request.getParameter("orden"));
         bcliente.setCODIGO_CLIENTE(request.getParameter("codCliente"));
         bcliente.setNOM_CLIENTE(request.getParameter("nomCliente"));
         bcliente.setDIR_CLIENTE(request.getParameter("dirCliente"));
         bcliente.setEMAIL_CLIENTE(request.getParameter("EmailCliente"));
         bcliente.setTELF_CLIENTE(request.getParameter("telfCliente"));
         bcliente.setNUM_ORDEN_VENTA(Integer.parseInt(request.getParameter("orden")));
         bcliente.setFECHA_VENTA(request.getParameter("fecha"));
         
           int indice=-1;
        for(int i=0;i<listasesioncliente.size();i++){
            BeanCarrito clienteB=listasesioncliente.get(i);
            
            if(clienteB.getCODIGO_CLIENTE()==bcliente.getCODIGO_CLIENTE()){
                indice=i;
                break;
            }
        }
         if(indice==-1){
             listasesioncliente.add(bcliente);                
         }else{
             listasesioncliente.set(indice,bcliente);                
         }
         sessionCliente.setAttribute("carroclienteCompras", listasesioncliente);        
        response.sendRedirect("orden_venta.jsp?mens=Se Asigno Cliente");      
    }
    
    /* AÑADIR A CARRITO */
     private void AnadirCarrito(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException{
       HttpSession session;
       BeanCarrito bproducto;
        ArrayList<BeanCarrito> lstProducto;
        session= request.getSession(false);
        
        lstProducto=(ArrayList<BeanCarrito>) session.getAttribute("carroCompras");
        
        if(lstProducto == null){
            lstProducto=new ArrayList<BeanCarrito>();
            session.setAttribute("carroCompras", lstProducto);
        
        }
    bproducto=new BeanCarrito();
      bproducto.setNUM_ORDEN_VENTA(Integer.parseInt(request.getParameter("numOrden")));
        bproducto.setNUMERO_POSICION(Integer.parseInt(request.getParameter("num_posicion")));
        bproducto.setCOD_ARTICULO(request.getParameter("codigocompra"));//id producto
        bproducto.setNOM_ARTICULO(request.getParameter("descripcioncompra"));// nombre de articulo
        bproducto.setPRECIO_ARTICULO(Double.parseDouble(request.getParameter("preciocompra")));//precio articulo
        bproducto.setCANTIDAD_PEDIDA(Integer.parseInt(request.getParameter("cantidadcompra")));
        bproducto.setCANTIDAD_DESPACHADA(Integer.parseInt(request.getParameter("cantidadcompra")));        
        Integer cantidad=Integer.parseInt(request.getParameter("cantidadcompra"));
        Double precio_producto=Double.parseDouble(request.getParameter("preciocompra"));
        Double importe=cantidad*precio_producto;      
        bproducto.setIMPORTE(importe);
        
        
        int indice=-1;
        for(int i=0;i<lstProducto.size();i++){
            BeanCarrito productoB=lstProducto.get(i);
            
            if(productoB.getCOD_ARTICULO()==bproducto.getCOD_ARTICULO()){
                indice=i;
                break;
            }
        }
         if(indice==-1){
             lstProducto.add(bproducto);
         }else{
             lstProducto.set(indice,bproducto);
         }
         session.setAttribute("carroCompras", lstProducto);
        response.sendRedirect("orden_venta.jsp?mens=Se Agrego producto");
    }

     
     /* ELIMINA DE CARRITO */
      private void EliminaDeCarrito(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException{
        HttpSession session;
       BeanCarrito bproducto;
        ArrayList<BeanCarrito> lstProducto;
        session= request.getSession(false);
            lstProducto=(ArrayList<BeanCarrito>) session.getAttribute("carroCompras");
            lstProducto.remove(Integer.parseInt(request.getParameter("codigArticulo")));
             response.sendRedirect("orden_venta.jsp");
    }
      
       private void RegistrarVenta(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException{
           
            HttpSession session;
        BeanCarrito bproducto;
        ArrayList<BeanCarrito> lstProducto;
        session = request.getSession(false);
        lstProducto = (ArrayList<BeanCarrito>) session.getAttribute("carroCompras");
           
        Connection cn;
        Conexion con = new Conexion();
        cn = con.conectar();
           
        BeanOrdenVenta bc = new BeanOrdenVenta();
        bc.setNUM_ORDEN_VENTA(Integer.parseInt(request.getParameter("NOV")));
        bc.setCOD_CLIENTE(request.getParameter("cod_cliente"));
        bc.setFECHA_ORDEN(request.getParameter("FO"));
        bc.setDESCUENTO_ORDEN(Double.parseDouble(request.getParameter("DO")));
        
        boolean resp = DaoOrdenVenta.insertarOrdenVenta(bc);
        
         if (resp) {
            
            Integer num_orden = Integer.parseInt(request.getParameter("NOV"));
            String orden[] = request.getParameterValues("NOV");
            String num_posicion[] = request.getParameterValues("posicion");
            String cod_articulo[] = request.getParameterValues("codArticulo");
            String cant_pedido[] = request.getParameterValues("txtCantidad");
            String cant_desp[] = request.getParameterValues("txtCantidad");
            String precio_Total[] = request.getParameterValues("txtPrecio");
        ;
            String subtotal[] = request.getParameterValues("txtImporte");
            String igv[] = request.getParameterValues("igv");
            String importe_total[] = request.getParameterValues("costototalArt");//costo total por articulo
System.out.println(lstProducto.size());
            for (int x=0; x<orden.length; x++) {
                try {
                    PreparedStatement ps = cn.prepareStatement("insert into detalle_orden(NUM_ORDEN_VENTA,NUMERO_POSICION,COD_ARTICULO,CANTIDAD_PEDIDA,CANTIDAD_DESPACHADA,PRECIO_TOTAL,VALOR_VENTA,IGV,IMPORTE_TOTAL) values(?,?,?,?,?,?,?,?,?)");

                    ps.setString(1, orden[x]);
                    ps.setString(2, num_posicion[x]);
                    ps.setString(3, cod_articulo[x]);
                    ps.setString(4, cant_pedido[x]);
                    ps.setString(5, cant_desp[x]);
                    ps.setString(6, precio_Total[x]);
            
                    ps.setString(7, subtotal[x]);
                    ps.setString(8, igv[x]);
                    ps.setString(9, importe_total[x]);
                    int j = ps.executeUpdate();
                    if (j == 1) {
                        response.sendRedirect("orden_venta.jsp?mens='Se ha registrado su compra correctamente'");
                        lstProducto.clear();
                    } else {
                        response.sendRedirect("orden_venta.jsp?mens='Error al registrar su compra'");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else {
            response.sendRedirect("orden_venta.jsp?mens='Error al registrar su compra'");

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
