package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Dao.DaoUsuario_DB;
import Dao.BeanUsuario;
import Dao.DaoDetalleOrden;
import Bean.BeanClientes;
import java.util.ArrayList;
import Dao.DaoCliente;

public final class cliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"container\" style=\"width: 98%;\">\n");
      out.write("<div class=\"panel panel-info\">\n");
      out.write("  <div class=\"panel-heading\">Registrar Clientes</div>\n");
      out.write("  <div class=\"panel-body\">\n");
      out.write("      <form name=\"formcliente\" id=\"formcliente\"  action=\"Servlet_Cliente\" method=\"post\">\n");
      out.write("   <input type=\"hidden\" name=\"accion\" id=\"accion\" value=\"insertarcliente\">\n");
      out.write("          <div class=\"form-row\">\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"\">Codigo Cliente</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_codigo\" name=\"txt_codigo\" placeholder=\"\" required>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"inputState\">Estado de Cliente</label>\n");
      out.write("      <select id=\"txt_estadocliente\"  name=\"txt_estadocliente\"  class=\"form-control\">\n");
      out.write("        <option selected id=\"\">Seleccione..</option>\n");
      out.write("        <option  value=\"0\">Inactivo</option>\n");
      out.write("        <option  value=\"1\">Activo</option>\n");
      out.write("      </select>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"txt_ruc\">DPI</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_ruc\" name=\"txt_ruc\" placeholder=\"\" required>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write(" \n");
      out.write("  <div class=\"form-row\">\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"nombre\">Nombres</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_nombre\" name=\"txt_nombre\" required>\n");
      out.write("    </div>\n");
      out.write("     <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"direccion\">Direccion</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_direccion\" name=\"txt_direccion\" required>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"ciudad\">Ciudad</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_ciudad\"  name=\"txt_ciudad\" required>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("          \n");
      out.write("          <div class=\"form-row\">\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"fecha\">Fecha Ingreso</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_fecha\" name=\"txt_fecha\"  required>\n");
      out.write("    </div>\n");
      out.write("     <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"email\">Email</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_email\" name=\"txt_email\"  required>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"telefono\">Telefono</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_telefono\"  name=\"txt_telefono\"  required>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("          \n");
      out.write("     <div class=\"form-row\">\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"tipo\">Tipo Cliente</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_tipocliente\" name=\"txt_tipocliente\" required>\n");
      out.write("    </div>\n");
      out.write("     <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"credito_s\">Limite de Credito S</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_credito_s\" name=\"txt_credito_s\" required>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"form-group col-md-4\">\n");
      out.write("      <label for=\"credito_d\">Limite de Credito D</label>\n");
      out.write("      <input type=\"text\" class=\"form-control\" id=\"txt_credito_d\" name=\"txt_credito_d\" required>\n");
      out.write("    </div>\n");
      out.write("  </div>     \n");
      out.write("    <input type=\"button\" class=\"btn btn-primary\" name=\"btnRegistrarCliente\" id=\"btnRegistrarCliente\" value=\"Registrar Cliente\">\n");
      out.write("</form>\n");
      out.write("      ");

             if(request.getParameter("std")!=null){
                 if(request.getParameter("std").equals("1")){
                    out.println("<br><p class='alert alert-success'><button type='butto' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button> <a href='cliente.jsp' class='alert-link'>"+request.getParameter("mens")+"</a></p>");
                }else if(request.getParameter("std").equals("0")){
                out.println("<br><p class='alert alert-danger'><button type='butto' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button> <a href='cliente.jsp' class='alert-link'>"+request.getParameter("mens")+"</a></p>");
            }
                }
            
      out.write("\n");
      out.write("      \n");
      out.write("      <br>\n");
      out.write("      <div class=\"panel panel-info\">\n");
      out.write("        <div class=\"panel-heading\">Lista de Cliente</div>\n");
      out.write("            <div class=\"table-responsive\">\n");
      out.write("               \n");
      out.write("                <table class=\"table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Codigo</th>\n");
      out.write("                            <th>Estado</th>\n");
      out.write("                            <th>DPI</th>\n");
      out.write("                            <th>Nombres</th>\n");
      out.write("                            <th>Dirección</th>\n");
      out.write("                            <th>Ciudad</th>\n");
      out.write("                            <th>Fecha</th>\n");
      out.write("                            <th>Cliente</th>\n");
      out.write("                            <th>Credito S/.</th>\n");
      out.write("                            <th>Credito $.</th>\n");
      out.write("                            <th>Email</th>\n");
      out.write("                            <th>Telefono</th>\n");
      out.write("                            <th></th>                            \n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                     ");

            //     ArrayList<BeanClientes>lstClientes = DaoDetalleOrden.ClienteLista();
//              ArrayList<BeanCliente>lstCliente = DaoCliente.ListarClientes();.
             ArrayList<BeanClientes>lstClientes = DaoCliente.ListarClientes();
                     for(int i=0;i<lstClientes.size();i++){
                         BeanClientes beanclien=lstClientes.get(i);
                     
                     
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(beanclien.getCOD_CLIENTE() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getESTADO_CLIENTE() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getRUC() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getNOMBRE() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getDIRECCION() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getCIUDAD() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getFECHA_INGRESO() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getTIPO_CLIENTE() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getLIMITE_CREDITO_S() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getLIMITE_CREDITO_D() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getEMAIL() );
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(beanclien.getTELEFONO() );
      out.write("</td>\n");
      out.write("                            <td><button type=\"button\" class=\"btn btn-danger btn-xs\" aria-label=\"Left Align\" onclick=\"location.href='Servlet_Cliente?codigCliente=");
      out.print(beanclien.getCOD_CLIENTE() );
      out.write("&&accion=eliminar'\">\n");
      out.write("  <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span>\n");
      out.write("</button>\n");
      out.write("                       <!--         <button type=\"button\" class=\"btn btn-info\" aria-label=\"Left Align\"  >\n");
      out.write("  <span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>\n");
      out.write("</button> -->\n");
      out.write("                            \n");
      out.write("                       <button type=\"button\" class=\"btn btn-info btn-xs\" aria-label=\"Left Align\" data-toggle=\"modal\" data-target=\"#myModalmodificaCliente\" id=\"btnModificar\" name=\"btnModificar\" \n");
      out.write("                               onclick=\"ModificaCliente('");
      out.print(beanclien.getCOD_CLIENTE() );
      out.write("','");
      out.print(beanclien.getESTADO_CLIENTE() );
      out.write("','");
      out.print(beanclien.getRUC() );
      out.write("', '");
      out.print(beanclien.getNOMBRE() );
      out.write("','");
      out.print(beanclien.getDIRECCION() );
      out.write("','");
      out.print(beanclien.getCIUDAD() );
      out.write("',' ");
      out.print(beanclien.getFECHA_INGRESO() );
      out.write("','");
      out.print(beanclien.getTIPO_CLIENTE() );
      out.write("','");
      out.print(beanclien.getLIMITE_CREDITO_S() );
      out.write("','");
      out.print(beanclien.getLIMITE_CREDITO_D() );
      out.write("', '");
      out.print(beanclien.getEMAIL() );
      out.write("','");
      out.print(beanclien.getTELEFONO() );
      out.write("')\">\n");
      out.write("  <span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>\n");
      out.write("</button></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
   }
                     
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("      \n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("                    \n");
      out.write(" <!-- Modal modifica articulo-->\n");
      out.write("  <div class=\"modal fade\" id=\"myModalmodificaCliente\" role=\"dialog\">\n");
      out.write("    <div class=\"modal-dialog modal-sm\" style=\"position: center;\" >\n");
      out.write("      <div class=\"modal-content\" style=\"width: 500px;\">\n");
      out.write("          <div class=\"modal-header\" style=\"background-color: #46b8da;  border-radius: 5px 5px 0px 0px;color:#ffffff;\" >\n");
      out.write("       <!--   <button type=\"button\" class=\"close btn-danger\" data-dismiss=\"modal\"> <span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span></button>-->\n");
      out.write("         <button type=\"button\" class=\"btn btn-danger btn-sm  pull-right\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\" class=\"glyphicon glyphicon-remove\"></span>\n");
      out.write("        </button>         \n");
      out.write("          <h4 class=\"modal-title\">Editar Cliente</h4>\n");
      out.write("           \n");
      out.write("        </div>\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("            <form action=\"Servlet_Cliente\" method=\"post\"  id=\"frmModificarCliente\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                   <input type=\"hidden\" name=\"accion\" id=\"accion\" value=\"actualizar\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Codigo:</label>\n");
      out.write("              <div id=\"codigo_c\"> <input type=\"text\" class=\"form-control\" id=\"txt_codigo\" name=\"txt_codigo\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Estado:</label>\n");
      out.write("              <div id=\"estado_c\"><input type=\"text\" class=\"form-control\" id=\"txt_estadocliente\"  name=\"txt_estadocliente\"></div>\n");
      out.write("            </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Ruc:</label>\n");
      out.write("              <div id=\"ruc_c\"> <input type=\"text\" class=\"form-control\" id=\"txt_ruc\" name=\"txt_ruc\"></div>\n");
      out.write("            </div>\n");
      out.write("               <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Nombre:</label>\n");
      out.write("              <div id=\"nombre_c\"><input type=\"text\" class=\"form-control\" id=\"txt_nombre\"  name=\"txt_nombre\"></div>\n");
      out.write("            </div>  \n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Direccion</label>\n");
      out.write("              <div id=\"direccion_c\"><input type=\"text\" class=\"form-control\" id=\"txt_direccion\"  name=\"txt_direccion\"></div>\n");
      out.write("            </div>  \n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Ciudad</label>\n");
      out.write("              <div id=\"ciudad_c\"><input type=\"text\" class=\"form-control\" id=\"txt_ciudad\"  name=\"txt_ciudad\"></div>\n");
      out.write("            </div> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Fecha:</label>\n");
      out.write("              <div id=\"fecha_c\"><input type=\"text\" class=\"form-control\" id=\"txt_fecha\"  name=\"txt_fecha\"></div>\n");
      out.write("            </div>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Tipo:</label>\n");
      out.write("              <div id=\"tipo_c\"><input type=\"text\" class=\"form-control\" id=\"txt_tipocliente\"  name=\"txt_tipocliente\"></div>\n");
      out.write("            </div>  \n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Limite Credito S/.:</label>\n");
      out.write("              <div id=\"limites_c\"><input type=\"text\" class=\"form-control\" id=\"txt_credito_s\"  name=\"txt_credito_s\"></div>\n");
      out.write("            </div>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Limite Credito $:</label>\n");
      out.write("              <div id=\"limited_c\"><input type=\"text\" class=\"form-control\" id=\"txt_credito_d\"  name=\"txt_credito_d\"></div>\n");
      out.write("            </div>  \n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Email:</label>\n");
      out.write("              <div id=\"email_c\"><input type=\"text\" class=\"form-control\" id=\"txt_email\"  name=\"txt_email\"></div>\n");
      out.write("            </div>  \n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("              <label for=\"\">Telefono:</label>\n");
      out.write("              <div id=\"telefono_c\"><input type=\"text\" class=\"form-control\" id=\"txt_telefono\"  name=\"txt_telefono\"></div>\n");
      out.write("                   </div>  </div>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-success\">Actualizar Cliente</button>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("        <!--<div class=\"modal-footer\">\n");
      out.write("          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("        </div> -->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
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
