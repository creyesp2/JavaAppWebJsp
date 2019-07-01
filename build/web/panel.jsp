<%@page import="Dao.DaoUsuario_DB"%>
<%@page import="Dao.BeanUsuario"%>
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
<br><br><br><br>
<div class="col-xs-12 ">
    <div class="container">
        <div  class="col-xs-8 col-md-3 col-lg-3 ">
            <a href="cliente.jsp" id="categori-13"  class="text-center">            
                <div class="col-md-12 center-block">
                     <span class="fa fa-address-card-o fa-5x" aria-hidden="true"></span>
                </div>
                <div class="col-xs-12 center-block">
                    <label class="text-center">Usuarios</label>
                </div>               
            </a>
        </div>
        
         <div  class="col-xs-8 col-md-3 col-lg-3  ">
            <a href="articulo.jsp" id="categori-13"  class="text-center">            
                <div class="col-md-12 center-block">
                     <span class="fa fa-shopping-basket fa-5x" aria-hidden="true"></span>
                </div>
                <div class="col-xs-12 center-block">
                    <label class="text-center">Peces</label>
                </div>               
            </a>
        </div>
        
        <div  class="col-xs-8 col-md-3 col-lg-3">
            <a href="detalle_orden.jsp" id="categori-13"  class="text-center">            
                <div class="col-md-12 center-block">
                     <span class="fa fa-bar-chart fa-5x" aria-hidden="true"></span>
                </div>
                <div class="col-xs-12 center-block">
                    <label class="text-center">Reporte Factura</label>
                </div>               
            </a>
        </div>
        
        <div  class="col-xs-8 col-md-3 col-lg-3">
            <a href="orden_venta.jsp" id="categori-13"  class="text-center">            
                <div class="col-md-12 center-block">
                     <span class="	fa fa-cart-plus fa-5x" aria-hidden="true"></span>
                </div>
                <div class="col-xs-12 center-block">
                    <label class="text-center">Ventas</label>
                </div>               
            </a>
        </div>
        
        <div  class="col-xs-8 col-md-3 col-lg-3">
            <a href="proveedor.jsp" id="categori-13"  class="text-center">            
                <div class="col-md-12 center-block">
                     <span class="	fa fa-cart-plus fa-5x" aria-hidden="true"></span>
                </div>
                <div class="col-xs-12 center-block">
                    <label class="text-center">Proveedores</label>
                </div>               
            </a>
        </div>
        
        
    </div>
</div>
   <jsp:include page="include/footer.jsp" />