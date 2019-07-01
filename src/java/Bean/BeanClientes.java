
package Bean;

public class BeanClientes {
    private String COD_CLIENTE;
    private Integer ESTADO_CLIENTE;
    private String RUC;
    private String NOMBRE;
    private String DIRECCION;
    private String CIUDAD;
    private String FECHA_INGRESO;
    private Integer TIPO_CLIENTE;
    private Double LIMITE_CREDITO_S;
    private Double LIMITE_CREDITO_D;
    private String EMAIL;
    private String TELEFONO;

    public BeanClientes(){
        
    }

    public BeanClientes(String COD_CLIENTE, Integer ESTADO_CLIENTE, String RUC, String NOMBRE, String DIRECCION, String CIUDAD, String FECHA_INGRESO, Integer TIPO_CLIENTE, Double LIMITE_CREDITO_S, Double LIMITE_CREDITO_D, String EMAIL, String TELEFONO) {
        this.COD_CLIENTE = COD_CLIENTE;
        this.ESTADO_CLIENTE = ESTADO_CLIENTE;
        this.RUC = RUC;
        this.NOMBRE = NOMBRE;
        this.DIRECCION = DIRECCION;
        this.CIUDAD = CIUDAD;
        this.FECHA_INGRESO = FECHA_INGRESO;
        this.TIPO_CLIENTE = TIPO_CLIENTE;
        this.LIMITE_CREDITO_S = LIMITE_CREDITO_S;
        this.LIMITE_CREDITO_D = LIMITE_CREDITO_D;
        this.EMAIL = EMAIL;
        this.TELEFONO = TELEFONO;
    }

    public String getCOD_CLIENTE() {
        return COD_CLIENTE;
    }

    public void setCOD_CLIENTE(String COD_CLIENTE) {
        this.COD_CLIENTE = COD_CLIENTE;
    }

    public Integer getESTADO_CLIENTE() {
        return ESTADO_CLIENTE;
    }

    public void setESTADO_CLIENTE(Integer ESTADO_CLIENTE) {
        this.ESTADO_CLIENTE = ESTADO_CLIENTE;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getCIUDAD() {
        return CIUDAD;
    }

    public void setCIUDAD(String CIUDAD) {
        this.CIUDAD = CIUDAD;
    }

    public String getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(String FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public Integer getTIPO_CLIENTE() {
        return TIPO_CLIENTE;
    }

    public void setTIPO_CLIENTE(Integer TIPO_CLIENTE) {
        this.TIPO_CLIENTE = TIPO_CLIENTE;
    }

    public Double getLIMITE_CREDITO_S() {
        return LIMITE_CREDITO_S;
    }

    public void setLIMITE_CREDITO_S(Double LIMITE_CREDITO_S) {
        this.LIMITE_CREDITO_S = LIMITE_CREDITO_S;
    }

    public Double getLIMITE_CREDITO_D() {
        return LIMITE_CREDITO_D;
    }

    public void setLIMITE_CREDITO_D(Double LIMITE_CREDITO_D) {
        this.LIMITE_CREDITO_D = LIMITE_CREDITO_D;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }
    
    
}
