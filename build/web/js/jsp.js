$(document).ready(function (){
    limpiarCampos();
    
    $('#btnRegistrar').click(function(){
        validaarticulo();
    });
    
    $('#btnRegistrarCliente').click(function(){
        validacliente();
    });
    
//       $('#btnRegistrarVenta').click(function(){
//        RegistrarVenta();
//      
//    });    
//     $('#btnSessionCliente').click(function(){
//      $('#frmAgregarClientecarrito').submit();
//    });
});

function validaarticulo(){
    var codigo,proveedor,descripcion,stock,precio;
    codigo=$('#txt_codigo').val();
    proveedor=$('#txt_proveedor').val();
    descripcion=$('#txt_descripcion').val();
    stock=$('#txt_stock').val();
    precio=$('#txt_precio').val();
    
     if(codigo === ""){
        alert("El campo codigo es obligatorio");
        $('#txt_codigo').focus();
    }else if(proveedor===""){
        
         alert("El campo proveedor es obligatorio");
        $('#txt_proveedor').focus();
        
    }else if(descripcion===""){
         alert("El campo descripcion no puede estar vacio");
        $('#txt_descripcion').focus();
    }else if(stock===""){
         alert("El campo stock no puede estar vacio");
        $('#txt_dstock').focus();
    }else if(precio===""){
         alert("El campo precio no puede estar vacio");
        $('#txt_precio').focus();
    }else{
        $('#formarticulo').submit();
    }
}

function limpiarCampos(){
    $('.textBox').val("");
}

function ModificaArticulo(c,d,s,p){
     var codigo,descripcion,stock,precio;
    codigo=c;
    descripcion=d;
    stock=s;
    precio=p;
    
    document.getElementById('codigo').innerHTML = '<input type="text" class="form-control" id="txt_codigo" name="txt_codigo" value="'+codigo+'" disabled> <input type="hidden" class="form-control" id="mtxt_codigo" name="mtxt_codigo" value="'+codigo+'" >';
    document.getElementById('descripcion').innerHTML ='<input type="text" class="form-control" id="mtxt_descripcion"  name="mtxt_descripcion" value="'+descripcion+'">';
    document.getElementById('stock').innerHTML = '<input type="text" class="form-control" id="mtxt_stock" name="mtxt_stock" value="'+stock+'">';
    document.getElementById('precio').innerHTML = '<input type="text" class="form-control" id="mtxt_precio"  name="mtxt_precio" value="'+precio+'">';
}

function validacliente(){
    var cod_cliente,estado_cliente,ruc,nombre,direccion,ciudad,fecha_ingreso,tipo_cliente,limite_credito_s,limite_credito_d,email,telefono;
    cod_cliente=$('#txt_codigo').val();
    estado_cliente=$('#txt_estadocliente').val();
    ruc=$('#txt_ruc').val();
    nombre=$('#txt_nombre').val();
    direccion=$('#txt_direccion').val();
    ciudad=$('#txt_ciudad').val();
    fecha_ingreso=$('#txt_fecha').val();
    tipo_cliente=$('#txt_tipocliente').val();
    limite_credito_s=$('#txt_credito_s').val();
    limite_credito_d=$('#txt_credito_d').val();
    email=$('#txt_email').val();
    telefono=$('#txt_telefono').val();
    
    //var testForm = document.getElementById('formcliente');
   // alert(estado_cliente);
   
   if(cod_cliente === ""){
        alert("El campo codigo es obligatorio");
        $('#cod_cliente').focus();
    }else if(estado_cliente===""){
         alert("Todos los campos son obligatorio");
        $('#estado_cliente').focus();
    }else if(ruc===""){
        alert("Todos los campos son obligatorio");
        $('#ruc').focus();
    }else if(nombre===""){
      alert("Todos los campos son obligatorio");
        $('#nombre').focus();
    }else if(direccion===""){
        alert("Todos los campos son obligatorio");
        $('#direccion').focus();
    }else if(ciudad===""){
        alert("Todos los campos son obligatorio");
        $('#ciudad').focus();
    }else if(fecha_ingreso===""){
         alert("Todos los campos son obligatorio");
        $('#fecha_ingreso').focus();
    }else if(tipo_cliente===""){
        alert("Todos los campos son obligatorio");
        $('#tipo_cliente').focus();
    }else if(limite_credito_s===""){
        alert("Todos los campos son obligatorio");
        $('#limite_credito_s').focus();
    }else if(limite_credito_d===""){
         alert("Todos los campos son obligatorio");
        $('#limite_credito_d').focus();
    }else if(email===""){
         alert("Todos los campos son obligatorio");
        $('#email').focus();
    }else if(telefono===""){
         alert("Todos los campos son obligatorio");
        $('#telefono').focus();
    }else{
        $('#formcliente').submit();
    }
}

