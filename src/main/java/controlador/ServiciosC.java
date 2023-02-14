
package controlador;
import modelo.*;



//import util.MySQLConexion;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.swing.JOptionPane;
//import modelo.Empleados;


import java.sql.*;
import java.util.*;
import java.util.Comparator;

public class ServiciosC {
     
    public servicio consulta(int id){
        servicio ep=null;
        //Connection cn = MySQLConexion.getConexion();
       Connection cn = Conexion.conectar();
        String sql="select * from servicio where codServicio=?";
        
        try {
            
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1,id);
            
            ResultSet rs=st.executeQuery();
            if(rs.next()){//leer filaxfila y llevarlo al arraylist
                ep=new servicio();
                ep.setCodigo(rs.getInt(1));
                ep.setTipoSer(rs.getString(2));
                ep.setPrecio(rs.getDouble(3));
                
           
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ep;
    }
     public List<servicio> listEmp(){      
    List<servicio> lista=new ArrayList();
    //Connection cn=MySQLConexion.getConexion();
    Connection cn = Conexion.conectar();
    String sql="select * from servicio";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            servicio ep=new servicio();
            ep.setCodigo(rs.getInt(1));
            ep.setTipoSer(rs.getString(2));
            ep.setPrecio(rs.getDouble(3));
            
            lista.add(ep);
        }
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
     public void adiciona(servicio ep){
        //Connection cn = MySQLConexion.getConexion();
        Connection cn = Conexion.conectar();
        String sql="insert into servicio values(null,?,?)";
        
        try {
            PreparedStatement st=cn.prepareStatement(sql);
            //antes de ejecutar relacion cada ? con su valor 
            st.setString(1, ep.getTipoSer());
            st.setDouble(2, ep.getPrecio());
            
            st.executeUpdate(); //ejecuta la instruccion sql
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      
    public List<servicio> orden1(){      
    List<servicio> lista=new ArrayList();
    //Connection cn=MySQLConexion.getConexion();
    Connection cn = Conexion.conectar();
    String sql="select * from servicio";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            servicio ep=new servicio();
            ep.setCodigo(rs.getInt(1));
            ep.setTipoSer(rs.getString(2));
            ep.setPrecio(rs.getDouble(3));
            
            lista.add(ep);
        }
        lista.sort(new orden1());
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
    public List<servicio> orden2(){      
    List<servicio> lista=new ArrayList();
//    Connection cn=MySQLConexion.getConexion();
    Connection cn = Conexion.conectar();
    String sql="select * from servicio";
    try{
        PreparedStatement st=cn.prepareStatement(sql); 
        ResultSet rs=st.executeQuery();
        while(rs.next()){//leer fila x fila y llevarlo al arraylist
            servicio ep=new servicio();
            ep.setCodigo(rs.getInt(1));
            ep.setTipoSer(rs.getString(2));
            ep.setPrecio(rs.getDouble(3));
            
            lista.add(ep);
        }
        lista.sort(new orden2());
    } catch (Exception ex){
        ex.printStackTrace();
    }
    return lista;
}
    public void anula(int cod){
//        Connection cn = MySQLConexion.getConexion();
        Connection cn = Conexion.conectar();
        String sql="delete from servicio where code=?";
        
        try {
            PreparedStatement st=cn.prepareStatement(sql);
            
            st.setInt(1, cod);
            
            st.executeUpdate(); 
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
   
}
class orden1 implements Comparator<servicio>{

    @Override
    public int compare(servicio o1, servicio o2) {
        return o1.getTipoSer().compareTo(o2.getTipoSer());
       
    }

}
class orden2 implements Comparator<servicio>{
     @Override
     public int compare(servicio o1, servicio o2){
         return (int) (o2.getPrecio()- o1.getPrecio());
     }
}


