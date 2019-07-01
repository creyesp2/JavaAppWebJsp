<%@page import="java.util.ArrayList" %>
<%@page import="Dao.*" %>
<%@page import="Bean.*" %>
<jsp:include page="include/header.jsp" />
<% 
      String usuario = (String)session.getAttribute("parametroCodigo");
      System.out.println(usuario);
               BeanUsuario usu = DaoUsuario_DB.listarUsuario(usuario);    
            
            if(usu.getNombres() != null){ 
                     
            String usuarioLog = usu.getNombres()+ ", " + usu.getApellidos();
            Integer x=usu.getEstado();
            }else{
                 response.sendRedirect("index.jsp");
            }
      
    
     
      %>
<br>
 <div class="container" style="width: 90%;">
<div class="panel panel-info">
    <div class="panel-heading">Registro de Proveedores</div>
    <div class="panel-body">
       
            <form class="form-inline" name="formarticulo" id="formarticulo" action="Servlet_Proveedor" method="post" >
                <input type="hidden" name="accion" id="accion" value="insertar">
                <div class="form-group">
                    <label for="codigo">Codigo</label>
                    <div>
                        <input type="text" class="form-control textBox" id="txt_codigo" name="txt_codigo">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="proveedor">Nombre</label>
                    <div>
                        <input type="text" class="form-control textBox" id="txt_descripcion" name="txt_proveedor">
                    </div>
                </div> 
                 <div class="form-group">
                    <label for="proveedor">NIT</label>
                    <div>
                        <input type="text" class="form-control textBox" id="txt_codigo" name="txt_dpi">
                    </div>
                </div>
               
                <div class="form-group">
                    <label for="cantidad">cantidad</label>
                    <div>
                        <input type="text" class="form-control textBox" id="txt_stock"  name="txt_cantidad">
                    </div>
                </div>
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <div>
                        <input type="text" class="form-control textBox" id="txt_precio" name="txt_precio">
                    </div>
                </div> 
               
                <div class="form-group">
                    <label >&nbsp</label>
                    <div>
                        <input type="button" class="btn btn-success button" name="btnRegistrar" id="btnRegistrar" value="Registrar">
                    </div>
                </div>  
                 

            </form>
        <%
//                if(request.getParameter("std")!=null){
//             out.println(request.getParameter("mens"));
//        }
           
            //String std=request.getParameter("std");
            
           // if(request.getParameter("std")=="'1'"){
             if(request.getParameter("std")!=null){
                 if(request.getParameter("std").equals("1")){
                    out.println("<br><p class='alert alert-success'><button type='butto' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button> <a href='articulo.jsp' class='alert-link'>"+request.getParameter("mens")+"</a></p>");
                }else if(request.getParameter("std").equals("0")){
                out.println("<br><p class='alert alert-danger'><button type='butto' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button> <a href='articulo.jsp' class='alert-link'>"+request.getParameter("mens")+"</a></p>");
            }
                }
            %>
        <br>
        <div class="panel panel-info">
        <div class="panel-heading">Lista de Proveedores</div>
            <div class="table-responsive">
               
                <table class="table">
                    <thead>
                        <tr>
                            <th>CODIGO</th>
                            <th>PROVEEDOR</th>
                            <th>NIT</th>
                            <th>CANTIDAD</th>
                            <th>PRECIO</th>
                            <th></th>                            
                        </tr>
                    </thead>
                    <tbody>
                     <%
                     ArrayList<BeanProveedor>lstProveedor=DaoProveedor_DB.ObtenerProveedor();
                     for(int i=0;i<lstProveedor.size();i++){
                         BeanProveedor beanPro=lstProveedor.get(i);
                     
                     %>
                        <tr>
                            <td><%=beanPro.getCOD_PROVEEDOR() %></td>
                            <td><%=beanPro.getNOMBRE_PROVEEDOR() %></td>
                            <td><%=beanPro.getDPI() %></td>
                            <td><%=beanPro.getCANTIDAD() %></td>
                            <td><%=beanPro.getPRECIO() %></td>
                            <td><button type="button" class="btn btn-danger" aria-label="Left Align" onclick="location.href='Servlet_Proveedor?codigPro=<%=beanPro.getCOD_PROVEEDOR()  %>&&accion=eliminar'">
  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
</button>
                       <!--         <button type="button" class="btn btn-info" aria-label="Left Align"  >
  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
</button> -->
                            
                       <button type="button" class="btn btn-info" aria-label="Left Align" data-toggle="modal" data-target="#myModalmodificaArticulo" id="btnModificar" name="btnModificar" onclick="ModificaProveedor('<%=beanPro.getCOD_PROVEEDOR()  %>','<%=beanPro.getNOMBRE_PROVEEDOR() %>','<%=beanPro.getDPI() %>','<%=beanPro.getCANTIDAD() %>','<%=beanPro.getPRECIO() %>')">
  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
</button></td>
                        </tr>
                        <%   }
                     %>
                    </tbody>
                </table>
            </div>
        </div>
                    
        </div>
    </div>
</div>

<!-- Modal modifica articulo-->
  <div class="modal fade" id="myModalmodificaArticulo" role="dialog" >
    <div class="modal-dialog modal-sm" >
      <div class="modal-content">
          <div class="modal-header" style="background-color: #46b8da;  border-radius: 5px 5px 0px 0px;color:#ffffff;" >
       <!--   <button type="button" class="close btn-danger" data-dismiss="modal"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>-->
         <button type="button" class="btn btn-danger btn-sm  pull-right" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="glyphicon glyphicon-remove"></span>
        </button>         
          <h4 class="modal-title">Editar Articulo</h4>
           
        </div>
        <div class="modal-body">
            <form action="Servlet_Proveedor" method="post"  id="frmModificarArt">
                   <input type="hidden" name="accion" id="accion" value="actualizar">
            <div class="form-group">
              <label for="mtxt_codigo">Codigo:</label>
              <div id="codigo"> <input type="text" class="form-control" id="mtxt_codigo" name="mtxt_codigo"></div>
            </div>
            <div class="form-group">
              <label for="mtxt_nombre">Nombre:</label>
              <div id="descripcion"><input type="text" class="form-control" id="mtxt_descripcion"  name="mtxt_nombre"></div>
            </div>
               <div class="form-group">
              <label for="mtxt_dpi">DPI:</label>
              <div id="descripcion"><input type="text" class="form-control" id="mtxt_descripcion"  name="mtxt_dpi"></div>
            </div>      
               <div class="form-group">
              <label for="mtxt_cantidad">cantidad:</label>
              <div id="stock"> <input type="text" class="form-control" id="mtxt_stock" name="mtxt_cantidad"></div>
            </div>
               <div class="form-group">
              <label for="mtxt_precio">Precio:</label>
              <div id="precio"><input type="text" class="form-control" id="mtxt_precio"  name="mtxt_precio"></div>
            </div>            
            <button type="submit" class="btn btn-success">Actualizar</button>
          </form>
        </div>
        <!--<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
      </div>
    </div>
  </div>
</div>
 <jsp:include page="include/footer.jsp" />