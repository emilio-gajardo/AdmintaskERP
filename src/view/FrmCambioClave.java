package view;

import bo.UsuarioBO;
import dao.UsuarioDAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import test.Validar;
import javax.swing.JOptionPane;

// LIBRERIA DE ENCRIPTACIÓN
// ALGORITMO DE ENCRIPTACIÓN SHA 512 HEX
//import org.apache.commons.codec.digest.DigestUtils;
import test.Hash;

/**
 *
 * @author Emilio
 */
public class FrmCambioClave extends javax.swing.JFrame {

    private UsuarioBO usuarioBO = new UsuarioBO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Validar validar = new Validar();

    //String textoEncriptadoConMD5=DigestUtils.
    public FrmCambioClave() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Admintask - Cambiar Clave");
        setResizable(false);
        pwdClaveNueva.requestFocus();

        //Integración de icono en la ventana de titulo de la ventana
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/icons/icons32px/logo30px.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrmCambioClave.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(image);

        lblId.setVisible(false);
        lblId.setText(FrmUsuario.id);
        lblNombreUsuario.setText(FrmUsuario.nombreCompleto);

        //System.out.println("\n---Recibiendo datos en FrmCambioClave---");
        //System.out.println("ID recibido: " + lblId.getText());
        //System.out.println("Nombre recibido: " + lblNombreUsuario.getText());
    }

    // 19-10-2020
    public void cambiarClave() {

        String mensaje = "";
        String id = lblId.getText();
        int idInt = Integer.parseInt(id);
        String claveNuevaString = new String(pwdClaveNueva.getPassword());
        String claveNuevaConfirmadaString = new String(pwdClaveConfirmada.getPassword());

        // (11-12-2020)(ENCRIPTACIÓN DE CLAVE) (ALGORITMO SHA 512)
        String claveSinEncriptar = new String(pwdClaveConfirmada.getPassword());
        String claveNuevaEncriptada = Hash.sha512(claveSinEncriptar);

        if (validacion(id, claveNuevaString, claveNuevaConfirmadaString) == true) {

            mensaje = usuarioBO.cambiarClave(idInt, claveNuevaEncriptada);
            
            System.out.println("Mensaje: \n" + mensaje);

            JOptionPane.showMessageDialog(null, mensaje, "Infomación", JOptionPane.INFORMATION_MESSAGE);
            
            limpiarCampos();
            
            //tesintg
            System.out.println("\n--Testing--");
            System.out.println("ID: " + idInt);
            System.out.println("claveNueva: " + claveNuevaString);
            System.out.println("claveNuevaEncriptada: " + claveNuevaEncriptada);

        }
    }

    //Limpiar campos
    public void limpiarCampos(){
        pwdClaveNueva.setText("");
        pwdClaveConfirmada.setText("");
    }
    
    // 19-10-2020 Método de validación de credenciales de usuario
    private boolean validacion(String id, String claveNueva, String claveNuevaConfirmada) {

        if (Validar.campoVacio(id) == false) {
            mostrarMensaje("Error: \nEl id está vacío! \nVerifique");
            return false;
        }

        if (Validar.numeroEntero(id) == false) {
            mostrarMensaje("Error: \nEl id debe ser numérico! \nVerifique");
            return false;
        }

        if (Validar.campoVacio(claveNueva) == false) {
            mostrarMensaje("Error: \nLa clave está vacía! \nVerifique");
            return false;
        }

        if (Validar.campoVacio(claveNuevaConfirmada) == false) {
            mostrarMensaje("Error: \nLa clave está vacía! \nVerifique");
            return false;
        }

        if (Validar.comparacionDeClaves(claveNueva, claveNuevaConfirmada) == false) {
            mostrarMensaje("Error: \nLas claves no coinciden! \nVerifique");
            return false;
        }

        return true;
    }

    // 19-10-2020 Método para mostrar mensajes
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNombreUsuario = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pwdClaveConfirmada = new javax.swing.JPasswordField();
        btnCambiarClave = new javax.swing.JButton();
        btnVolverModuloUsuarios = new javax.swing.JButton();
        pwdClaveNueva = new javax.swing.JPasswordField();
        btnVolverPanelGeneral = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(55, 68, 140));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambiar clave");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons64px/cambiarClave128px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Escriba y confirme la nueva contraseña");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cambiando clave al usuario: ");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 204));

        lblId.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33)))
                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("*Clave nueva");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("*Confirmar clave");

        pwdClaveConfirmada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnCambiarClave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCambiarClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/llaveHorizontal32px.png"))); // NOI18N
        btnCambiarClave.setText("Cambiar clave");
        btnCambiarClave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCambiarClave.setIconTextGap(20);
        btnCambiarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarClaveActionPerformed(evt);
            }
        });

        btnVolverModuloUsuarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVolverModuloUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/volver32px.png"))); // NOI18N
        btnVolverModuloUsuarios.setText("Módulo usuarios");
        btnVolverModuloUsuarios.setActionCommand("Módulo usuarios");
        btnVolverModuloUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVolverModuloUsuarios.setIconTextGap(20);
        btnVolverModuloUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverModuloUsuariosActionPerformed(evt);
            }
        });

        pwdClaveNueva.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnVolverPanelGeneral.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnVolverPanelGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/menu32px.png"))); // NOI18N
        btnVolverPanelGeneral.setText("Panel general");
        btnVolverPanelGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVolverPanelGeneral.setIconTextGap(20);
        btnVolverPanelGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPanelGeneralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(pwdClaveNueva)
                    .addComponent(jLabel4)
                    .addComponent(pwdClaveConfirmada)
                    .addComponent(btnVolverPanelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolverModuloUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(190, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addComponent(pwdClaveNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(pwdClaveConfirmada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnCambiarClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnVolverModuloUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnVolverPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 19-10-2020 Llamada al método de validación de acceso
     */
    private void btnCambiarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarClaveActionPerformed
        cambiarClave();
    }//GEN-LAST:event_btnCambiarClaveActionPerformed

    private void btnVolverModuloUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverModuloUsuariosActionPerformed
        new FrmUsuario().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverModuloUsuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new FrmPanelGeneral().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnVolverPanelGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverPanelGeneralActionPerformed
        new FrmPanelGeneral().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverPanelGeneralActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
    public void frmCambioClave() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCambioClave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarClave;
    private javax.swing.JButton btnVolverModuloUsuarios;
    private javax.swing.JButton btnVolverPanelGeneral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblId;
    public static javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPasswordField pwdClaveConfirmada;
    private javax.swing.JPasswordField pwdClaveNueva;
    // End of variables declaration//GEN-END:variables
}
