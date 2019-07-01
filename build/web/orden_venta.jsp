<%@page import="java.text.DecimalFormatSymbols"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Bean.BeanCarrito"%>
<%@page import="Dao.DaoUsuario_DB"%>
<%@page import="Dao.BeanUsuario"%>
<%@page import="Bean.BeanOrdenVenta"%>
<%@page import="Dao.DaoOrdenVenta"%>
<%@page import="Dao.DaoDetalleOrden"%>
<%@page import="Bean.BeanDetalleOrden"%>
<%@page import="Dao.DaoArticulo_DB"%>
<%@page import="Bean.BeanArticulo"%>
<%@page import="Dao.DaoCliente"%>
<%@page import="Bean.BeanClientes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<jsp:include page="include/header.jsp" />
<% 
      String usuario = (String)session.getAttribute("parametroCodigo");     
               BeanUsuario usu = DaoUsuario_DB.listarUsuario(usuario);  
            if(usu.getNombres() != null){ 
            String usuarioLog = usu.getNombres()+ ", " + usu.getApellidos();
            Integer x=usu.getEstado();
            }else{
                 response.sendRedirect("index.jsp");
            }
      %>
<br>
<script>
    function hoyFecha(){
    var hoy = new Date();
        var dd = hoy.getDate();
        if(dd<10){
            dd='0'+dd;
        }  
         var mm = hoy.getMonth()+1;
         if(mm<10){
            mm='0'+mm;
        }
        var yyyy = hoy.getFullYear();

     var fecha_actual=yyyy+'-'+mm+'-'+dd;
   
    document.getElementById('fecha').innerHTML ='<input type="hidden" class="form-control textBox" id="txt_fechav" name="txt_fechav"  value="'+fecha_actual+'" style="width:120px;" ><label class="form-control"  id="txt_fechav" name="txt_fechav"  style="width:120px;" >'+fecha_actual+'</label>';

}
   
window.onload=hoyFecha;

</script>
<% 
    Date dNow = new Date();
   SimpleDateFormat ft = 
   new SimpleDateFormat ("YYYY-MM-dd");
   String fecha = ft.format(dNow);
                        %>
                        
<!-- ******* DATOS DE FACTURA **********  -->
 <%
            ArrayList<BeanOrdenVenta>lstOrdenVenta = DaoOrdenVenta.UltimaOrdenVenta();
            Integer numeroDeOrden=0;
            for(int i=0;i<lstOrdenVenta.size();i++){
                BeanOrdenVenta beanov = lstOrdenVenta.get(i);
                 numeroDeOrden=beanov.getNUM_ORDEN_VENTA()+1;
            }
 %>
<div class="container" style="width: 98%;background-color: #ffffff;" ><br>
<div class=" container form-inline well well-sm" style="background-color: #ffffff;" >
     <div class="form-group ">
                    <label for="fecha">Fecha Venta</label>
                    <div id="fecha" class="input-group-sm ">
                        <input type="hidden" class="form-control textBox" id="txt_fechav" name="txt_fechav"  value="" style="width:120px;">
                        
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Número de Orden</label>
                    <div class="input-group-sm">                       
                       <input type="hidden" class="form-control textBox" id="txt_nordenv" name="txt_nordenv" value="<%=numeroDeOrden%>" >
                        <label class="form-control textBox"  style="width:120px;" ><%=numeroDeOrden%></label>
                    </div>
                </div>