function ModificaCliente(cd,estc,rc,nc,dc,cc,fc,tc,lcsc,lcdc,ec,telfc){
    var codigo_c=cd;
    var estado_c=estc;
    var ruc_c=rc;
    var nombre_c=nc;
    var direccion_c=dc;
    var ciudad_c=cc;
     var fecha_c=fc;
    var tipo_c=tc;
    var limites_c=lcsc;
    var limited_c=lcdc;
    var email_c=ec;
    var telefono_c=telfc;
    document.getElementById('codigo_c').innerHTML ='<input type="text" class="form-control" id="txt_codigo" name="txt_codigo" value="'+codigo_c+'" disabled><input type="hidden" class="form-control" id="txt_codigo" name="txt_codigo" value="'+codigo_c+'">';
    document.getElementById('estado_c').innerHTML ='<input type="text" class="form-control" id="txt_estadocliente"  name="txt_estadocliente" value="'+estado_c+'">';
    document.getElementById('ruc_c').innerHTML ='<input type="text" class="form-control" id="txt_ruc" name="txt_ruc" value="'+ruc_c+'">';
    document.getElementById('nombre_c').innerHTML ='<input type="text" class="form-control" id="txt_nombre"  name="txt_nombre" value="'+nombre_c+'">';
    document.getElementById('direccion_c').innerHTML ='<input type="text" class="form-control" id="txt_direccion"  name="txt_direccion" value="'+direccion_c+'">';
    document.getElementById('ciudad_c').innerHTML ='<input type="text" class="form-control" id="txt_ciudad"  name="txt_ciudad" value="'+ciudad_c+'">';
    document.getElementById('fecha_c').innerHTML ='<input type="text" class="form-control" id="txt_fecha"  name="txt_fecha" value="'+fecha_c+'">';
    document.getElementById('tipo_c').innerHTML ='<input type="text" class="form-control" id="txt_tipocliente"  name="txt_tipocliente" value="'+tipo_c+'">';
    document.getElementById('limites_c').innerHTML ='<input type="text" class="form-control" id="txt_credito_s"  name="txt_credito_s" value="'+limites_c+'">';
    document.getElementById('limited_c').innerHTML ='<input type="text" class="form-control" id="txt_credito_d"  name="txt_credito_d" value="'+limited_c+'">';
    document.getElementById('email_c').innerHTML ='<input type="text" class="form-control" id="txt_email"  name="txt_email" value="'+email_c+'">';
    document.getElementById('telefono_c').innerHTML ='<input type="text" class="form-control" id="txt_telefono"  name="txt_telefono" value="'+telefono_c+'">';
    
}

function capturaCliente(a,b,c,d,e){
    var codigo,cliente,direccion,telefono,email;
    codigo=a;
    cliente=b;
    direccion=c;
    telefono=d;
    email=e;
   // alert(codigo);
    //document.getElementById("txt_codigocliente_v").value = codigo;
    $("#txt_codigocliente_v").val(codigo);
     $("#txt_nombrecliente_v").val(cliente);
      $("#txt_direccioncliente_v").val(direccion);
       $("#txt_telefonocliente_v").val(telefono);
        $("#txt_emailcliente_v").val(email);
         $("#CO").val(codigo);
   // $('#frmAgregarClientecarrito').submit();
    
}

