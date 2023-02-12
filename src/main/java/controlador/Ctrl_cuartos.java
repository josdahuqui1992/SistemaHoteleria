/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Jose David Huertas Q
 */
public class Ctrl_cuartos {

    public ArrayList<CategCuartos> getCategCuartoses() {

        Connection cn = conexion.Conexion.conectar();
        Statement stmt;
        ResultSet rs;
        ArrayList<CategCuartos> listacategoriacuartos = new ArrayList<>();

        try {
            stmt = cn.createStatement();
            rs = stmt.executeQuery("select * from categcuartos");

            while (rs.next()) {
                CategCuartos catecua = new CategCuartos();
                catecua.setCodcategoria(rs.getInt("idcategoria"));
                catecua.setNombrecategoria(rs.getString("nombrecat"));
                catecua.setEstado(rs.getString("estado"));
                listacategoriacuartos.add(catecua);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_cuartos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listacategoriacuartos;
    }

    public ArrayList<PuestoCuartos> getPuestoCuartoses() {

        Connection cn = conexion.Conexion.conectar();
        Statement stmt;
        ResultSet rs;
        ArrayList<PuestoCuartos> listapuestocuartos = new ArrayList<>();

        try {
            stmt = cn.createStatement();
            rs = stmt.executeQuery("select * from puestocuartos");

            while (rs.next()) {
                PuestoCuartos puestocua = new PuestoCuartos();
                puestocua.setCodestado(rs.getInt("idestado"));
                puestocua.setNombrepuest(rs.getString("nombrepuesto"));
                puestocua.setEstado(rs.getString("estado"));
                listapuestocuartos.add(puestocua);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ctrl_cuartos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listapuestocuartos;
    }

    //ESTO SE AGREGUO PARA REALIZAR LOS FILTROS
    // private List<Cuartos> listacuartos = new ArrayList();
    public boolean registrar_ALquilerCuarto(Cuartos objeto) {
        boolean respuesta = false;
        //Conexion cnn = new Conexion();
        Connection cn = conexion.Conexion.conectar();

        try {
            PreparedStatement regisCuartos = cn.prepareStatement("insert into cuartos values(?,?,?,?)");
            regisCuartos.setInt(1, objeto.getCodcuartos());
            regisCuartos.setString(2, objeto.getCategoria());
            regisCuartos.setDouble(3, objeto.getPreciodia());
            regisCuartos.setString(4, objeto.getPuesto());
            if (regisCuartos.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Guardar datos en el controlador cuartos " + e);
        }
        return respuesta;
    }

    public boolean modificar_AquilerCuartos(Cuartos objeto2, int idcliente) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement modificarAl = cn.prepareStatement("update cuartos set idcategoria=?, precioxdia=?, idestado=? where codCuartos ='" + idcliente + "'");

            modificarAl.setString(1, objeto2.getCategoria());
            modificarAl.setDouble(2, objeto2.getPreciodia());
            modificarAl.setString(3, objeto2.getPuesto());

            if (modificarAl.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Modificar el Alquiler en el controlador " + e);
        }
        return respuesta;
    }

    public boolean eliminar_Alquiler(int idcliente) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("delete from cuartos where codCuartos='" + idcliente + "' ");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Eliminar registro de alquiler en el controlador " + e);
        }
        return respuesta;
    }

    public boolean consultar_AquilerCuartos(Cuartos objeto2, int idcliente) {

        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement modificarAl = cn.prepareStatement("select * from cuartos");

            modificarAl.setString(1, objeto2.getCategoria());
            modificarAl.setDouble(2, objeto2.getPreciodia());
            modificarAl.setString(3, objeto2.getPuesto());

            if (modificarAl.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al Modificar el Alquiler en el controlador " + e);
        }
        return respuesta;
    }

//    public boolean busca(int nro) {
//
//        boolean respuesta = false;
//        Connection cn = Conexion.conectar();
//        try {
//            PreparedStatement consulta = cn.prepareStatement("select * from cuartos where codCuartos='" + nro + "'");
//            consulta.executeUpdate();
//
//            if (consulta.executeUpdate() > 0) {
//                respuesta = true;
//            }
//            cn.close();
//        } catch (SQLException e) {
//            System.out.println("Error al Eliminar registro de alquiler en el controlador " + e);
//        }
//        return respuesta;
//    }



//    
//    
//
//    public List<Cuartos> getListacuartos() {
//        return listacuartos;
//    }
//
//    public void setListacuartos(List<Cuartos> listacuartos) {
//        this.listacuartos = listacuartos;
//    }
}
