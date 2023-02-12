/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexion;
import controlador.Ctrl_cuartos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.CategCuartos;
import modelo.PuestoCuartos;
import javax.swing.table.DefaultTableModel;
import modelo.Cuartos;

/**
 *
 * @author Jose David Huertas Q
 */
public class vistaCuartos extends javax.swing.JInternalFrame {

    //Ctrl_cuartos list = new Ctrl_cuartos();
    DefaultTableModel modelo;
    Statement st;
    int idcliente = 0;

    /**
     * Creates new form vistaCuartos
     */
    public vistaCuartos() {
        initComponents();
        this.setTitle("Registrar un Alquiler de Cuarto");
        llenarcategoriacuartos();
        llenarpuestocuartos();
        llenarTituloJTable();
        llenarTituloJTable2();
        verDatosTablaDB();
        //verDatosTabla1DB("");
        CargarTabla("");

    }

    private void llenarcategoriacuartos() {

        Ctrl_cuartos controlcuartos = new Ctrl_cuartos();
        ArrayList<CategCuartos> listacategoriac = controlcuartos.getCategCuartoses();

        //jComboBox_categoria.removeAllItems(); // remover todos los items
        for (int i = 0; i < listacategoriac.size(); i++) {
            //jComboBox_categoria.addItem(new CategCuartos(listacategoriac.get(i).getEstado(), listacategoriac.get(i).getNombrecategoria()));
            jComboBox_categoria.addItem(listacategoriac.get(i).getNombrecategoria());
            jComboBox_CATEGORIA.addItem(listacategoriac.get(i).getNombrecategoria());
            //code	type Parameters	<modelo.CategCuartos>
        }

    }

    private void llenarpuestocuartos() {

        Ctrl_cuartos controlcuartos = new Ctrl_cuartos();
        ArrayList<PuestoCuartos> listapuestoc = controlcuartos.getPuestoCuartoses();

        // jComboBox_estado.removeAllItems(); // remover todos los items
        for (int i = 0; i < listapuestoc.size(); i++) {
            //jComboBox_estado.addItem(new PuestoCuartos(listapuestoc.get(i).getEstado(), listapuestoc.get(i).getNombrepuest()));
            jComboBox_estado.addItem(listapuestoc.get(i).getNombrepuest());
            jComboBox_ESTADOS.addItem(listapuestoc.get(i).getNombrepuest());
            //code	type Parameters	<modelo.PuestoCuartos>
        }

    }

    private void llenarTituloJTable() {

        modelo = new DefaultTableModel();
        modelo.addColumn("codCuartos");
        modelo.addColumn("nombrecat");
        modelo.addColumn("precioXdia");
        modelo.addColumn("nombrepuesto");
        Table.setModel(modelo);

    }

    private void llenarTituloJTable2() {

        modelo = new DefaultTableModel();
        modelo.addColumn("codCuartos");
        modelo.addColumn("nombrecat");
        modelo.addColumn("precioXdia");
        modelo.addColumn("nombrepuesto");
        Table1_Buscar.setModel(modelo);

    }
//              ORIGINAL

