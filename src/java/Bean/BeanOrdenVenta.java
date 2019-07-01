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
public class BeanOrdenVenta {
    private Integer NUM_ORDEN_VENTA;
    private String COD_CLIENTE;
    private String FECHA_ORDEN;
    private Double DESCUENTO_ORDEN;

    public BeanOrdenVenta(){
        
    }
    public BeanOrdenVenta(Integer NUM_ORDEN_VENTA, String COD_CLIENTE, String FECHA_ORDEN, Double DESCUENTO_ORDEN) {
        this.NUM_ORDEN_VENTA = NUM_ORDEN_VENTA;
        this.COD_CLIENTE = COD_CLIENTE;
        this.FECHA_ORDEN = FECHA_ORDEN;
        this.DESCUENTO_ORDEN = DESCUENTO_ORDEN;
    }

    public Integer getNUM_ORDEN_VENTA() {
        return NUM_ORDEN_VENTA;
    }

    public void setNUM_ORDEN_VENTA(Integer NUM_ORDEN_VENTA) {
        this.NUM_ORDEN_VENTA = NUM_ORDEN_VENTA;
    }

    public String getCOD_CLIENTE() {
        return COD_CLIENTE;
    }

    public void setCOD_CLIENTE(String COD_CLIENTE) {
        this.COD_CLIENTE = COD_CLIENTE;
    }

    public String getFECHA_ORDEN() {
        return FECHA_ORDEN;
    }

    public void setFECHA_ORDEN(String FECHA_ORDEN) {
        this.FECHA_ORDEN = FECHA_ORDEN;
    }

    public Double getDESCUENTO_ORDEN() {
        return DESCUENTO_ORDEN;
    }

    public void setDESCUENTO_ORDEN(Double DESCUENTO_ORDEN) {
        this.DESCUENTO_ORDEN = DESCUENTO_ORDEN;
    }
    
    
}

