package view;

import bd.Conexion;
import bo.ClienteBO;
import dao.ClienteDAO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

// 12-11-2020
// @author Emilio
public class FrmReporte extends javax.swing.JFrame {

    private ClienteBO clienteBO = new ClienteBO();
    private ClienteDAO clienteDAO = new ClienteDAO();

    public FrmReporte() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Reportes - Sistema Admintask");
        setResizable(false);

        listarClientes();
        btnReporteGeneralTareasPorCliente.setEnabled(false);//deshabilita el boton

        //Integración de icono en la ventana de titulo de la ventana
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/icons/icons32px/logo30px.png"));
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(image);
    }

    public void listarClientes() {
        clienteBO.listarClienteCmb(cmbCliente);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panTitulo = new javax.swing.JPanel();
        lblTituloPanel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnReporteGeneralTareas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnReporteDetallelTareas = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnReporteTareasFinalizadas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnReporteTareasInconformes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnReporteTareasEjecutando = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnReporteTareasRechazadas = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnReporteTareasPendientes = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnReporteGeneralTareasGrafico = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        btnReporteGeneralTareasPorCliente = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnReporteSubTareasPorCliente = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnReporteTareasGeneralGraficoPorCliente = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnReporteSubTareasGraficoPorCliente = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        btnReporteProcesosPorCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panTitulo.setBackground(new java.awt.Color(55, 68, 140));

        lblTituloPanel.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        lblTituloPanel.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPanel.setText("Reportes Admintask");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/logo30px.png"))); // NOI18N

        javax.swing.GroupLayout panTituloLayout = new javax.swing.GroupLayout(panTitulo);
        panTitulo.setLayout(panTituloLayout);
        panTituloLayout.setHorizontalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTituloPanel)
                .addContainerGap(1082, Short.MAX_VALUE))
        );
        panTituloLayout.setVerticalGroup(
            panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTituloLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTituloPanel)
                    .addComponent(jLabel1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(600, 663));

        btnReporteGeneralTareas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteGeneralTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteGeneralTareas.setText("Crear Reporte");
        btnReporteGeneralTareas.setIconTextGap(20);
        btnReporteGeneralTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneralTareasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Reporte general de Tareas:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Reporte de Subtareas:");

        btnReporteDetallelTareas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteDetallelTareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteDetallelTareas.setText("Crear Reporte");
        btnReporteDetallelTareas.setIconTextGap(20);
        btnReporteDetallelTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteDetallelTareasActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Reporte de Tareas finalizadas:");

        btnReporteTareasFinalizadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteTareasFinalizadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteTareasFinalizadas.setText("Crear Reporte");
        btnReporteTareasFinalizadas.setIconTextGap(20);
        btnReporteTareasFinalizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTareasFinalizadasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Reporte de Tareas inconformes:");

        btnReporteTareasInconformes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteTareasInconformes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteTareasInconformes.setText("Crear Reporte");
        btnReporteTareasInconformes.setIconTextGap(20);
        btnReporteTareasInconformes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTareasInconformesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Reporte de Tareas en ejecución:");

        btnReporteTareasEjecutando.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteTareasEjecutando.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteTareasEjecutando.setText("Crear Reporte");
        btnReporteTareasEjecutando.setIconTextGap(20);
        btnReporteTareasEjecutando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTareasEjecutandoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Reporte de Tareas rechazadas:");

        btnReporteTareasRechazadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteTareasRechazadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteTareasRechazadas.setText("Crear Reporte");
        btnReporteTareasRechazadas.setIconTextGap(20);
        btnReporteTareasRechazadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTareasRechazadasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Reporte de Tareas Pendientes:");

        btnReporteTareasPendientes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteTareasPendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteTareasPendientes.setText("Crear Reporte");
        btnReporteTareasPendientes.setIconTextGap(20);
        btnReporteTareasPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTareasPendientesActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Reporte general de Tareas gráfico:");

        btnReporteGeneralTareasGrafico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteGeneralTareasGrafico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporteGrafico32px.png"))); // NOI18N
        btnReporteGeneralTareasGrafico.setText("Crear Reporte");
        btnReporteGeneralTareasGrafico.setIconTextGap(20);
        btnReporteGeneralTareasGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneralTareasGraficoActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(btnReporteGeneralTareas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteDetallelTareas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteTareasFinalizadas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteTareasInconformes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteTareasEjecutando, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteTareasRechazadas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteTareasPendientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnReporteGeneralTareasGrafico, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporteGeneralTareasGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteTareasPendientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnReporteGeneralTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteDetallelTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteTareasFinalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteTareasInconformes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteTareasEjecutando, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteTareasRechazadas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnReporteGeneralTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(btnReporteDetallelTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(btnReporteTareasFinalizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReporteTareasInconformes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(btnReporteTareasEjecutando, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnReporteTareasRechazadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(btnReporteTareasPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnReporteGeneralTareasGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reporte por Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jLayeredPane2.setPreferredSize(new java.awt.Dimension(600, 506));

        btnReporteGeneralTareasPorCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteGeneralTareasPorCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteGeneralTareasPorCliente.setText("Crear Reporte");
        btnReporteGeneralTareasPorCliente.setIconTextGap(20);
        btnReporteGeneralTareasPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGeneralTareasPorClienteActionPerformed(evt);
            }
        });

        cmbCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Reporte general de Tareas:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Seleccione al cliente:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Reporte de Subtareas:");

        btnReporteSubTareasPorCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteSubTareasPorCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteSubTareasPorCliente.setText("Crear Reporte");
        btnReporteSubTareasPorCliente.setIconTextGap(20);
        btnReporteSubTareasPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSubTareasPorClienteActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Reporte general de Tareas gráfico:");

        btnReporteTareasGeneralGraficoPorCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteTareasGeneralGraficoPorCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporteGrafico32px.png"))); // NOI18N
        btnReporteTareasGeneralGraficoPorCliente.setText("Crear Reporte");
        btnReporteTareasGeneralGraficoPorCliente.setIconTextGap(20);
        btnReporteTareasGeneralGraficoPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteTareasGeneralGraficoPorClienteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Reporte de Subtareas gráfico:");

        btnReporteSubTareasGraficoPorCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteSubTareasGraficoPorCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporteGrafico32px.png"))); // NOI18N
        btnReporteSubTareasGraficoPorCliente.setText("Crear Reporte");
        btnReporteSubTareasGraficoPorCliente.setIconTextGap(20);
        btnReporteSubTareasGraficoPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteSubTareasGraficoPorClienteActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Reporte de Procesos:");

        btnReporteProcesosPorCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReporteProcesosPorCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons32px/reporte32px.png"))); // NOI18N
        btnReporteProcesosPorCliente.setText("Crear Reporte");
        btnReporteProcesosPorCliente.setIconTextGap(20);
        btnReporteProcesosPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteProcesosPorClienteActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(btnReporteGeneralTareasPorCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cmbCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnReporteSubTareasPorCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnReporteTareasGeneralGraficoPorCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnReporteSubTareasGraficoPorCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(btnReporteProcesosPorCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporteProcesosPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnReporteTareasGeneralGraficoPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteSubTareasPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbCliente, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReporteGeneralTareasPorCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReporteSubTareasGraficoPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnReporteGeneralTareasPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnReporteSubTareasPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnReporteTareasGeneralGraficoPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(btnReporteSubTareasGraficoPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(btnReporteProcesosPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 12-11-2020
     *
     * @author Emilio
     * @throws Reporte de Boton reporte General de tareas
     */
    private void btnReporteGeneralTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneralTareasActionPerformed

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteTareasGeneral.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteGeneralTareasActionPerformed

    /**
     * 24-11-2020
     *
     * @author Emilio
     * @throws Reporte general de tareas filtrado por cliente
     */
    private void btnReporteGeneralTareasPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneralTareasPorClienteActionPerformed

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            String path = "src\\reportes\\ReporteTareasGeneralPorCliente.jasper";

            //Capturando variable de filtro
            Map parametro = new HashMap();
            String clienteCapturado = cmbCliente.getSelectedItem().toString();
            parametro.put("nombreCliente", clienteCapturado);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteGeneralTareasPorClienteActionPerformed

    /**
     * 24-11-2020
     *
     * @author Emilio
     * @throws Reporte del detalle de Tareas y subtareas
     */
    private void btnReporteDetallelTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteDetallelTareasActionPerformed

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteSubTareas.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteDetallelTareasActionPerformed

    /**
     * 24-11-2020
     *
     * @author Emilio
     * @throws Reporte de Tareas finalizadas
     */
    private void btnReporteTareasFinalizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTareasFinalizadasActionPerformed
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteTareasFinalizadas.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteTareasFinalizadasActionPerformed

    /**
     * 24-11-2020
     *
     * @author Emilio
     * @throwes Reporte de Tareas inconformes
     */
    private void btnReporteTareasInconformesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTareasInconformesActionPerformed
        //ReporteTareasInconformes
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteTareasInconformes.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteTareasInconformesActionPerformed

    /**
     * 24-11-2020
     *
     * @author Emilio
     * @throws Reporte de Tareas en ejecución
     */
    private void btnReporteTareasEjecutandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTareasEjecutandoActionPerformed
        // ReporteTareasEjecutando
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteTareasEjecutando.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteTareasEjecutandoActionPerformed

    /**
     * 24-11-2020
     *
     * @autor Emilio
     * @throws Reporte de tareas rechazadas
     */
    private void btnReporteTareasRechazadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTareasRechazadasActionPerformed
        // ReporteTareasRechazadas
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteTareasRechazadas.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteTareasRechazadasActionPerformed

    /**
     * 24-11-2020
     *
     * @autor Emilio
     * @throws Reporte de tareas pendientes
     */
    private void btnReporteTareasPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTareasPendientesActionPerformed
        //ReporteTareasPendientes
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            //String path = "src\\reportes\\report1.jasper";           
            String path = "src\\reportes\\ReporteTareasPendientes.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteTareasPendientesActionPerformed

    /**
     * 01-12-2020
     *
     * @author Emilio
     * @throws el combobox habilita los botones de los reportes, cuando es
     * seleccionado un cliente
     */
    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged

        //habilitar botones
        if (cmbCliente.getSelectedItem().equals("Seleccione")) {
            btnReporteGeneralTareasPorCliente.setEnabled(false);
            btnReporteSubTareasPorCliente.setEnabled(false);
            btnReporteTareasGeneralGraficoPorCliente.setEnabled(false);
            btnReporteSubTareasGraficoPorCliente.setEnabled(false);
            btnReporteProcesosPorCliente.setEnabled(false);
        } else {
            btnReporteGeneralTareasPorCliente.setEnabled(true);
            btnReporteSubTareasPorCliente.setEnabled(true);
            btnReporteTareasGeneralGraficoPorCliente.setEnabled(true);
            btnReporteSubTareasGraficoPorCliente.setEnabled(true);
            btnReporteProcesosPorCliente.setEnabled(true);
        }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    /**
     * 01-12-2020
     *
     * @author Emilio
     * @throws generar reporte de subtareas por cliente
     */
    private void btnReporteSubTareasPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSubTareasPorClienteActionPerformed
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;

            String path = "src\\reportes\\ReporteSubTareasPorCliente.jasper";

            //Capturando variable de filtro
            Map parametro = new HashMap();
            String clienteCapturado = cmbCliente.getSelectedItem().toString();
            parametro.put("nombreCliente", clienteCapturado);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteSubTareasPorClienteActionPerformed

    /**
     * 01-12-2020
     *
     * @author Emilio
     * @throws reporte general de tareas gráfico
     */
    private void btnReporteGeneralTareasGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGeneralTareasGraficoActionPerformed
        //btnReporteGeneralTareasGrafico
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;

            String path = "src\\reportes\\ReporteTareasGeneralGrafico.jasper";

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteGeneralTareasGraficoActionPerformed

    /**
     * 01-12-2020
     *
     * @author Emilio
     * @throws reporte general de tareas por cliente
     */
    private void btnReporteTareasGeneralGraficoPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteTareasGeneralGraficoPorClienteActionPerformed
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;

            String path = "src\\reportes\\ReporteTareasGeneralGraficoPorCliente.jasper";

            //Capturando variable de filtro
            Map parametro = new HashMap();
            String clienteCapturado = cmbCliente.getSelectedItem().toString();
            parametro.put("nombreCliente", clienteCapturado);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteTareasGeneralGraficoPorClienteActionPerformed

    /**
     * 02-12-2020
     *
     * @author Emilio
     * @throws boton que genera reporte gráfico de subtareas filtrado por
     * cliente
     */
    private void btnReporteSubTareasGraficoPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteSubTareasGraficoPorClienteActionPerformed

        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;

            String path = "src\\reportes\\ReporteSubTareasGraficoPorCliente.jasper";

            //Capturando variable de filtro
            Map parametro = new HashMap();
            String clienteCapturado = cmbCliente.getSelectedItem().toString();
            parametro.put("nombreCliente", clienteCapturado);

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnReporteSubTareasGraficoPorClienteActionPerformed

    /**
     * 02-12-2020
     *
     * @author Emilio
     * @throws el boton cerrar cierra la ventana actual y abre la ventana del
     * menu general del sistema
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new FrmPanelGeneral().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * 13-12-2020
     *
     * @author Emilio
     * @throws generar reporte por Procesos Por Cliente
     * @param Boton = btnReporteProcesosPorCliente
     */
    private void btnReporteProcesosPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteProcesosPorClienteActionPerformed
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();

            JasperReport reporte = null;
            String path = "src\\reportes\\ReporteProcesosPorCliente.jasper";

            //Capturando variable de filtro
            Map parametro = new HashMap();
            String clienteCapturado = cmbCliente.getSelectedItem().toString();
            parametro.put("nombreCliente", clienteCapturado);
            //parametro.put("REPORT_LOCALE", new Locale("es", "ES"));

            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn); // cargar datos 

            JasperViewer view = new JasperViewer(jprint, false); //crear vista del reporte

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //pemitir cerrar ventana al clickear en boton cerrar

            view.setVisible(true); // haver visible el reporte

            view.setExtendedState(MAXIMIZED_BOTH); //iniciar ventana de reporte maximisada

        } catch (JRException ex) {
            Logger.getLogger(FrmReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReporteProcesosPorClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
    public void frmReporte() {
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
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporteDetallelTareas;
    private javax.swing.JButton btnReporteGeneralTareas;
    private javax.swing.JButton btnReporteGeneralTareasGrafico;
    private javax.swing.JButton btnReporteGeneralTareasPorCliente;
    private javax.swing.JButton btnReporteProcesosPorCliente;
    private javax.swing.JButton btnReporteSubTareasGraficoPorCliente;
    private javax.swing.JButton btnReporteSubTareasPorCliente;
    private javax.swing.JButton btnReporteTareasEjecutando;
    private javax.swing.JButton btnReporteTareasFinalizadas;
    private javax.swing.JButton btnReporteTareasGeneralGraficoPorCliente;
    private javax.swing.JButton btnReporteTareasInconformes;
    private javax.swing.JButton btnReporteTareasPendientes;
    private javax.swing.JButton btnReporteTareasRechazadas;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTituloPanel;
    private javax.swing.JPanel panTitulo;
    // End of variables declaration//GEN-END:variables
}