</div>
<!-- ******* DATOS DEL CLIENTE **********  -->
<%
            Integer numOrden = 0;
            Integer cod=0;
            String codCliente;
            codCliente="";
            String nomCliente;
            String telf_cliente, emailCliente, dirCliente;
            HttpSession sessionCliente = request.getSession(false);
            if (sessionCliente.getAttribute("carroclienteCompras") != null) { 
                ArrayList<BeanCarrito> listacliente = (ArrayList<BeanCarrito>) sessionCliente.getAttribute("carroclienteCompras");
             int x=0;
                for (x = listacliente.size()-1; x < listacliente.size(); x++) {
                    codCliente =listacliente.get(x).getCODIGO_CLIENTE();
                   // codCliente=new String(listacliente.get(x).getCODIGO_CLIENTE());
                   // cod=codCliente;
                    cod=Integer.parseInt(codCliente);
                    nomCliente = listacliente.get(x).getNOM_CLIENTE();
                    dirCliente = listacliente.get(x).getDIR_CLIENTE();
                    telf_cliente = listacliente.get(x).getTELF_CLIENTE();
                    emailCliente = listacliente.get(x).getEMAIL_CLIENTE();
                    numOrden = listacliente.get(x).getNUM_ORDEN_VENTA();
                    %>
                    <div class=" container form-inline well well-sm"  style="background-color: #ffffff;"  >
     <div class="form-group">
                    <label for="">Codigo Cliente </label>
                    <div id="" class="input-group-sm">
                        <label class=" form-control  textBox"  style="width:120px;" data-toggle="modal" data-target="#myModalbuscarCliente"><%= listacliente.get(x).getCODIGO_CLIENTE() %></label>
                        <input type="hidden" class="form-control textBox" id="txt_codigocliente_v" name="txt_codigocliente_v"  value="<%= listacliente.get(x).getCODIGO_CLIENTE() %>"  style="width:120px;" data-toggle="modal" data-target="#myModalbuscarCliente" id="btnModificar" name="btnBuscar">
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Nombre del Cliente  </label>                    
                    <div class="input-group-sm">
                        <label class="form-control  textBox"  style="width:300px;" ><%= listacliente.get(x).getNOM_CLIENTE() %></label>
                        <input type="hidden" class="form-control textBox" id="txt_nombrecliente_v" name="txt_nombrecliente_v" style="width:300px;" value="<%=listacliente.get(x).getNOM_CLIENTE()%>">
                    </div>
                </div>
    <div class="form-group">
                    <label for="">Direccion</label>                    
                    <div class="input-group-sm">
                        <label class="form-control  textBox"  style="width:300px;" ><%= listacliente.get(x).getDIR_CLIENTE() %></label>
                        <input type="hidden" class="form-control textBox" id="txt_direccioncliente_v" name="txt_direccioncliente_v" value="<%=listacliente.get(x).getDIR_CLIENTE()%>">
                    </div>
                </div>
    <div class="form-group">
                    <label for="">Telefono</label>                    
                    <div class="input-group-sm">
                        <label class="form-control  textBox"  style="width:120px;" ><%= listacliente.get(x).getTELF_CLIENTE() %></label>
                        <input type="hidden" class="form-control textBox" id="txt_telefonocliente_v" name="txt_telefonocliente_v" value="<%=listacliente.get(x).getTELF_CLIENTE()%>">
                    </div>
                </div>
    <div class="form-group">
                    <label for="">Email</label>                   
                    <div class="input-group-sm">
                         <label class=" form-control textBox"  style="width:250px;" ><%= listacliente.get(x).getEMAIL_CLIENTE() %></label>
                        <input type="hidden" class="form-control textBox" id="txt_emailcliente_v" name="txt_emailcliente_v" value="<%=listacliente.get(x).getEMAIL_CLIENTE()%>">
                    </div>
                </div>
</div>
       <%         }
            }else{  %>
            
            <div class=" container form-inline well well-sm"  style="background-color: #ffffff;"  >
     <div class="form-group">
                    <label for="">Codigo Cliente </label>
                    <div id="" class="input-group-sm">
                        <input type="text" class="form-control textBox" id="txt_codigocliente_v" name="txt_codigocliente_v"  value="<%=codCliente %>"  style="width:120px;" data-toggle="modal" data-target="#myModalbuscarCliente" id="btnModificar" name="btnBuscar">
                    </div>
                </div>
                <div class="form-group">
                    <label for="">Nombre del Cliente  </label>
                    <div class="input-group-sm">
                        <input type="text" class="form-control textBox" id="txt_nombrecliente_v" name="txt_nombrecliente_v" style="width:300px;">
                    </div>
                </div>
    <div class="form-group">
                    <label for="">Direccion</label>
                    <div class="input-group-sm">
                        <input type="text" class="form-control textBox" id="txt_direccioncliente_v" name="txt_direccioncliente_v" >
                    </div>
                </div>
    <div class="form-group">
                    <label for="">Telefono</label>
                    <div class="input-group-sm">
                        <input type="text" class="form-control textBox" id="txt_telefonocliente_v" name="txt_telefonocliente_v" >
                    </div>
                </div>
    <div class="form-group">
                    <label for="">Email</label>
                    <div class="input-group-sm">
                        <input type="text" class="form-control textBox" id="txt_emailcliente_v" name="txt_emailcliente_v" >
                    </div>
                </div>
</div>
            
            
        <%    } %>

