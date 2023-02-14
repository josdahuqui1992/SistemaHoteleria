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
public class Cuartos {

    private int codcuartos;
    private String categoria;     
    //private int categoria; ant
    private double preciodia;
    private String puesto;    
    //private int puesto;   and
    
    public Cuartos() {
        this.codcuartos  = 0;
        this.categoria = "";
        //this.categoria = 0;
        this.preciodia=0.0;
        this.puesto = "";
        //this.puesto = 0;
    }

    public int getCodcuartos() {
        return codcuartos;
    }

    public void setCodcuartos(int codcuartos) {
        this.codcuartos = codcuartos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreciodia() {
        return preciodia;
    }

    public void setPreciodia(double preciodia) {
        this.preciodia = preciodia;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    
//    public int getCodcuartos() {
//        return codcuartos;
//    }
//
//    public void setCodcuartos(int codcuartos) {
//        this.codcuartos = codcuartos;
//    }
//
//    public int getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(int categoria) {
//        this.categoria = categoria;
//    }
//
//    public double getPreciodia() {
//        return preciodia;
//    }
//
//    public void setPreciodia(double preciodia) {
//        this.preciodia = preciodia;
//    }
//
//    public int getPuesto() {
//        return puesto;
//    }
//
//    public void setPuesto(int puesto) {
//        this.puesto = puesto;
//    }
    
    
    
    
}
