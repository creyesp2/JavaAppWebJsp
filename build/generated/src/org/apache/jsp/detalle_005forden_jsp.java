package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Dao.DaoUsuario_DB;
import Dao.BeanUsuario;
import Bean.BeanDetalleOrden;
import java.util.ArrayList;
import Dao.DaoDetalleOrden;

public final class detalle_005forden_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/header.jsp", out, false);
      out.write('\n');
 
      String usuario = (String)session.getAttribute("parametroCodigo");
       System.out.println(usuario);
               BeanUsuario usu = DaoUsuario_DB.listarUsuario(usuario);    
            
            if(usu.getNombres() != null){ 
                     
            String usuarioLog = usu.getNombres()+ ", " + usu.getApellidos();
            Integer x=usu.getEstado();
            }else{
                 response.sendRedirect("index.jsp");
            }
      
      out.write("\n");
      out.write("<br>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("  <div class=\"\">\n");
      out.write("    <div class=\"panel panel-default table-responsive\" >\n");
      out.write("      <table class=\"table table-fixed\" >\n");
      out.write("        <thead>\n");
      out.write("          <tr>\n");
      out.write("            <th class=\"col-xs-1\"   style=\"background: #46b8da; color:#fff;font-size: 12px;\">ORDEN VENTA</th>\n");
      out.write("            <th class=\"col-xs-1\"  style=\"background: #46b8da; color:#fff;font-size: 12px;\">POSICION</th>\n");
      out.write("            <th class=\"col-xs-1\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">COD.  ARTIC</th>\n");
      out.write("            <th class=\"col-xs-1\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">PEDIDO</th>\n");
      out.write("            <th class=\"col-xs-1\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">DESPACHADO</th>\n");
      out.write("            <th class=\"col-xs-1\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">TOTAL</th>\n");
      out.write("            <th class=\"col-xs-1\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">VALOR VENTA</th>\n");
      out.write("            <th class=\"col-xs-1\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">IVA</th>\n");
      out.write("            <th class=\"col-xs-2\" style=\"background: #46b8da; color:#fff;font-size: 12px;\">IMPORTE TOTAL</th>\n");
      out.write("           \n");
      out.write("          </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

            ArrayList<BeanDetalleOrden>lstDetalleOrden = DaoDetalleOrden.ListarDetalleOrden();
            for(int i=0;i<lstDetalleOrden.size();i++){
                BeanDetalleOrden beando = lstDetalleOrden.get(i);
           
            
      out.write("\n");
      out.write("          <tr>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getNUM_ORDEN_VENTA() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getNUMERO_POSICION() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getCOD_ARTICULO() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getCANTIDAD_PEDIDA() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getCANTIDAD_DESPACHADA() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getPRECIO_TOTAL() );
      out.write("</td>\n");
      out.write("          \n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getVALOR_VENTA() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-1\">");
      out.print(beando.getIVA() );
      out.write("</td>\n");
      out.write("            <td class=\"col-xs-2\">");
      out.print(beando.getIMPORTE_TOTAL() );
      out.write("</td>  \n");
      out.write("         \n");
      out.write("          </tr>\n");
      out.write("          ");
 }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("      </table>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<style>\n");
      out.write("    .table-fixed thead {\n");
      out.write("  width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed tbody {\n");
      out.write("  height: 150px;\n");
      out.write("  overflow-y: auto;\n");
      out.write("  width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed thead,\n");
      out.write(".table-fixed tbody,\n");
      out.write(".table-fixed tr,\n");
      out.write(".table-fixed td,\n");
      out.write(".table-fixed th {\n");
      out.write("  display: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed tbody td,\n");
      out.write(".table-fixed thead>tr>th {\n");
      out.write("  float: left;\n");
      out.write("  border-bottom-width: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed thead {\n");
      out.write("  width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed tbody {\n");
      out.write("  height: 230px;\n");
      out.write("  overflow-y: auto;\n");
      out.write("  width: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed thead,\n");
      out.write(".table-fixed tbody,\n");
      out.write(".table-fixed tr,\n");
      out.write(".table-fixed td,\n");
      out.write(".table-fixed th {\n");
      out.write("  display: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".table-fixed tbody td,\n");
      out.write(".table-fixed thead>tr>th {\n");
      out.write("  float: left;\n");
      out.write("  border-bottom-width: 0;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write(" ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/footer.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
