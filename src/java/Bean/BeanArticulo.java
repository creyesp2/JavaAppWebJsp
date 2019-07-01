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
public class BeanArticulo {
    private String COD_ARTICULO;
     private String COD_PROVEEDOR;
    private String DESCRIPCION;
    private Integer STOCK_FISICO;
    private Double PRECIO_UNITARIO;

    public BeanArticulo(){
        
    }
    public BeanArticulo(String COD_ARTICULO,String DESCRIPCION,Integer STOCK_FISICO,Double PRECIO_UNITARIO,String COD_PROVEEDOR){
        this.COD_ARTICULO=COD_ARTICULO;
        
        this.DESCRIPCION=DESCRIPCION;
        this.STOCK_FISICO=STOCK_FISICO;
        this.PRECIO_UNITARIO=PRECIO_UNITARIO;
        this.COD_PROVEEDOR=COD_PROVEEDOR;
    }
    public String getCOD_ARTICULO() {
        return COD_ARTICULO;
    }

    public void setCOD_ARTICULO(String COD_ARTICULO) {
        this.COD_ARTICULO = COD_ARTICULO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public Integer getSTOCK_FISICO() {
        return STOCK_FISICO;
    }

    public void setSTOCK_FISICO(Integer STOCK_FISICO) {
        this.STOCK_FISICO = STOCK_FISICO;
    }

    public Double getPRECIO_UNITARIO() {
        return PRECIO_UNITARIO;
    }

    public void setPRECIO_UNITARIO(Double PRECIO_UNITARIO) {
        this.PRECIO_UNITARIO = PRECIO_UNITARIO;
    }

    public String getCOD_PROVEEDOR() {
        return COD_PROVEEDOR;
    }

    public void setCOD_PROVEEDOR(String COD_PROVEEDOR) {
        this.COD_PROVEEDOR = COD_PROVEEDOR;
    }
    
    
}