function capturacompraproducto(a,b,c,d){
    var codigo,descripcion,stock,precio,desct1,desct2;
    codigo=a;
    descripcion=b;
    stock=c;
    precio=d;
    
     $("#codigocompra").val(codigo);
      $("#descripcioncompra").val(descripcion);
       $("#stockcompra").val(stock);
        $("#preciocompra").val(precio);
}
var totalg=0,subtotalg=0,subtotal2=0;
function agregarProducto(){
      var codigo,descripcion,stock,precio,cantidad,importe,subtotal,total,igv;
//    codigo=a;
//    descripcion=b;
//    stock=c;
//    precio=d;
    
    codigo=$('#codigocompra').val();
    descripcion=$('#descripcioncompra').val();
    stock=$('#stockcompra').val();
    precio=$('#preciocompra').val();
    cantidad=$('#cantidadcompra').val();
    importe=parseFloat(cantidad) * parseFloat(precio);
    subtotal=parseFloat(importe);
     subtotal2=subtotal;
    subtotalg=parseFloat(subtotalg)+subtotal;
    igv=subtotalg*parseFloat(0.12);
    totalg=subtotalg+igv;

    
//    console.log("subtotalg: "+subtotalg);
//     console.log("IGV: "+igv);
//       console.log("totalGeneral: "+totalg);
   
    var cont_fila = ($('#table_ventas tbody').find('tr').length) -2;
     var newtr = '<tr class="item"  data-id="'+codigo+'">';
     newtr = newtr + '<td><label class=" " name="codigo" id="codigo" style="width:100px;height: 25px;" >'+codigo+'</label><input type="hidden" name="codigo" id="codigo" value="'+codigo+'"></td>';
     newtr = newtr + '<td><label class=" " name="descripcion"  id="descripcion" style="width:400px;height: 25px;" >'+descripcion+'</label><input type="hidden" name="descripcion" id="descripcion" value="'+descripcion+'"></td>';
     newtr = newtr+'<td><div><input type="text" class="form-control " name="cantidad" id="cantidad" value="'+cantidad+'"  style="width:100px;height: 25px;" ></div></td>';
     newtr = newtr+'<td><label class=" " name="precio" id="precio"  style="width:100px;height: 25px;" >'+precio+'</label><input type="hidden" name="precio" id="precio" value="'+precio+'"></td>';
     newtr = newtr+'<td><div><input type="text" class="form-control" name="importe" id="importe" value="'+importe+'"  style="width:100px;height: 25px;" ></div></td>';
     newtr = newtr+'<td  width="100px"><button type="button" class="btn btn-danger btn-xs remove-item" aria-label="Left Align" onclick=""><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></div></td></tr>';
      $('#compras').append(newtr);
        document.getElementById('subtotal_').innerHTML='<label class=" " name="subtotal"  id="subtotal" style="width:100px;height: 25px;" >'+subtotalg+'</label><input type="hidden" name="subtotal" id="subtotal" value="'+subtotalg+'">';
         document.getElementById('total_').innerHTML='<label class=" " name="total"  id="total" style="width:100px;height: 25px;" >'+totalg+'</label><input type="hidden" name="total" id="total" value="'+totalg+'">';
      
      $('.remove-item').off().click(function(e) {
                $(this).parent('td').parent('tr').remove(); //En accion elimino el Producto de la Tabla
                
                 subtotalgx=parseFloat(subtotalg)-parseFloat(subtotal2);
                 igv2=subtotalgx*parseFloat(0.18);
                 totalg2=subtotalgx+igv2;
                 subtotalg=subtotalgx;
                 totalg=totalg2;
                  console.log("subtotalg: "+subtotalg);
                    console.log("subtotal2: "+subtotal2);                    
                    console.log("subtotalgx: "+subtotalgx);

                    
                
    
         document.getElementById('subtotal_').innerHTML='<label class=" " name="subtotal"  id="subtotal" style="width:100px;height: 25px;" >'+subtotalgx+'</label><input type="hidden" name="subtotal" id="subtotal" value="'+subtotalgx+'"';
         document.getElementById('total_').innerHTML='<label class=" " name="subtotal"  id="subtotal" style="width:100px;height: 25px;" >'+totalg2+'</label><input type="hidden" name="total" id="total" value="'+totalg2+'">';
            
                if ($('#ProSelected tr.item').length == 0)
                    $('#ProSelected .no-item').slideDown(300); 
              //  RefrescaProducto();
                
     });
         
}

function buscadorN(){
    var buscarcliente =$('#txt_codigocliente_v').val();
    alert(buscarcliente);
}

function RegistrarVenta(){
  
          $('#formVentaProducto').submit();
    
}