<!-- ******** TABLA DE VENTA PRODUCTO ********* -->
<form action="Servlet_Carrito" method="post" id="formVentaProducto" name="formVentaProducto">
     <input type="hidden" name="accion" id="accion" value="registrarVenta">
     <!-- datos para guardar orden venta -->
    
  <input type="hidden" id="DO" name="DO" value="0">
 
  
  
   <!-- fin datos guardar orden venta -->
<button type="button" class="btn btn-success btn-md" aria-label="Left Align" data-toggle="modal" data-target="#myModalAgregaProducto">
    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">&nbsp;</span>Agregar Producto</button>
    
     <button type="submit" class="btn btn-warning btn-md pull-right"  id="btnRegistrarVenta"  name="btnRegistrarVenta">Comprar</button> 
   <!-- <input  type="submit" class="btn btn-warning btn-md pull-right" aria-label="Left Align"  id="btnRegistrarVenta"  name="btnRegistrarVenta" value="Registrar Compra">
   <span class="fa fa-shopping-basket" aria-hidden="true">&nbsp;</span>Registrar Compra</button>-->
<p></p>
<div class="table-responsive">    
    <table id="table_ventas" class="table table-bordered text-center">
        <thead >
        <tr height="35px">
            <th  class="text-center">Codigo Pez</th>
            <th  class="text-center">Nombre Pez</th>
            <th  class="text-center">Cantidad</th>
            <th  class="text-center">Precio</th>
 
            <th  class="text-center">Importe</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="compras">
        <%  
