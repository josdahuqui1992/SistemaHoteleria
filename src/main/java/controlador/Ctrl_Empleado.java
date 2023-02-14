/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Empleados;

/**
 *
 * @author Jose David Huertas Q
 */
public class Ctrl_Empleado {
    public boolean loginUser(Empleados objeto){

        boolean respuesta = false;
        //Conexion cnn = new Conexion();
       // Connection cn = Conexion.conectar();
       Connection cn = Conexion.conectar();
        //Connection cn = cnn.getConnection();
        String sql = "select usuario, clave from empleado where usuario ='" + objeto.getUsuario() + "' and clave= '" + objeto.getClave() + "'";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al Iniciar sesion");
            JOptionPane.showMessageDialog(null, "Error al Iniciar sesion");
        }
        return respuesta;
    }
}
