<%@page import="Dao.*"%>
<%@page import="Dao.*"%>
<%@page import="Bean.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <% 
              
            
//      HttpSession ses=request.getSession();
//         BeanUsuario usu = DaoUsuario_DB.listarUsuario(usuario);  
//      if(ses.getAttribute("parametroCodigo") != null){
//         String usuario = (String)session.getAttribute("parametroCodigo");
//         
//                String usuarioLog = usu.getNombres()+ ", " + usu.getApellidos();
//      }else{
//      response.sendRedirect("index.jsp");
//      }
//       if(request.getParameter("c")!= null){
//                                 ses.invalidate();
//                                 response.sendRedirect("index.jsp");
//                             }
              
              
              
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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="./img/ico.png">
<title>UMG sistemas</title>
<link href="css/bootstrap.css" rel="stylesheet"> 
<link href="css/font-awesome.css" rel="stylesheet" type="text/css"/>
  <script src="js/jquery-3.3.1.js"></script>  <link href="css/bootstrap.css" rel="stylesheet">  
  <script src="js/jsp.js" type="text/javascript"></script>
  <script src="js/bootstrap.min.js" type="text/javascript"></script>

    </head>
    <body style="background-image: url('img/bg1.png')">
          
      <nav class="header navbar-default bg-default fixed-top" style="background-color: #4aba70;color:#ffffff;">
  <div class="container-fluid" style="background-color: #4aba70;color:#ffffff;" >
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header" style="background-color: #4aba70;color:#ffffff;">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false" >
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#" style="color:#fff;">MI FACTURACION</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
      <ul class="nav navbar-nav navbar-right" style="color:#fff;">
        <li ><a href="cliente.jsp"  style="color:#fff;">Clientes</a></li>
        <li><a href="articulo.jsp"  style="color:#fff;">Peces</a></li>
        <li><a href="detalle_orden.jsp"  style="color:#fff;">Reporte Facturas</a></li> 
        <li><a href="orden_venta.jsp"  style="color:#fff;">Ventas</a></li>    
        <li><a href="proveedor.jsp"  style="color:#fff;">Proveedor</a></li>  
        <li><a href="#"  style="color:#fff;">Usuario: <%=usu.getNombres()%>,<%=usu.getApellidos()%> </a></li>
        <li><a href="Servlet_Usu?accion=logout"  style="color:#fff;">Salir</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
