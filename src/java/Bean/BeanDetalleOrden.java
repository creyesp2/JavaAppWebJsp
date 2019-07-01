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
public class BeanDetalleOrden {
 private Integer NUM_ORDEN_VENTA;
private Integer NUMERO_POSICION;
private String COD_ARTICULO;
private Integer CANTIDAD_PEDIDA;
private Integer CANTIDAD_DESPACHADA;
private Double PRECIO_TOTAL;
private Double VALOR_VENTA;
private Double IVA;
private Double IMPORTE_TOTAL;

public BeanDetalleOrden(){
    
}
    public BeanDetalleOrden(Integer NUM_ORDEN_VENTA, Integer NUMERO_POSICION, String COD_ARTICULO, Integer CANTIDAD_PEDIDA, Integer CANTIDAD_DESPACHADA, Double PRECIO_TOTAL,  Double VALOR_VENTA, Double IVA, Double IMPORTE_TOTAL) {
        this.NUM_ORDEN_VENTA = NUM_ORDEN_VENTA;
        this.NUMERO_POSICION = NUMERO_POSICION;
        this.COD_ARTICULO = COD_ARTICULO;
        this.CANTIDAD_PEDIDA = CANTIDAD_PEDIDA;
        this.CANTIDAD_DESPACHADA = CANTIDAD_DESPACHADA;
        this.PRECIO_TOTAL = PRECIO_TOTAL;
    
        this.VALOR_VENTA = VALOR_VENTA;
        this.IVA = IVA;
        this.IMPORTE_TOTAL = IMPORTE_TOTAL;
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



}