    private void verDatosTablaDB() {
        //declarar un DefaultTableModel para enviar el nuevo modelo a la tabla
        DefaultTableModel modelo = (DefaultTableModel) Table.getModel();
        //comenzar de cero 0
        modelo.setNumRows(0);
        //decalracion de vector de tipo objeto para almacenar los datos que se obtiene
        Object[] tablaCuartos = new Object[4];
        String sql = "SELECT * FROM cuartos;";

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tablaCuartos[0] = rs.getInt("codCuartos");
                tablaCuartos[1] = rs.getString("idcategoria");
                tablaCuartos[2] = rs.getDouble("precioXdia");
                tablaCuartos[3] = rs.getString("idestado");
                modelo.addRow(tablaCuartos);
            }
            Table.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("Error al ver datos en la tabla BD" + e);
        }
    }

    private void verDatosTabla1DB(JTable Table1, String cadena) {
        //declarar un DefaultTableModel para enviar el nuevo modelo a la tabla
        DefaultTableModel modelo1 = (DefaultTableModel) Table1_Buscar.getModel();
        //comenzar de cero 0
        modelo1.setNumRows(0);
        //decalracion de vector de tipo objeto para almacenar los datos que se obtiene
        Object[] tablaCuartos = new Object[4];
        String sql = "select * from cuartos where idcategoria LIKE '%" + cadena + "%'   ";

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                tablaCuartos[0] = rs.getInt("codCuartos");
                tablaCuartos[1] = rs.getString("idcategoria");
                tablaCuartos[2] = rs.getDouble("precioXdia");
                tablaCuartos[3] = rs.getString("idestado");
                modelo1.addRow(tablaCuartos);
            }
            Table1.setModel(modelo1);

        } catch (SQLException e) {
            System.out.println("Error al ver datos en la tabla BD" + e);
        }
    }

    private void Agregar_Datos() {

        Cuartos cuartos = new Cuartos();
        Ctrl_cuartos controlcuartos = new Ctrl_cuartos();

        if (jComboBox_categoria.getSelectedItem().equals("Seleccione") || jComboBox_estado.getSelectedItem().equals("Seleccione") && txt_precio.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Complete todos los campos");

        } else {
            //pagacliente.setIdpagoCli(0);
            cuartos.setCategoria(jComboBox_categoria.getSelectedItem().toString());
            cuartos.setPuesto(jComboBox_estado.getSelectedItem().toString());
            cuartos.setPreciodia(Double.parseDouble(txt_precio.getText()));

            if (controlcuartos.registrar_ALquilerCuarto(cuartos)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                this.LimpiarDatos();

            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardadar");
            }
        }

    }

    private void ActualizarDatos() {
        Cuartos cuartos = new Cuartos();
        Ctrl_cuartos controlcuartos = new Ctrl_cuartos();

        if (idcliente == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Alquiler!");
        } else {
            if (jComboBox_CATEGORIA.getSelectedItem().equals("Seleccione") && jComboBox_ESTADOS.getSelectedItem().equals("Seleccione") && txt_precio.getText().isEmpty()) {
                //if ( TXT_PRECIO2.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null, "¡Completa todos los campos!");

            } else {
                cuartos.setCategoria(jComboBox_CATEGORIA.getSelectedItem().toString());
                cuartos.setPuesto(jComboBox_ESTADOS.getSelectedItem().toString());
                cuartos.setPreciodia(Double.parseDouble(TXT_PRECIO2.getText()));

                if (controlcuartos.modificar_AquilerCuartos(cuartos, idcliente)) {
                    JOptionPane.showMessageDialog(null, "¡Actualizacion Exitosa!");
                    this.LimpiarDatos();

                    this.CargarTabla("");
                    idcliente = 0;

                } else {
                    JOptionPane.showMessageDialog(null, "¡Error al Actualizar Alquiler!");
                }
            }
        }

    }

    private void consultarDatos() {
        
        String sql = "select * from cuartos";

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String cod = rs.getString(1);
                String cat = rs.getString(2);
                String pre = rs.getString(3);
                String pue = rs.getString(4);
                
                txtRes.append("Codigo : "+cod+"\n");
                txtRes.append("Categoria : "+cat+"\n");
                txtRes.append("Precio x Dia : "+pre+"\n");
                txtRes.append("Estado del Alquiler : "+pue+"\n");

            }

        } catch (SQLException e) {
            System.out.println("Error al ver datos en la tabla BD" + e);
        }
      
    }
    private void EliminarDatosAlquilerCuartos() {

        Ctrl_cuartos controlEliminarCuartos = new Ctrl_cuartos();
        if (idcliente == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Alquiler!");
        } else {
            if (!controlEliminarCuartos.eliminar_Alquiler(idcliente)) {
                JOptionPane.showMessageDialog(null, "¡Allquiler Eliminado!");
                this.LimpiarDatos();
                this.CargarTabla("");
                idcliente = 0;
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar Alquiler de Cuartos!");
                this.LimpiarDatos();
            }
        }

    }

    private void LimpiarDatos() {
        jComboBox_categoria.setSelectedIndex(0);
        jComboBox_CATEGORIA.setSelectedIndex(0);
        jComboBox_estado.setSelectedIndex(0);
        jComboBox_ESTADOS.setSelectedIndex(0);
        txt_precio.setText("");
        TXT_PRECIO2.setText("");

    }

    void CargarTabla(String cad) {
        Ctrl_cuartos c = new Ctrl_cuartos();
        verDatosTabla1DB(Table1_Buscar, cad);
        //verDatosTablaDB(Table, cad);
        //verDatosTablaDB(Table1, cad); //original
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_categoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_estado = new javax.swing.JComboBox<>();
        txt_precio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jRadioButton_TODO = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table1_Buscar = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_filtra2 = new javax.swing.JTextField();
        btnResetear = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_COD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_CATEGORIA = new javax.swing.JComboBox<>();
        jComboBox_ESTADOS = new javax.swing.JComboBox<>();
        TXT_PRECIO2 = new javax.swing.JTextField();
        btnELIMINAR = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNro = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtRes = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Alquiler de Cuarto"));

        jLabel2.setText("Categoria: ");

        jComboBox_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel6.setText("Estado:");

        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));

        jLabel4.setText("Precio:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_categoria, 0, 198, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(131, 131, 131))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Base Datos - tabla cuartos"));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addContainerGap(539, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addGap(61, 61, 61)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar Alquiler de Cuarto", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(jRadioButton_TODO);
        jRadioButton_TODO.setText("Todo");
        jRadioButton_TODO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_TODOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jRadioButton_TODO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton_TODO)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Table cuartos"));

        Table1_Buscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table1_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1_BuscarMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Table1_Buscar);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel1.setText("FILTRAR:");

        txt_filtra2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_filtra2KeyReleased(evt);
            }
        });

        btnResetear.setText("Resetear");
        btnResetear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetearActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Alquiler cuarto"));

        jLabel3.setText("COD:");

        txt_COD.setEditable(false);
        txt_COD.setEnabled(false);

        jLabel5.setText("ESTADO");

        jLabel7.setText("CATEGORIA");

        jLabel9.setText("PRECIO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(139, 139, 139)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_ESTADOS, 0, 206, Short.MAX_VALUE)
                            .addComponent(jComboBox_CATEGORIA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TXT_PRECIO2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_COD, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_COD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox_CATEGORIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox_ESTADOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TXT_PRECIO2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        btnELIMINAR.setText("Eliminar");
        btnELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnELIMINARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResetear)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_filtra2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnELIMINAR)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_filtra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnResetear)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(btnELIMINAR))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buscar", jPanel5);

        jLabel8.setText("CODIGO");

        btnConsulta.setText("CONSULTA");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        txtRes.setColumns(20);
        txtRes.setRows(5);
        jScrollPane3.setViewportView(txtRes);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(566, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultar", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        this.Agregar_Datos();
        this.verDatosTablaDB();
        this.CargarTabla("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseClicked

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        // TODO add your handling code here:

        this.consultarDatos();
    }//GEN-LAST:event_btnConsultaActionPerformed

//    private void filtra(String cad) {
//       
//        DefaultTableModel dt = (DefaultTableModel) Table1.getModel();
//        dt.setRowCount(0);
//        list.getListacuartos().stream().filter(x -> x.getCategoria().toLowerCase().startsWith(cad)).
//                forEach(a -> dt.addRow(new Object[]{a.getCodcuartos(), a.getCategoria(), a.getPuesto(), 
//                    a.getPreciodia()}));
//    }

    private void Table1_BuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1_BuscarMouseClicked
        // TODO add your handling code here:

        int fila = Table1_Buscar.rowAtPoint(evt.getPoint());
        int columna_point = 0;

        if (fila > -1) {
            idcliente = (int) Table1_Buscar.getValueAt(fila, columna_point);

            EnviarDatosUsuarioSeleccionado(idcliente);//metodo
        }


    }//GEN-LAST:event_Table1_BuscarMouseClicked

    private void EnviarDatosUsuarioSeleccionado(int idcliente) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from cuartos where codCuartos  = '" + idcliente + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_COD.setText(rs.getString("codCuartos"));
                jComboBox_CATEGORIA.setSelectedItem(rs.getString("idcategoria"));
                jComboBox_ESTADOS.setSelectedItem(rs.getString("idestado"));
                TXT_PRECIO2.setText(rs.getString("precioxdia"));

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar usuario: " + e);
        }
    }


    private void jRadioButton_TODOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_TODOActionPerformed
        // TODO add your handling code here:
        //this.verTodo();
    }//GEN-LAST:event_jRadioButton_TODOActionPerformed

    private void btnResetearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetearActionPerformed
        // TODO add your handling code here:
        CargarTabla("");
        txt_filtra2.setText(null);
    }//GEN-LAST:event_btnResetearActionPerformed

    private void txt_filtra2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtra2KeyReleased
        // TODO add your handling code here:
        CargarTabla(txt_filtra2.getText());
    }//GEN-LAST:event_txt_filtra2KeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        this.ActualizarDatos();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnELIMINARActionPerformed
        // TODO add your handling code here:
        this.EliminarDatosAlquilerCuartos();
    }//GEN-LAST:event_btnELIMINARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TXT_PRECIO2;
    private javax.swing.JTable Table;
    private javax.swing.JTable Table1_Buscar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnELIMINAR;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnResetear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox_CATEGORIA;
    private javax.swing.JComboBox<String> jComboBox_ESTADOS;
    private javax.swing.JComboBox<String> jComboBox_categoria;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton_TODO;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtNro;
    private javax.swing.JTextArea txtRes;
    private javax.swing.JTextField txt_COD;
    private javax.swing.JTextField txt_filtra2;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables

}
