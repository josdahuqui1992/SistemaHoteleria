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
public class PuestoCuartos {
     private int codestado;
     private String nombrepuest;
     private String estado;

    public PuestoCuartos() {
    }
     
     //constructor para el combobox
    public PuestoCuartos(String estado,String nombrepuest) {
        
        this.estado=estado;
        this.nombrepuest=nombrepuest;
    }

    public int getCodestado() {
        return codestado;
    }

    public void setCodestado(int codestado) {
        this.codestado = codestado;
    }

    public String getNombrepuest() {
        return nombrepuest;
    }

    public void setNombrepuest(String nombrepuest) {
        this.nombrepuest = nombrepuest;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
    public String toString(){
        return estado+" - "+nombrepuest;
    } 
    
    
     
}
