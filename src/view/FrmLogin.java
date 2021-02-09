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
public class FrmLogin extends javax.swing.JFrame {

    private UsuarioBO usuarioBO = new UsuarioBO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Validar validar = new Validar();

    //String secretKey = "claveSecreta";

    //Datos usados en el FrmCambioClave
    public static String rutLogin = "";


    //String textoEncriptadoConMD5=DigestUtils.
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Admintask - Ingreso de Usuario");
        setResizable(false);
        txtRutLogin.requestFocus();

        //Integración de icono en la ventana de titulo de la ventana
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/icons/icons32px/logo30px.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(image);
    }

    // 19-10-2020
    public void validarAcceso() {

        boolean respuesta = false;
        String rutString = txtRutLogin.getText();
        String digv = cmbDigvLogin.getSelectedItem().toString();

        //****************************************************************
        // 25-10-2020
        // ENCRIPTACIÓN DE CLAVE
        // ALGORITMO SHA 512
        String claveSinEncriptar = new String(pwdClaveLogin.getPassword());
        String claveEncriptada = Hash.sha512(claveSinEncriptar);

        //String claveEncriptada = DigestUtils.sha512Hex(claveSinEncriptar);
        //byte[] bytes = DigestUtils.sha512(claveSinEncriptar);
        //String claveEncriptada = new String(bytes);
        //*****************************************************************
        if (validacion(rutString, digv, claveSinEncriptar) == true) {

            int rutInt = Integer.parseInt(txtRutLogin.getText());

            respuesta = usuarioBO.login(rutInt, digv, claveEncriptada);

            if (respuesta == true) {
                FrmPanelGeneral frmPanelGeneral = new FrmPanelGeneral();
                //frmPanelGeneral.setVisible(true);
                frmPanelGeneral.frmPanelGeneral();
                this.dispose();
                rutLogin = txtRutLogin.getText();
//                System.out.println("Testing");
//                System.out.println("rut: " + rutInt);
//                System.out.println("digv: " + digv);
//                System.out.println("Clave sin encriptar: " + claveSinEncriptar);
//                System.out.println("Clave encriptada: " + claveEncriptada);
            } else {
                JOptionPane.showMessageDialog(this, "Error de credenciales!");
//                System.out.println("Testing");
//                System.out.println("rut: " + rutInt);
//                System.out.println("digv: " + digv);
//                System.out.println("Clave sin encriptar: " + claveSinEncriptar);
//                System.out.println("Clave encriptada: " + claveEncriptada);
            }
        }
    }

    // 19-10-2020 Método de validación de credenciales de usuario
    private boolean validacion(String rutString, String digv, String clave) {

        if (Validar.campoVacio(rutString) == false) {
            mostrarMensaje("Error: \nEl rut está vacío! \nVerifique");
            return false;
        }

        if (Validar.numeroEntero(rutString) == false) {
            mostrarMensaje("Error: \nEl rut debe ser numérico! \nVerifique");
            return false;
        }

        if (digv.equals("Seleccione")) {
            mostrarMensaje("Error: \nSeleccione el dígito verificador del rut!");
            return false;
        }

        if (Validar.campoVacio(clave) == false) {
            mostrarMensaje("Error: \nLa clave está vacía! \nVerifique");
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
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRutLogin = new javax.swing.JTextField();
        pwdClaveLogin = new javax.swing.JPasswordField();
        btnIngresarLogin = new javax.swing.JButton();
        btnSalirLogin = new javax.swing.JButton();
        cmbDigvLogin = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(55, 68, 140));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/login/sombraLogin.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admintask");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(288, 51, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons64px/login.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 126, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/logo30px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 58, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 250));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("RUT:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Clave:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, -1, -1));

        txtRutLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(txtRutLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 251, -1));

        pwdClaveLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(pwdClaveLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 251, -1));

        btnIngresarLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIngresarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/ingresar32pc.png"))); // NOI18N
        btnIngresarLogin.setText("Ingresar");
        btnIngresarLogin.setIconTextGap(20);
        btnIngresarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 570, 150, 40));

        btnSalirLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSalirLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/cerrar32px.png"))); // NOI18N
        btnSalirLogin.setText("Salir");
        btnSalirLogin.setIconTextGap(50);
        btnSalirLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 150, 40));

        cmbDigvLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbDigvLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "k" }));
        jPanel1.add(cmbDigvLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 150, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("DV:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("-");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 19-10-2020 Llamada al método de validación de acceso
     */
    private void btnIngresarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarLoginActionPerformed
        validarAcceso();
    }//GEN-LAST:event_btnIngresarLoginActionPerformed

    private void btnSalirLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirLoginActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarLogin;
    private javax.swing.JButton btnSalirLogin;
    private javax.swing.JComboBox<String> cmbDigvLogin;
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
    private javax.swing.JPasswordField pwdClaveLogin;
    private javax.swing.JTextField txtRutLogin;
    // End of variables declaration//GEN-END:variables
}
