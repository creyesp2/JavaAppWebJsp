/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author LEO
 */
public class BeanCarrito {
    private Integer NUM_ORDEN_VENTA;
private Integer NUMERO_POSICION;
private String COD_ARTICULO;
private Integer CANTIDAD_PEDIDA;
private Integer CANTIDAD_DESPACHADA;
private Double PRECIO_TOTAL;
private Double VALOR_VENTA;
private Double IVA;
private Double IMPORTE_TOTAL;
private String NOM_ARTICULO;
private Double PRECIO_ARTICULO;
private Double IMPORTE;
private String CODIGO_CLIENTE;
private String FECHA_VENTA;   
private String NOM_CLIENTE;
private String DIR_CLIENTE;
private String EMAIL_CLIENTE;
private String TELF_CLIENTE;
private Double DESCUENTO_ORDEN;

public BeanCarrito(){
    
}
    public BeanCarrito(Integer NUM_ORDEN_VENTA, Integer NUMERO_POSICION, String COD_ARTICULO, Integer CANTIDAD_PEDIDA, Integer CANTIDAD_DESPACHADA, Double PRECIO_TOTAL, Double VALOR_VENTA, Double IVA, Double IMPORTE_TOTAL,String NOM_ARTICULO,Double PRECIO_ARTICULO,Double IMPORTE,String CODIGO_CLIENTE,String FECHA_VENTA,String NOM_CLIENTE, String DIR_CLIENTE,String EMAIL_CLIENTE, String TELF_CLIENTE, Double DESCUENTO_ORDEN) {
        this.NUM_ORDEN_VENTA = NUM_ORDEN_VENTA;
        this.NUMERO_POSICION = NUMERO_POSICION;
        this.COD_ARTICULO = COD_ARTICULO;
        this.CANTIDAD_PEDIDA = CANTIDAD_PEDIDA;
        this.CANTIDAD_DESPACHADA = CANTIDAD_DESPACHADA;
        this.PRECIO_TOTAL = PRECIO_TOTAL;
     
        this.VALOR_VENTA = VALOR_VENTA;
        this.IVA = IVA;
        this.IMPORTE_TOTAL = IMPORTE_TOTAL;        
        this.NOM_ARTICULO=NOM_ARTICULO;
        this.PRECIO_ARTICULO=PRECIO_ARTICULO;
        this. IMPORTE=IMPORTE;
        this.CODIGO_CLIENTE=CODIGO_CLIENTE;
        this.FECHA_VENTA=FECHA_VENTA;
        this.NOM_CLIENTE=NOM_CLIENTE;
        this.DIR_CLIENTE=DIR_CLIENTE;
        this.EMAIL_CLIENTE=EMAIL_CLIENTE;
        this.TELF_CLIENTE=TELF_CLIENTE;
        this.DESCUENTO_ORDEN = DESCUENTO_ORDEN;
    }


    public Integer getNUM_ORDEN_VENTA() {
        return NUM_ORDEN_VENTA;
    }

    public void setNUM_ORDEN_VENTA(Integer NUM_ORDEN_VENTA) {
        this.NUM_ORDEN_VENTA = NUM_ORDEN_VENTA;
    }

    public Integer getNUMERO_POSICION() {
        return NUMERO_POSICION;
    }

    public void setNUMERO_POSICION(Integer NUMERO_POSICION) {
        this.NUMERO_POSICION = NUMERO_POSICION;
    }

    public String getCOD_ARTICULO() {
        return COD_ARTICULO;
    }

    public void setCOD_ARTICULO(String COD_ARTICULO) {
        this.COD_ARTICULO = COD_ARTICULO;
    }

    public Integer getCANTIDAD_PEDIDA() {
        return CANTIDAD_PEDIDA;
    }

    public void setCANTIDAD_PEDIDA(Integer CANTIDAD_PEDIDA) {
        this.CANTIDAD_PEDIDA = CANTIDAD_PEDIDA;
    }

    public Integer getCANTIDAD_DESPACHADA() {
        return CANTIDAD_DESPACHADA;
    }

    public void setCANTIDAD_DESPACHADA(Integer CANTIDAD_DESPACHADA) {
        this.CANTIDAD_DESPACHADA = CANTIDAD_DESPACHADA;
    }

    public Double getPRECIO_TOTAL() {
        return PRECIO_TOTAL;
    }

    public void setPRECIO_TOTAL(Double PRECIO_TOTAL) {
        this.PRECIO_TOTAL = PRECIO_TOTAL;
    }

  
    public Double getVALOR_VENTA() {
        return VALOR_VENTA;
    }

    public void setVALOR_VENTA(Double VALOR_VENTA) {
        this.VALOR_VENTA = VALOR_VENTA;
    }

    public Double getIVA() {
        return IVA;
    }

    public void setIVA(Double IVA) {
        this.IVA = IVA;
    }

    public Double getIMPORTE_TOTAL() {
        return IMPORTE_TOTAL;
    }

    public void setIMPORTE_TOTAL(Double IMPORTE_TOTAL) {
        this.IMPORTE_TOTAL = IMPORTE_TOTAL;
    }

    public String getNOM_ARTICULO() {
        return NOM_ARTICULO;
    }

    public void setNOM_ARTICULO(String NOM_ARTICULO) {
        this.NOM_ARTICULO = NOM_ARTICULO;
    }

    public Double getPRECIO_ARTICULO() {
        return PRECIO_ARTICULO;
    }

    public void setPRECIO_ARTICULO(Double PRECIO_ARTICULO) {
        this.PRECIO_ARTICULO = PRECIO_ARTICULO;
    }

    public Double getIMPORTE() {
        return IMPORTE;
    }

    public void setIMPORTE(Double IMPORTE) {
        this.IMPORTE = IMPORTE;
    }

    public String getCODIGO_CLIENTE() {
        return CODIGO_CLIENTE;
    }

    public void setCODIGO_CLIENTE(String CODIGO_CLIENTE) {
        this.CODIGO_CLIENTE = CODIGO_CLIENTE;
    }

    public String getFECHA_VENTA() {
        return FECHA_VENTA;
    }

    public void setFECHA_VENTA(String FECHA_VENTA) {
        this.FECHA_VENTA = FECHA_VENTA;
    }

    public String getNOM_CLIENTE() {
        return NOM_CLIENTE;
    }

    public void setNOM_CLIENTE(String NOM_CLIENTE) {
        this.NOM_CLIENTE = NOM_CLIENTE;
    }

    public String getDIR_CLIENTE() {
        return DIR_CLIENTE;
    }

    public void setDIR_CLIENTE(String DIR_CLIENTE) {
        this.DIR_CLIENTE = DIR_CLIENTE;
    }

    public String getEMAIL_CLIENTE() {
        return EMAIL_CLIENTE;
    }

    public void setEMAIL_CLIENTE(String EMAIL_CLIENTE) {
        this.EMAIL_CLIENTE = EMAIL_CLIENTE;
    }

    public String getTELF_CLIENTE() {
        return TELF_CLIENTE;
    }

    public void setTELF_CLIENTE(String TELF_CLIENTE) {
        this.TELF_CLIENTE = TELF_CLIENTE;
    }

    public Double getDESCUENTO_ORDEN() {
        return DESCUENTO_ORDEN;
    }

    public void setDESCUENTO_ORDEN(Double DESCUENTO_ORDEN) {
        this.DESCUENTO_ORDEN = DESCUENTO_ORDEN;
    }



}
