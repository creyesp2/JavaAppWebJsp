<%@page import="Dao.DaoUsuario_DB"%>
<%@page import="Dao.BeanUsuario"%>
<%@page import="Dao.DaoDetalleOrden"%>
<%@page import="Bean.BeanClientes" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.DaoCliente" %>
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
<div class="container" style="width: 98%;">
<div class="panel panel-info">
  <div class="panel-heading">Registrar Clientes</div>
  <div class="panel-body">
      <form name="formcliente" id="formcliente"  action="Servlet_Cliente" method="post">
   <input type="hidden" name="accion" id="accion" value="insertarcliente">
          <div class="form-row">
    <div class="form-group col-md-4">
      <label for="">Codigo Cliente</label>
      <input type="text" class="form-control" id="txt_codigo" name="txt_codigo" placeholder="" required>
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">Estado de Cliente</label>
      <select id="txt_estadocliente"  name="txt_estadocliente"  class="form-control">
        <option selected id="">Seleccione..</option>
        <option  value="0">Inactivo</option>
        <option  value="1">Activo</option>
      </select>
    </div>
      <div class="form-group col-md-4">
      <label for="txt_ruc">DPI</label>
      <input type="text" class="form-control" id="txt_ruc" name="txt_ruc" placeholder="" required>
    </div>
  </div>
 
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="nombre">Nombres</label>
      <input type="text" class="form-control" id="txt_nombre" name="txt_nombre" required>
    </div>
     <div class="form-group col-md-4">
      <label for="direccion">Direccion</label>
      <input type="text" class="form-control" id="txt_direccion" name="txt_direccion" required>
    </div>
    <div class="form-group col-md-4">
      <label for="ciudad">Ciudad</label>
      <input type="text" class="form-control" id="txt_ciudad"  name="txt_ciudad" required>
    </div>
  </div>
          
          <div class="form-row">
    <div class="form-group col-md-4">
      <label for="fecha">Fecha Ingreso</label>
      <input type="text" class="form-control" id="txt_fecha" name="txt_fecha"  required>
    </div>
     <div class="form-group col-md-4">
      <label for="email">Email</label>
      <input type="text" class="form-control" id="txt_email" name="txt_email"  required>
    </div>
    <div class="form-group col-md-4">
      <label for="telefono">Telefono</label>
      <input type="text" class="form-control" id="txt_telefono"  name="txt_telefono"  required>
    </div>
  </div>
          
     <div class="form-row">
    <div class="form-group col-md-4">
      <label for="tipo">Tipo Cliente</label>
      <input type="text" class="form-control" id="txt_tipocliente" name="txt_tipocliente" required>
    </div>
     <div class="form-group col-md-4">
      <label for="credito_s">Limite de Credito S</label>
      <input type="text" class="form-control" id="txt_credito_s" name="txt_credito_s" required>
    </div>
    <div class="form-group col-md-4">
      <label for="credito_d">Limite de Credito D</label>
      <input type="text" class="form-control" id="txt_credito_d" name="txt_credito_d" required>
    </div>
  </div>     
    <input type="button" class="btn btn-primary" name="btnRegistrarCliente" id="btnRegistrarCliente" value="Registrar Cliente">
</form>
      <%
             if(request.getParameter("std")!=null){
                 if(request.getParameter("std").equals("1")){
                    out.println("<br><p class='alert alert-success'><button type='butto' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button> <a href='cliente.jsp' class='alert-link'>"+request.getParameter("mens")+"</a></p>");
                }else if(request.getParameter("std").equals("0")){
                out.println("<br><p class='alert alert-danger'><button type='butto' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button> <a href='cliente.jsp' class='alert-link'>"+request.getParameter("mens")+"</a></p>");
            }
                }
            %>
      
      <br>
      <div class="panel panel-info">
        <div class="panel-heading">Lista de Cliente</div>
            <div class="table-responsive">
               
                <table class="table">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Estado</th>
                            <th>DPI</th>
                            <th>Nombres</th>
                            <th>Dirección</th>
                            <th>Ciudad</th>
                            <th>Fecha</th>
                            <th>Cliente</th>
                            <th>Credito S/.</th>
                            <th>Credito $.</th>
                            <th>Email</th>
                            <th>Telefono</th>
                            <th></th>                            
                        </tr>
                    </thead>
                    <tbody>
                     <%
            //     ArrayList<BeanClientes>lstClientes = DaoDetalleOrden.ClienteLista();
