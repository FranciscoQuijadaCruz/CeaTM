/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.ceasonora.tonerManagement.gui.administrar.ver;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import mx.gob.ceasonora.tonerManagement.entidades.Usuario;
import mx.gob.ceasonora.tonerManagement.gui.administrar.AdministrarUsuarios;
import mx.gob.ceasonora.tonerManagement.implementaciones.UsuarioImp;
import mx.gob.ceasonora.tonerManagement.interfaces.UsuarioInt;


/**
 *
 * @author kevin
 */
public class VerUsuario extends javax.swing.JInternalFrame {
    Usuario usuario;
    boolean contrasenaCorrecta = true;

    /**
     * Creates new form NuevoUsuario
     */
    public VerUsuario() {
        initComponents();
        usuario = AdministrarUsuarios.usuario;
        idTextField.setText(String.valueOf(usuario.getId()));
        nombreUsuarioTextField.setText(usuario.getNombreUsuario());
        contrasenaTextField.setText(usuario.getContrasena());
        repetirContrasenaTextField.setText(usuario.getContrasena());
        nombreTextField.setText(usuario.getNombre());
        areaTextField.setText(usuario.getArea());
        puestoTextField.setText(usuario.getPuesto());
        correoTextField.setText(usuario.getCorreo());
        telefonoTextField.setText(usuario.getTelefono());
        String fechaRegistro = new SimpleDateFormat("dd-MM-yyyy").format(usuario.getFechaRegistro());
        fechaRegistroTextField.setText(fechaRegistro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nombreUsuarioTextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        areaTextField = new javax.swing.JTextField();
        puestoTextField = new javax.swing.JTextField();
        correoTextField = new javax.swing.JTextField();
        telefonoTextField = new javax.swing.JTextField();
        guardarButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        verificacionContrasenaLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cambiarContrasenaButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        contrasenaTextField = new javax.swing.JPasswordField();
        repetirContrasenaTextField = new javax.swing.JPasswordField();
        cambiarNombreUsuarioButton = new javax.swing.JButton();
        fechaRegistroTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver/Editar Usuario");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombre de Usuario:");

        jLabel5.setText("Nombre:");

        jLabel6.setText("Area:");

        jLabel7.setText("Puesto:");

        jLabel8.setText("Correo:");

        jLabel9.setText("Teléfono:");

        nombreUsuarioTextField.setEnabled(false);

        nombreTextField.setEnabled(false);

        areaTextField.setEnabled(false);

        puestoTextField.setEnabled(false);

        correoTextField.setEnabled(false);

        telefonoTextField.setEnabled(false);

        guardarButton.setText("Guardar Cambios");
        guardarButton.setEnabled(false);
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        verificacionContrasenaLabel.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        verificacionContrasenaLabel.setForeground(new java.awt.Color(255, 0, 51));
        verificacionContrasenaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        idTextField.setEnabled(false);

        jLabel11.setText("ID:");

        cambiarContrasenaButton.setText("Cambiar Contraseña");
        cambiarContrasenaButton.setEnabled(false);
        cambiarContrasenaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarContrasenaButtonActionPerformed(evt);
            }
        });

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Contraseña:");

        jLabel3.setText("Repetir contraseña:");

        contrasenaTextField.setEnabled(false);
        contrasenaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contrasenaTextFieldKeyReleased(evt);
            }
        });

        repetirContrasenaTextField.setEnabled(false);
        repetirContrasenaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                repetirContrasenaTextFieldKeyReleased(evt);
            }
        });

        cambiarNombreUsuarioButton.setText("Cambiar Nombre de Usuario");
        cambiarNombreUsuarioButton.setEnabled(false);
        cambiarNombreUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarNombreUsuarioButtonActionPerformed(evt);
            }
        });

        fechaRegistroTextField.setEnabled(false);

        jLabel13.setText("Fecha de Registro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cambiarContrasenaButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(verificacionContrasenaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(contrasenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(repetirContrasenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cambiarNombreUsuarioButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fechaRegistroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombreUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreTextField)
                            .addComponent(areaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(puestoTextField)
                            .addComponent(correoTextField)
                            .addComponent(telefonoTextField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardarButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(areaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaRegistroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(puestoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(correoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardarButton)
                            .addComponent(editarButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombreUsuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiarNombreUsuarioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(contrasenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(repetirContrasenaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cambiarContrasenaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(verificacionContrasenaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarButtonActionPerformed

        nombreTextField.setEnabled(true);
        areaTextField.setEnabled(true);
        puestoTextField.setEnabled(true);
        correoTextField.setEnabled(true);
        telefonoTextField.setEnabled(true);
        guardarButton.setEnabled(true);
        cambiarContrasenaButton.setEnabled(true);
        cambiarNombreUsuarioButton.setEnabled(true);
        
    }//GEN-LAST:event_editarButtonActionPerformed

    private void cambiarNombreUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarNombreUsuarioButtonActionPerformed

        if(JOptionPane.showInputDialog(null, "Introduzca su contraseña actual para continuar", "Verificar Usuario", JOptionPane.QUESTION_MESSAGE).equals(usuario.getContrasena())){
            JOptionPane.showMessageDialog(null, "Usuario verificado, los cambios se guardarán cuando seleccione la opción 'Guardar cambios',", "suario verificado", JOptionPane.INFORMATION_MESSAGE);
            nombreUsuarioTextField.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Usuario no verificado", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_cambiarNombreUsuarioButtonActionPerformed

    private void cambiarContrasenaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarContrasenaButtonActionPerformed

        if(JOptionPane.showInputDialog(null, "Introduzca su contraseña actual para continuar", "Verificar Usuario", JOptionPane.QUESTION_MESSAGE).equals(usuario.getContrasena())){
            JOptionPane.showMessageDialog(null, "Usuario verificado, los cambios se guardarán cuando seleccione la opción 'Guardar cambios',", "suario verificado", JOptionPane.INFORMATION_MESSAGE);
            contrasenaTextField.setEnabled(true);
            repetirContrasenaTextField.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.", "Usuario no verificado", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_cambiarContrasenaButtonActionPerformed

    private void contrasenaTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contrasenaTextFieldKeyReleased

        if(Arrays.equals(contrasenaTextField.getPassword(), repetirContrasenaTextField.getPassword())){
            verificacionContrasenaLabel.setText("");
            contrasenaCorrecta = true;
        }else{
            verificacionContrasenaLabel.setText("Las contraseñas no coinciden");
            contrasenaCorrecta = false;
        }
        
    }//GEN-LAST:event_contrasenaTextFieldKeyReleased

    private void repetirContrasenaTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repetirContrasenaTextFieldKeyReleased

        if(Arrays.equals(contrasenaTextField.getPassword(), repetirContrasenaTextField.getPassword())){
            verificacionContrasenaLabel.setText("");
            contrasenaCorrecta = true;
        }else{
            verificacionContrasenaLabel.setText("Las contraseñas no coinciden");
            contrasenaCorrecta = false;
        }
        
    }//GEN-LAST:event_repetirContrasenaTextFieldKeyReleased

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed

        if (nombreUsuarioTextField.getText().isEmpty() || new String(contrasenaTextField.getPassword()).isEmpty() || new String(repetirContrasenaTextField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los siguientes campos no pueden estar vacíos: \nNombre de Usuario\nContraseña\nRepetir contraseña", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        } else if (!contrasenaCorrecta) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, verifique por favor", "Contraseña no verificada", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                usuario.setNombre(nombreTextField.getText());
                usuario.setArea(areaTextField.getText());
                usuario.setContrasena(new String(contrasenaTextField.getPassword()));
                usuario.setCorreo(correoTextField.getText());
                usuario.setNombreUsuario(nombreUsuarioTextField.getText());
                usuario.setPuesto(puestoTextField.getText());
                usuario.setTelefono(telefonoTextField.getText());
                UsuarioInt usrImp = new UsuarioImp();
               
                if (usrImp.Editar(usuario,usuario)) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados con éxito", "Cambios guardados", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                
            } catch (Exception e) {
            }
        }
        
    }//GEN-LAST:event_guardarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaTextField;
    private javax.swing.JButton cambiarContrasenaButton;
    private javax.swing.JButton cambiarNombreUsuarioButton;
    private javax.swing.JPasswordField contrasenaTextField;
    private javax.swing.JTextField correoTextField;
    private javax.swing.JButton editarButton;
    private javax.swing.JTextField fechaRegistroTextField;
    private javax.swing.JButton guardarButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField nombreUsuarioTextField;
    private javax.swing.JTextField puestoTextField;
    private javax.swing.JPasswordField repetirContrasenaTextField;
    private javax.swing.JTextField telefonoTextField;
    private javax.swing.JLabel verificacionContrasenaLabel;
    // End of variables declaration//GEN-END:variables
}
