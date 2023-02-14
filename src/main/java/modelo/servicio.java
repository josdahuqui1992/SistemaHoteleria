
package modelo;


public class servicio {
    private int codigo;
    private String tipoSer;
    private double precio;
    
    public servicio() {
    }

    public servicio(int codigo, String tipoSer, double precio) {
        this.codigo = codigo;
        this.tipoSer = tipoSer;
        this.precio = precio;
        
    }
    public double total(){
        return precio+(precio*0.18);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoSer() {
        return tipoSer;
    }

    public void setTipoSer(String tipoSer) {
        this.tipoSer = tipoSer;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

  

   
    
}