//              ArrayList<BeanCliente>lstCliente = DaoCliente.ListarClientes();.
             ArrayList<BeanClientes>lstClientes = DaoCliente.ListarClientes();
                     for(int i=0;i<lstClientes.size();i++){
                         BeanClientes beanclien=lstClientes.get(i);
                     
                     %>
                        <tr>
                            <td><%=beanclien.getCOD_CLIENTE() %></td>
                            <td><%=beanclien.getESTADO_CLIENTE() %></td>
                            <td><%=beanclien.getRUC() %></td>
                            <td><%=beanclien.getNOMBRE() %></td>
                            <td><%=beanclien.getDIRECCION() %></td>
                            <td><%=beanclien.getCIUDAD() %></td>
                            <td><%=beanclien.getFECHA_INGRESO() %></td>
                            <td><%=beanclien.getTIPO_CLIENTE() %></td>
                            <td><%=beanclien.getLIMITE_CREDITO_S() %></td>
                            <td><%=beanclien.getLIMITE_CREDITO_D() %></td>
                            <td><%=beanclien.getEMAIL() %></td>
                            <td><%=beanclien.getTELEFONO() %></td>
                            <td><button type="button" class="btn btn-danger btn-xs" aria-label="Left Align" onclick="location.href='Servlet_Cliente?codigCliente=<%=beanclien.getCOD_CLIENTE() %>&&accion=eliminar'">
  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
</button>
                       <!--         <button type="button" class="btn btn-info" aria-label="Left Align"  >
  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
</button> -->
                            
                       <button type="button" class="btn btn-info btn-xs" aria-label="Left Align" data-toggle="modal" data-target="#myModalmodificaCliente" id="btnModificar" name="btnModificar" 
                               onclick="ModificaCliente('<%=beanclien.getCOD_CLIENTE() %>','<%=beanclien.getESTADO_CLIENTE() %>','<%=beanclien.getRUC() %>', '<%=beanclien.getNOMBRE() %>','<%=beanclien.getDIRECCION() %>','<%=beanclien.getCIUDAD() %>',' <%=beanclien.getFECHA_INGRESO() %>','<%=beanclien.getTIPO_CLIENTE() %>','<%=beanclien.getLIMITE_CREDITO_S() %>','<%=beanclien.getLIMITE_CREDITO_D() %>', '<%=beanclien.getEMAIL() %>','<%=beanclien.getTELEFONO() %>')">
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
  <div class="modal fade" id="myModalmodificaCliente" role="dialog">
    <div class="modal-dialog modal-sm" style="position: center;" >
      <div class="modal-content" style="width: 500px;">
          <div class="modal-header" style="background-color: #46b8da;  border-radius: 5px 5px 0px 0px;color:#ffffff;" >
       <!--   <button type="button" class="close btn-danger" data-dismiss="modal"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>-->
         <button type="button" class="btn btn-danger btn-sm  pull-right" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="glyphicon glyphicon-remove"></span>
        </button>         
          <h4 class="modal-title">Editar Cliente</h4>
           
        </div>
        <div class="modal-body">
            <form action="Servlet_Cliente" method="post"  id="frmModificarCliente">
                <div class="col-md-6">
                   <input type="hidden" name="accion" id="accion" value="actualizar">
            <div class="form-group">
              <label for="">Codigo:</label>
              <div id="codigo_c"> <input type="text" class="form-control" id="txt_codigo" name="txt_codigo"></div>
            </div>
            <div class="form-group">
              <label for="">Estado:</label>
              <div id="estado_c"><input type="text" class="form-control" id="txt_estadocliente"  name="txt_estadocliente"></div>
            </div>
               <div class="form-group">
              <label for="">Ruc:</label>
              <div id="ruc_c"> <input type="text" class="form-control" id="txt_ruc" name="txt_ruc"></div>
            </div>
               <div class="form-group">
              <label for="">Nombre:</label>
              <div id="nombre_c"><input type="text" class="form-control" id="txt_nombre"  name="txt_nombre"></div>
            </div>  
                   <div class="form-group">
              <label for="">Direccion</label>
              <div id="direccion_c"><input type="text" class="form-control" id="txt_direccion"  name="txt_direccion"></div>
            </div>  
                   <div class="form-group">
              <label for="">Ciudad</label>
              <div id="ciudad_c"><input type="text" class="form-control" id="txt_ciudad"  name="txt_ciudad"></div>
            </div> 
                </div>
                <div class="col-md-6">
            <div class="form-group">
              <label for="">Fecha:</label>
              <div id="fecha_c"><input type="text" class="form-control" id="txt_fecha"  name="txt_fecha"></div>
            </div>
                   <div class="form-group">
              <label for="">Tipo:</label>
              <div id="tipo_c"><input type="text" class="form-control" id="txt_tipocliente"  name="txt_tipocliente"></div>
            </div>  
                   <div class="form-group">
              <label for="">Limite Credito S/.:</label>
              <div id="limites_c"><input type="text" class="form-control" id="txt_credito_s"  name="txt_credito_s"></div>
            </div>
                   <div class="form-group">
              <label for="">Limite Credito $:</label>
              <div id="limited_c"><input type="text" class="form-control" id="txt_credito_d"  name="txt_credito_d"></div>
            </div>  
                   <div class="form-group">
              <label for="">Email:</label>
              <div id="email_c"><input type="text" class="form-control" id="txt_email"  name="txt_email"></div>
            </div>  
                   <div class="form-group">
              <label for="">Telefono:</label>
              <div id="telefono_c"><input type="text" class="form-control" id="txt_telefono"  name="txt_telefono"></div>
                   </div>  </div>
            <button type="submit" class="btn btn-success">Actualizar Cliente</button>
          </form>
        </div>
        <!--<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
      </div>
    </div>
  </div>
 <jsp:include page="include/footer.jsp" />