HttpSession sessioncarrito = request.getSession(false);
 DecimalFormat df = new DecimalFormat("0.00");
 DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
 dfs.setDecimalSeparator('.');
 df.setDecimalFormatSymbols(dfs);
 double total = 0;
 if (sessioncarrito.getAttribute("carroCompras") != null) {
     ArrayList<BeanCarrito> lista = (ArrayList<BeanCarrito>) sessioncarrito.getAttribute("carroCompras");

             for (int i = 0; i < lista.size(); i++) {%>
             <tr>
        <input type="hidden" name="cod_cliente" id="cod_cliente" value="<%=codCliente%>" ><!--codigo cliente -->
          <input type="hidden" name="posicion" id="posicion" value="<%=i%>" ><!--num posicion -->
      <input type="hidden" id="NOV" name="NOV" value="<%=numeroDeOrden%>"><!-- num orden  -->
       <input type="hidden" id="FO" name="FO" value="<%=fecha%>"><!-- fecha -->
       
                 <td><%=lista.get(i).getCOD_ARTICULO()%><input type="hidden" name="codArticulo" value="<%=lista.get(i).getCOD_ARTICULO()%>"></td><!-- codigo articulo -->
                 <td><%=lista.get(i).getNOM_ARTICULO()%></td>
                 <td><%=lista.get(i).getCANTIDAD_DESPACHADA()%><input type="hidden" name="txtCantidad" value="<%=lista.get(i).getCANTIDAD_DESPACHADA()%>"></td><!-- cantidad despachada -->
                 <td><%=lista.get(i).getPRECIO_ARTICULO()%><input type="hidden" name="txtPrecio" value="<%=lista.get(i).getPRECIO_ARTICULO()%>"></td><!-- precio total -->
                 
                 <td><%=String.valueOf(df.format(lista.get(i).getIMPORTE()))%><input type="hidden" name="txtImporte" value="<%=String.valueOf(df.format(lista.get(i).getIMPORTE()))%>"></td><!-- valor venta -->
                 <td><a class="btn btn-danger btn-xs" role="button" href='Servlet_Carrito?codigArticulo=<%=i%>&&accion=elimina_de_Carrito'>
                         <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                     </a></td>
             </tr>
    
    <input type="hidden" name="costototalArt" id="costototalArt" value="<%=(lista.get(i).getCANTIDAD_DESPACHADA() * lista.get(i).getPRECIO_ARTICULO()) * 0.12 + (lista.get(i).getCANTIDAD_DESPACHADA() * lista.get(i).getPRECIO_ARTICULO())%>"><!-- importe total -->
    
        <%
                 total = total + lista.get(i).getIMPORTE();
             }     %>
        <% }%>
                     
    </tbody>
    </tfooter>
    <tr>
            <td colspan="5"></td>            
            <td>SubTotal</td>
            <td><div id="subtotal_"><%=String.valueOf(df.format(total))%><input type="hidden" name="subtotal_" value="<%=String.valueOf(df.format(total))%>"></div></td>
            <td></td>
        </tr>
        <tr>
             <td colspan="5"></td>            
            <td>IVA</td>
            <td><label id="igv">12%</label><input type="hidden" id="igv" name="igv" value="0.12"></td><!-- igv -->
            <td></td>
        </tr>
      <tr>
           <td colspan="5"></td>            
            <td>Total</td>
            <td><div id="total_"><%=String.valueOf(df.format(total*0.12+total))%><input type="hidden" name="txtImportetotal" value="<%=String.valueOf(df.format(total*0.18+total))%>"></div></td>
            <td></td>
        </tr>
</tfooter>
</table>
</div>
<br>
</form>
</div>
 
<!-- Modal buscar cliente-->
  <div class="modal fade" id="myModalbuscarCliente" role="dialog" >
    <div class="modal-dialog modal-sm" style="width: 70%" >
        <div class="modal-content" >
          <div class="modal-header" style="background-color: #46b8da;  border-radius: 5px 5px 0px 0px;color:#ffffff;" >
       <!--   <button type="button" class="close btn-danger" data-dismiss="modal"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>-->
         <button type="button" class="btn btn-danger btn-sm  pull-right" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="glyphicon glyphicon-remove"></span>
        </button>         
          <h4 class="modal-title">Agregar Cliente</h4>
           
        </div>
        <div class="modal-body">
            <form action="Servlet_OrdenVenta" method="post"  id="frmAgregarClientecarrito" name="frmAgregarClientecarrito">
                <input type="hidden" id="accion" name="accion" value="sessioncliente">
                <div class="table-responsive">
                    <table class="table table-bordered text-center">
                    <thead >
                            <tr height="35px">
                                 <th>Agregar</th>
                                <th  class="text-center">Codigo</th>
                                <th  class="text-center">Cliente</th>
                                <th  class="text-center">Dirección</th>
                                <th  class="text-center">Telefono</th>
                                <th  class="text-center">Email</th>
                            </tr>
                    </thead>
                     <tbody>
                          <%      
                          
             ArrayList<BeanClientes>lstClientes = DaoCliente.ListarClientes();             
                     for(int i=0;i<lstClientes.size();i++){
                         BeanClientes beanclien=lstClientes.get(i);   
                        
                     %>
                            <tr>
                                <td>
                                     <a class="btn btn-warning btn-xs" role="button" href='Servlet_Carrito?codCliente=<%=beanclien.getCOD_CLIENTE() %>&&nomCliente=<%=beanclien.getNOMBRE() %>&&dirCliente=<%=beanclien.getDIRECCION() %>&&EmailCliente=<%=beanclien.getEMAIL() %>&&telfCliente=<%=beanclien.getTELEFONO() %>&&orden=<%=numeroDeOrden%>&&fecha=<%=fecha%>&&accion=anadirClientecarrito'>
  <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
</a>
                                </td>
                                <td><%=beanclien.getCOD_CLIENTE() %></td>
                                <td><%=beanclien.getNOMBRE() %></td>
                                <td><%=beanclien.getDIRECCION() %></td>
                                <td><%=beanclien.getTELEFONO() %></td>
                                <td><%=beanclien.getEMAIL() %></td>
                            </tr>
                            <%   }     %>
                     </tbody>
                    </table>
                </div>
          </form>
        </div>
      </div>
    </div>
  </div>
                     
