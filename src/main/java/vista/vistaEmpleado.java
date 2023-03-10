/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorEmpleado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.empleado;

/**
 *
 * @author Jose Luis Huertas Ch
 */
public class vistaEmpleado extends javax.swing.JInternalFrame {
ControladorEmpleado obj=new ControladorEmpleado();
    /**
     * Creates new form vistaEmpleado
     */
    public vistaEmpleado() {
        initComponents();
    }
    
    
    void muestra(){
        DefaultTableModel dt=(DefaultTableModel)tabla1.getModel();
        dt.setRowCount(0);
        for (empleado ep:obj.listEmp()){
            Object v[]={ep.getCodigo(),ep.getNombre(),ep.getApellido(),ep.getNtipoEmp(),ep.getCorreo(),ep.getPassword(),ep.getNturno()};
        dt.addRow(v);
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        rbtTodo = new javax.swing.JRadioButton();
        rbtNombre = new javax.swing.JRadioButton();
        rbtTipo = new javax.swing.JRadioButton();
        rbtTurno = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnConsulta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRes = new javax.swing.JTextArea();
        btnBorrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContrase??a = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        txtTipo = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "APELLIDOS", "TIPO", "CORREO", "CONTRASE??A", "TURNO"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        rbtTodo.setText("Todo");
        rbtTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTodoActionPerformed(evt);
            }
        });

        rbtNombre.setText("Nombre");
        rbtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNombreActionPerformed(evt);
            }
        });

        rbtTipo.setText("Tipo");
        rbtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTipoActionPerformed(evt);
            }
        });

        rbtTurno.setText("Turno");
        rbtTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(rbtTodo)
                .addGap(92, 92, 92)
                .addComponent(rbtNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtTipo)
                .addGap(92, 92, 92)
                .addComponent(rbtTurno)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtTodo)
                    .addComponent(rbtNombre)
                    .addComponent(rbtTipo)
                    .addComponent(rbtTurno))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lista", jPanel2);

        btnConsulta.setText("CONSULTAR");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        jLabel8.setText("INGRESAR CODIGO");

        txtRes.setColumns(20);
        txtRes.setRows(5);
        jScrollPane2.setViewportView(txtRes);

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsulta)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnBorrar)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta", jPanel3);

        jLabel1.setText("REGISTRAR EMPLEADO");

        jLabel2.setText("CORREO");

        jLabel3.setText("CONTRASE??A");

        jLabel4.setText("TURNO");

        jLabel5.setText("NOMBRE");

        jLabel6.setText("APELLIDO");

        jLabel7.setText("TIPO");

        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtContrase??a)
                            .addComponent(txtTipo)
                            .addComponent(txtTurno)))
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtContrase??a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnGrabar)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTodoActionPerformed
        muestra();
    }//GEN-LAST:event_rbtTodoActionPerformed

    private void rbtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNombreActionPerformed
        DefaultTableModel dt=(DefaultTableModel)tabla1.getModel();
        dt.setRowCount(0);
        for (empleado ep:obj.orden1()){
            Object v[]={ep.getCodigo(),ep.getNombre(),ep.getApellido(),ep.getNtipoEmp(),ep.getCorreo(),ep.getPassword(),ep.getNturno()};
            dt.addRow(v);
        }
    }//GEN-LAST:event_rbtNombreActionPerformed

    private void rbtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTipoActionPerformed
        DefaultTableModel dt=(DefaultTableModel)tabla1.getModel();
        dt.setRowCount(0);
        for (empleado ep:obj.orden2()){
            Object v[]={ep.getCodigo(),ep.getNombre(),ep.getApellido(),ep.getNtipoEmp(),ep.getCorreo(),ep.getPassword(),ep.getNturno()};
            dt.addRow(v);
        }
    }//GEN-LAST:event_rbtTipoActionPerformed

    private void rbtTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTurnoActionPerformed
        DefaultTableModel dt=(DefaultTableModel)tabla1.getModel();
        dt.setRowCount(0);
        for (empleado ep:obj.orden3()){
            Object v[]={ep.getCodigo(),ep.getNombre(),ep.getApellido(),ep.getNtipoEmp(),ep.getCorreo(),ep.getPassword(),ep.getNturno()};
            dt.addRow(v);
        }
    }//GEN-LAST:event_rbtTurnoActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        int cod=Integer.parseInt(txtCodigo.getText());
        empleado ep=obj.consulta(cod);
        if(ep==null){
            txtRes.setText("No existe codigo");return;
        }
        btnBorrar.setEnabled(true);
        txtRes.setText("Nombre: "+ep.getNombre());
        txtRes.append("\nApellido: "+ep.getApellido());
        txtRes.append("\nTipo: "+ep.getNtipoEmp());
        txtRes.append("\nCorreo: "+ep.getCorreo());
        txtRes.append("\nTurno: "+ep.getNturno());
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int cod=Integer.parseInt(txtCodigo.getText());
        obj.anula(cod);
        btnBorrar.setEnabled(false);
        txtRes.setText("reg. Borrado");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        empleado ep=new empleado();
        ep.setCorreo(txtCorreo.getText());
        ep.setPassword(txtContrase??a.getText());
        ep.setNombre(txtNombre.getText());
        ep.setApellido(txtApellido.getText());
        ep.setNtipoEmp(txtTipo.getText());
        ep.setNturno(txtTurno.getText());

        obj.adiciona(ep);//graba en la base de datos

        JOptionPane.showMessageDialog(null, "grabacion ok");
        txtNombre.setText(""); txtTipo.setText("");
        txtCorreo.setText(""); txtContrase??a.setText(""); txtApellido.setText(""); txtTurno.setText("");
    }//GEN-LAST:event_btnGrabarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbtNombre;
    private javax.swing.JRadioButton rbtTipo;
    private javax.swing.JRadioButton rbtTodo;
    private javax.swing.JRadioButton rbtTurno;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContrase??a;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtRes;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables
}
