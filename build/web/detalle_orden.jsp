<%@page import="Dao.DaoUsuario_DB"%>
<%@page import="Dao.BeanUsuario"%>
<%@page import="Bean.BeanDetalleOrden" %>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.DaoDetalleOrden"%>
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
<div class="container-fluid">
  <div class="">
    <div class="panel panel-default table-responsive" >
      <table class="table table-fixed" >
        <thead>
          <tr>
            <th class="col-xs-1"   style="background: #46b8da; color:#fff;font-size: 12px;">ORDEN VENTA</th>
            <th class="col-xs-1"  style="background: #46b8da; color:#fff;font-size: 12px;">POSICION</th>
            <th class="col-xs-1" style="background: #46b8da; color:#fff;font-size: 12px;">COD.  PEZ</th>
            <th class="col-xs-1" style="background: #46b8da; color:#fff;font-size: 12px;">PEDIDO</th>
            <th class="col-xs-1" style="background: #46b8da; color:#fff;font-size: 12px;">DESPACHADO</th>
            <th class="col-xs-1" style="background: #46b8da; color:#fff;font-size: 12px;">TOTAL</th>
            <th class="col-xs-2" style="background: #46b8da; color:#fff;font-size: 12px;">VALOR VENTA</th>
            <th class="col-xs-2" style="background: #46b8da; color:#fff;font-size: 12px;">IVA</th>
            <th class="col-xs-2" style="background: #46b8da; color:#fff;font-size: 12px;">IMPORTE TOTAL</th>
           
          </tr>
        </thead>
        <tbody>
            <%
            ArrayList<BeanDetalleOrden>lstDetalleOrden = DaoDetalleOrden.ListarDetalleOrden();
            for(int i=0;i<lstDetalleOrden.size();i++){
                BeanDetalleOrden beando = lstDetalleOrden.get(i);
           
            %>
          <tr>
            <td class="col-xs-1"><%=beando.getNUM_ORDEN_VENTA() %></td>
            <td class="col-xs-1"><%=beando.getNUMERO_POSICION() %></td>
            <td class="col-xs-1"><%=beando.getCOD_ARTICULO() %></td>
            <td class="col-xs-1"><%=beando.getCANTIDAD_PEDIDA() %></td>
            <td class="col-xs-1"><%=beando.getCANTIDAD_DESPACHADA() %></td>
            <td class="col-xs-1"><%=beando.getPRECIO_TOTAL() %></td>
          
            <td class="col-xs-2"><%=beando.getVALOR_VENTA() %></td>
            <td class="col-xs-2"><%=beando.getIVA() %></td>
            <td class="col-xs-2"><%=beando.getIMPORTE_TOTAL() %></td>  
         
          </tr>
          <% }
            %>
        </tbody>
      </table>
    </div>
  </div>
</div>
<style>
    .table-fixed thead {
  width: 100%;
}

.table-fixed tbody {
  height: 150px;
  overflow-y: auto;
  width: 100%;
}

.table-fixed thead,
.table-fixed tbody,
.table-fixed tr,
.table-fixed td,
.table-fixed th {
  display: block;
}

.table-fixed tbody td,
.table-fixed thead>tr>th {
  float: left;
  border-bottom-width: 0;
}

.table-fixed thead {
  width: 100%;
}

.table-fixed tbody {
  height: 230px;
  overflow-y: auto;
  width: 100%;
}

.table-fixed thead,
.table-fixed tbody,
.table-fixed tr,
.table-fixed td,
.table-fixed th {
  display: block;
}

.table-fixed tbody td,
.table-fixed thead>tr>th {
  float: left;
  border-bottom-width: 0;
}
</style>

 <jsp:include page="include/footer.jsp" />