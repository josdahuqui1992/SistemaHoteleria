
package modelo;

public class empleado {
    private int codigo;
    private String nombre;
    private String apellido;
    private String ntipoEmp;
    private String correo;
    private String password;
    private String  nturno;

    public empleado() {
    }

    public empleado(int codigo, String nombre, String apellido, String ntipoEmp, String correo, String password, String nturno) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ntipoEmp = ntipoEmp;
        this.correo = correo;
        this.password = password;
        this.nturno = nturno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNtipoEmp() {
        return ntipoEmp;
    }

    public void setNtipoEmp(String ntipoEmp) {
        this.ntipoEmp = ntipoEmp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNturno() {
        return nturno;
    }

    public void setNturno(String nturno) {
        this.nturno = nturno;
    }

 
 

   
    
    
}
