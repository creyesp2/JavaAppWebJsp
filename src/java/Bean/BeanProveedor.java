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
public class BeanProveedor {
    private String COD_PROVEEDOR;
     private String NOMBRE_PROVEEDOR;
    private String DPI;
    private Integer CANTIDAD;
    private Double PRECIO;

    public BeanProveedor(){
        
    }
    public BeanProveedor(String COD_PROVEEDOR,String NOMBRE_PROVEEDOR,String DPI,Integer CANTIDAD,Double PRECIO){
        this.COD_PROVEEDOR=COD_PROVEEDOR;
        
        this.NOMBRE_PROVEEDOR=NOMBRE_PROVEEDOR;
        this.DPI=DPI;
        this.CANTIDAD=CANTIDAD;
        this.PRECIO=PRECIO;
    }

    public String getCOD_PROVEEDOR() {
        return COD_PROVEEDOR;
    }

    public void setCOD_PROVEEDOR(String COD_PROVEEDOR) {
        this.COD_PROVEEDOR = COD_PROVEEDOR;
    }

    public String getNOMBRE_PROVEEDOR() {
        return NOMBRE_PROVEEDOR;
    }

    public void setNOMBRE_PROVEEDOR(String NOMBRE_PROVEEDOR) {
        this.NOMBRE_PROVEEDOR = NOMBRE_PROVEEDOR;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public Integer getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(Integer CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public Double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(Double PRECIO) {
        this.PRECIO = PRECIO;
    }
    
    
    
}