<!-- Modal Agregar Producto-->
  <div class="modal fade" id="myModalAgregaProducto" role="dialog" >
    <div class="modal-dialog modal-sm" style="width: 40%" >
        <div class="modal-content" >
          <div class="modal-header" style="background-color: #46b8da;  border-radius: 5px 5px 0px 0px;color:#ffffff;" >
        <button type="button" class="btn btn-danger btn-sm  pull-right" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="glyphicon glyphicon-remove"></span>
        </button>         
          <h4 class="modal-title">Agregar Producto a Carrito</h4>
           
        </div>
        <div class="modal-body">
            <form action="" method=""  id="frmAgregarProductocarrito">
                <input type="hidden" id="NOV" name="NOV" value="<%=numeroDeOrden%>">
  <input type="hidden" id="CO" name="CO" value="">
  <input type="hidden" id="FO" name="FO" value="<%=fecha%>">
  <input type="hidden" id="DO" name="DO" value="0">
                <div class="table-responsive">
                    <table class="table table-bordered points_table">
                    <thead >
                            <tr height="35px">
                                 <th class="col-xs-2">Agregar</th>
                                <th class="col-xs-2">Codigo</th>
                                <th class="col-xs-4">Descripción</th>
                                <th class="col-xs-2">Stock</th>
                                 <th class="col-xs-2" >Precio</th>
                            </tr>
                    </thead>
                     <tbody class="points_table_scrollbar">
<!--                         <tr><td colspan="5">&nbsp;</td></tr>-->
                          <%           
                       ArrayList<BeanArticulo>lstArticulo=DaoArticulo_DB.ObtenerArticulos();
                     for(int i=0;i<lstArticulo.size();i++){
                         BeanArticulo beanArt=lstArticulo.get(i);
                     %>
                            <tr class="odd">
                                <td class="col-xs-2"><button type="button" class="btn btn-warning btn-xs" aria-label="Left Align" data-dismiss="modal" data-toggle="modal" data-target="#myModalagregaproducto"  onclick="capturacompraproducto('<%=beanArt.getCOD_ARTICULO() %>', '<%=beanArt.getDESCRIPCION() %>','<%=beanArt.getSTOCK_FISICO() %>', '<%=beanArt.getPRECIO_UNITARIO() %>')">
  <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
</button></td>
                                <td class="col-xs-2"><%=beanArt.getCOD_ARTICULO() %></td>
                            <td class="col-xs-4"><%=beanArt.getDESCRIPCION() %></td>
                            <td class="col-xs-2"><%=beanArt.getSTOCK_FISICO() %></td>
                            <td class="col-xs-2"><%=beanArt.getPRECIO_UNITARIO() %></td>
                            </tr>
                            <%   }     %>
                     </tbody>
                    </table>
                </div>
          </form>
        </div>        
      </div>
    </div>
  </div>
     
