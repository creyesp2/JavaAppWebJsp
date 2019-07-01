/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author LEO
 */
public class BeanUsuario {
    private String  nombres;
    private String  apellidos;
    private String usuario;
    private String  password;
    private Integer  estado;

    public BeanUsuario(){        
    }
    
    public BeanUsuario(String nombres,String apellidos,String usuario,String password,Integer estado){
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.usuario=usuario;
        this.password=password;
        this.estado=estado;
        
    } 
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    
}
