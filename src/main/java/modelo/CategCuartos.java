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
public class CategCuartos {
    private int codcategoria;
    private String nombrecategoria;
    private String estado;

    public CategCuartos() {
        
    }
    
    //constructor para el combobox
    public CategCuartos(String estado,String nombrecategoria) {
        
        this.estado=estado;
        this.nombrecategoria=nombrecategoria;
    }

    public int getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(int codcategoria) {
        this.codcategoria = codcategoria;
    }

    public String getNombrecategoria() {
        return nombrecategoria;
    }

    public void setNombrecategoria(String nombrecategoria) {
        this.nombrecategoria = nombrecategoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String toString(){
        return estado+" - "+nombrecategoria;
    }

    
    
    
    
}