<!-- Modal Cantidad a Comprar-->
  <div class="modal fade" id="myModalagregaproducto" role="dialog" >
    <div class="modal-dialog modal-sm" >
      <div class="modal-content">
          <div class="modal-header" style="background-color: #46b8da;  border-radius: 5px 5px 0px 0px;color:#ffffff;" >
       <!--   <button type="button" class="close btn-danger" data-dismiss="modal"> <span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>-->
         <button type="button" class="btn btn-danger btn-sm  pull-right" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="glyphicon glyphicon-remove"></span>
        </button>         
          <h4 class="modal-title">Ingrese Cantidad Producto</h4>
           
        </div>
        <div class="modal-body">
            <form action="Servlet_Carrito" method="post"  id="frmcomprarproducto">
                 <input type="hidden" id="accion" name="accion" value="anadirCarrito">
               <input type="hidden" id="numOrden" name="numOrden" value="<%=numeroDeOrden%>"><!-- num_orden_venta* -->
                <input type="hidden" id="fecha" name="fecha" value="<%=fecha%>"><!-- fecha_orden* -->
                <input type="hidden" id="num_posicion" name="num_posicion" value="0">
                    <input type="hidden" id="descuento1" name="descuento1" value="0">
                    <input type="hidden" id="descuento2" name="descuento2" value="0">
                 <input type="hidden" id="cod_cliente" name="cod_cliente" value="<%=codCliente%>"><!-- codigo cliente* -->
              <input type="hidden" class="form-control" id="codigocompra" name="codigocompra"><!-- codigo articulo-->
             <input type="text" class="form-control" id="descripcioncompra"  name="descripcioncompra"><!-- descripcion articulo-->
             <input type="hidden" class="form-control" id="stockcompra" name="stockcompra"><!-- stock articulo-->
             <input type="hidden" class="form-control" id="preciocompra"  name="preciocompra"><!-- precio articulo-->
             
                   <div class="form-group">
              <label for="">Ingrese Cantidad a Comprar</label>
              <div id="precio"><input type="text" class="form-control" id="cantidadcompra"  name="cantidadcompra"></div>
            </div> 
 <button type="submit" class="btn btn-success"    name="anadirproducto" id="anadirproducto">Comprar</button> 
          </form>
        </div>
        <!--<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
      </div>
    </div>
  </div>
                     
                     
<style>
    .points_table thead {
	width: 100%;
}

.points_table tbody {
	height: 200px;
	overflow-y: auto;
	width: 100%;
}

.points_table thead tr{
	width: 99%;
}

 .points_table tr{
 	width: 100%;
 }

.points_table thead, .points_table tbody, .points_table tr, .points_table td, .points_table th{
	display: inline-block;
}

.points_table thead{
	background: #46b8da;
	color: #fff;
}

.points_table tbody td, .points_table thead > tr> th{
	float: left;
	border-bottom-width: 0;
}

.points_table>tbody>tr>td, .points_table>tbody>tr>th, .points_table>tfoot>tr>td, .points_table>tfoot>tr>th, .points_table>thead>tr>td, .points_table>thead>tr>th{
	padding: 8px;
	height: 50px;
	text-align: center;
	line-height: 32px;
}

.odd {
	background: #ffffff;
	color: #000;
}

.even {
	background: #efefef;
	color: #000;
}

.points_table_scrollbar{
	height: 612px;
	overflow-y: scroll;
}

.points_table_scrollbar::-webkit-scrollbar-track{
	-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.9);
	border-radius: 10px;
	background-color: #444444;
}

.points_table_scrollbar::-webkit-scrollbar{
	width: 1%;
	min-width: 5px;
	background-color: #F5F5F5;
}

.points_table_scrollbar::-webkit-scrollbar-thumb{
	border-radius: 10px;
	background-color: #46b8da;
	background-image: -webkit-linear-gradient(90deg, transparent, rgba(0, 0, 0, 0.4) 50%, transparent, transparent)
}

 </style>
                        
 <jsp:include page="include/footer.jsp" />