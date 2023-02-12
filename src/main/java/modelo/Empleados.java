/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jose David Huertas Q
 */
public class Empleados {
     private int codemple;
     private String nombres;
     private String ape_pat;
     private String ape_mat;
     private int tipo_emple;
     private String usuario;
     private String clave;
     private int turno_emple;
     
      public Empleados() {
        this.codemple  = 0;
        this.nombres = "";
        this.ape_pat = "";
        this.ape_mat="";
        this.tipo_emple=0;
        this.usuario = "";
        this.clave = "";
        this.turno_emple = 0;
    }

    public int getCodemple() {
        return codemple;
    }

    public void setCodemple(int codemple) {
        this.codemple = codemple;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_pat() {
        return ape_pat;
    }

    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    public String getApe_mat() {
        return ape_mat;
    }

    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }

    public int getTipo_emple() {
        return tipo_emple;
    }

    public void setTipo_emple(int tipo_emple) {
        this.tipo_emple = tipo_emple;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTurno_emple() {
        return turno_emple;
    }

    public void setTurno_emple(int turno_emple) {
        this.turno_emple = turno_emple;
    }
      
    
      
      
}
