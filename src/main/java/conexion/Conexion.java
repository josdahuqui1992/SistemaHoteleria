/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jose David Huertas Q
 */
public class Conexion {
    
    public static Connection conectar(){
        Connection SQLConexion = null;
        //Ruta URL de Base de Datos
        String host="localhost";
        String puerto="3306";
        String nombreBD="bdhotel";
        
        //Acceder URL usuario y contrseñia
        String usuario="root";
        String contrasenia="";
        
        //Driver
        String driver="com.mysql.cj.jdbc.Driver";
      
        
        //Construir url
        String urlbd="jdbc:mysql://"+host+":"+puerto+"/"+nombreBD+"?useSSL=false";
        
        try {
            Class.forName(driver);
            SQLConexion= DriverManager.getConnection(urlbd,usuario,contrasenia);
            System.out.println("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos"+e);
        }
         return SQLConexion;
    }
     
    
}
