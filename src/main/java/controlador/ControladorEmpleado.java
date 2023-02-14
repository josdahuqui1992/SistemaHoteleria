
package controlador;
import modelo.*;


import java.sql.*;
import java.util.*;
import java.util.Comparator;


import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.lang.model.SourceVersion;

public class ControladorEmpleado {
      public void adiciona(empleado ep){
//        Connection cn = MySQLConexion.getConexion();
        Connection cn = Conexion.conectar();
        String sql="insert into empleado  values(null,?,?,?,?,?,?)";
             try {
            PreparedStatement st=cn.prepareStatement(sql);
            //antes...ejecutar la relacion de cada ? con su valor 
            st.setString(1, ep.getNombre());
             st.setString(2, ep.getApellido());
            st.setString(3, ep.getNtipoEmp());
            st.setString(4,ep.getCorreo());
             st.setString(5,ep.getPassword());
            st.setString(6, ep.getNturno());
            
            st.executeUpdate(); //ejecuta la instruccion sql
            
        } catch (Exception e) {
            e.printStackTrace();//muestra el error
        }
     }
   public void anula(int cod){
        //Connection cn = MySQLConexion.getConexion();
         Connection cn = Conexion.conectar();
        String sql="delete from empleado where code=?";
        try {
            PreparedStatement st=cn.prepareStatement(sql);
            //antes  ejecutar la relacion de  cada ? con su valor 
            st.setInt(1,cod);
            
            st.executeUpdate(); //ejecuta la instruccion sql
            
        } catch (Exception e) {
            e.printStackTrace();//muestra el error
        }
    }
    
      public List<empleado> listEmp(){      
    List<empleado> lista=new ArrayList();
   // Connection cn=MySQLConexion.getConexion();
     Connection cn = Conexion.conectar();
    String sql="select * from empleado";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            empleado ep=new empleado();
            ep.setCodigo(rs.getInt(1));
            ep.setNombre(rs.getString(2));
            ep.setApellido(rs.getString(3));
            ep.setNtipoEmp(rs.getString(4));
            ep.setCorreo(rs.getString(5));
            ep.setPassword(rs.getString(6));
            ep.setNturno(rs.getString(7));
            
            lista.add(ep);
        }
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
        public List<empleado> orden1(){      
    List<empleado> lista=new ArrayList();
    //Connection cn=MySQLConexion.getConexion();
     Connection cn = Conexion.conectar();
    String sql="select * from empleado";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            empleado ep=new empleado();
            ep.setCodigo(rs.getInt(1));
            ep.setNombre(rs.getString(2));
            ep.setApellido(rs.getString(3));
            ep.setNtipoEmp(rs.getString(4));
            ep.setCorreo(rs.getString(5));
            ep.setPassword(rs.getString(6));
            ep.setNturno(rs.getString(7));
            
            lista.add(ep);
        }
        lista.sort(new orden1());
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
         public List<empleado> orden2(){      
    List<empleado> lista=new ArrayList();
    //Connection cn=MySQLConexion.getConexion();
     Connection cn = Conexion.conectar();
    String sql="select * from empleado";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            empleado ep=new empleado();
                ep.setCodigo(rs.getInt(1));
            ep.setNombre(rs.getString(2));
            ep.setApellido(rs.getString(3));
            ep.setNtipoEmp(rs.getString(4));
            ep.setCorreo(rs.getString(5));
            ep.setPassword(rs.getString(6));
            ep.setNturno(rs.getString(7));
            
            lista.add(ep);
        }
        lista.sort(new orden2());
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
          public List<empleado> orden3(){      
    List<empleado> lista=new ArrayList();
    //Connection cn=MySQLConexion.getConexion();
     Connection cn = Conexion.conectar();
    String sql="select * from empleado";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            empleado ep=new empleado();
            ep.setCodigo(rs.getInt(1));
            ep.setNombre(rs.getString(2));
            ep.setApellido(rs.getString(3));
            ep.setNtipoEmp(rs.getString(4));
            ep.setCorreo(rs.getString(5));
            ep.setPassword(rs.getString(6));
            ep.setNturno(rs.getString(7));
            
            lista.add(ep);
        }
        lista.sort(new orden3());
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
              public empleado consulta(int id){      //te regresa solo un empleado no una lista
    empleado ep=null;
    //Connection cn=MySQLConexion.getConexion();
     Connection cn = Conexion.conectar();
    String sql="select * from empleado  where codEmpleado=?";
    try{
        PreparedStatement st=cn.prepareStatement(sql); //la consulta se lleva a uina tabla temporal
        st.setInt(1,id);
        ResultSet rs=st.executeQuery();
        if(rs.next()){//leer fila x fila y llevarlo al arraylist
            ep=new empleado();
            ep.setCodigo(rs.getInt(1));
            ep.setNombre(rs.getString(2));
            ep.setApellido(rs.getString(3));
            ep.setNtipoEmp(rs.getString(4));
            ep.setCorreo(rs.getString(5));
            ep.setPassword(rs.getString(6));
            ep.setNturno(rs.getString(7));
            
            
        }
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return ep;
} 
    


class orden1 implements Comparator<empleado>{

    @Override
    public int compare(empleado o1, empleado o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}


class orden2 implements Comparator<empleado>{
     @Override
     public int compare(empleado o1, empleado o2){
         return o1.getNtipoEmp().compareTo (o2.getNtipoEmp());
     }
}

class orden3 implements Comparator<empleado>{
     @Override
     public int compare(empleado o1, empleado o2){
         return o1.getNturno().compareTo (o2.getNturno());
     }  
}


}