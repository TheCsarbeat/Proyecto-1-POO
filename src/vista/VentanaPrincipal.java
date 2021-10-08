/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.Controlador;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ytces
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public static Controlador controlador = new Controlador();
    public static Color overedColor = new Color(50, 200, 186);
    public static Color normalColor = new Color(0, 150, 136);
    public static Color blanco = new Color(255,255,255);


    public VentanaPrincipal() {        
        initComponents();
        controlador.obtenerDatosArchivoExel();
        controlador.obtenerAsociados();
    }

    public void cargarPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.repaint();
        contentPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zonaSismo = new javax.swing.ButtonGroup();
        backgroundPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        sismosMenuPanel = new javax.swing.JPanel();
        lbMenuSismos = new javax.swing.JLabel();
        btnConsultasPanel = new javax.swing.JPanel();
        btnConsultas = new javax.swing.JLabel();
        panelConsulta = new javax.swing.JPanel();
        btnTipoOrigen = new javax.swing.JLabel();
        btnProvincias = new javax.swing.JLabel();
        btnMagnitud = new javax.swing.JLabel();
        btnRangoFechas = new javax.swing.JLabel();
        btnMesPorYear = new javax.swing.JLabel();
        topPanel = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setForeground(new java.awt.Color(255, 255, 255));
        backgroundPanel.setMaximumSize(new java.awt.Dimension(500, 580));
        backgroundPanel.setMinimumSize(new java.awt.Dimension(500, 580));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(600, 500));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setBackground(new java.awt.Color(120, 120, 120));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sismosMenuPanel.setBackground(new java.awt.Color(0, 150, 136));
        sismosMenuPanel.setPreferredSize(new java.awt.Dimension(250, 50));

        lbMenuSismos.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        lbMenuSismos.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuSismos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuSismos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard.png"))); // NOI18N
        lbMenuSismos.setText("SISMOS");
        lbMenuSismos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbMenuSismos.setIconTextGap(35);
        lbMenuSismos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuSismosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMenuSismosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMenuSismosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout sismosMenuPanelLayout = new javax.swing.GroupLayout(sismosMenuPanel);
        sismosMenuPanel.setLayout(sismosMenuPanelLayout);
        sismosMenuPanelLayout.setHorizontalGroup(
            sismosMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMenuSismos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sismosMenuPanelLayout.setVerticalGroup(
            sismosMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sismosMenuPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbMenuSismos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuPanel.add(sismosMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        btnConsultasPanel.setBackground(new java.awt.Color(0, 150, 136));
        btnConsultasPanel.setPreferredSize(new java.awt.Dimension(250, 50));

        btnConsultas.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnConsultas.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-derecha.png"))); // NOI18N
        btnConsultas.setText("Consultas");
        btnConsultas.setToolTipText("");
        btnConsultas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnConsultas.setIconTextGap(50);
        btnConsultas.setInheritsPopupMenu(false);
        btnConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnConsultasPanelLayout = new javax.swing.GroupLayout(btnConsultasPanel);
        btnConsultasPanel.setLayout(btnConsultasPanelLayout);
        btnConsultasPanelLayout.setHorizontalGroup(
            btnConsultasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        btnConsultasPanelLayout.setVerticalGroup(
            btnConsultasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnConsultasPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuPanel.add(btnConsultasPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        panelConsulta.setBackground(new java.awt.Color(120, 120, 120));
        panelConsulta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTipoOrigen.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnTipoOrigen.setForeground(new java.awt.Color(255, 255, 255));
        btnTipoOrigen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTipoOrigen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafico-de-pastel.png"))); // NOI18N
        btnTipoOrigen.setText("Tipo Origen");
        btnTipoOrigen.setToolTipText("");
        btnTipoOrigen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTipoOrigen.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTipoOrigen.setIconTextGap(35);
        btnTipoOrigen.setInheritsPopupMenu(false);
        btnTipoOrigen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTipoOrigenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTipoOrigenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTipoOrigenMouseExited(evt);
            }
        });
        panelConsulta.add(btnTipoOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 70, 230, 50));

        btnProvincias.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnProvincias.setForeground(new java.awt.Color(255, 255, 255));
        btnProvincias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProvincias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/histograma.png"))); // NOI18N
        btnProvincias.setText("Provincias");
        btnProvincias.setToolTipText("");
        btnProvincias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProvincias.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProvincias.setIconTextGap(35);
        btnProvincias.setInheritsPopupMenu(false);
        btnProvincias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProvinciasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProvinciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProvinciasMouseExited(evt);
            }
        });
        panelConsulta.add(btnProvincias, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 10, 240, 50));

        btnMagnitud.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnMagnitud.setForeground(new java.awt.Color(255, 255, 255));
        btnMagnitud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMagnitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tabular.png"))); // NOI18N
        btnMagnitud.setText("Magnitud");
        btnMagnitud.setToolTipText("");
        btnMagnitud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMagnitud.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMagnitud.setIconTextGap(35);
        btnMagnitud.setInheritsPopupMenu(false);
        btnMagnitud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMagnitudMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMagnitudMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMagnitudMouseExited(evt);
            }
        });
        panelConsulta.add(btnMagnitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 250, 220, 50));

        btnRangoFechas.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnRangoFechas.setForeground(new java.awt.Color(255, 255, 255));
        btnRangoFechas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRangoFechas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tabular.png"))); // NOI18N
        btnRangoFechas.setText("Rango Fechas");
        btnRangoFechas.setToolTipText("");
        btnRangoFechas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRangoFechas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRangoFechas.setIconTextGap(35);
        btnRangoFechas.setInheritsPopupMenu(false);
        btnRangoFechas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRangoFechasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRangoFechasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRangoFechasMouseExited(evt);
            }
        });
        panelConsulta.add(btnRangoFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 130, 210, 50));

        btnMesPorYear.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnMesPorYear.setForeground(new java.awt.Color(255, 255, 255));
        btnMesPorYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMesPorYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/grafico-de-barras.png"))); // NOI18N
        btnMesPorYear.setText("Mes por año");
        btnMesPorYear.setToolTipText("");
        btnMesPorYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMesPorYear.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMesPorYear.setIconTextGap(35);
        btnMesPorYear.setInheritsPopupMenu(false);
        btnMesPorYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMesPorYearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMesPorYearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMesPorYearMouseExited(evt);
            }
        });
        panelConsulta.add(btnMesPorYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 190, 190, 50));

        menuPanel.add(panelConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 200, 320));

        backgroundPanel.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 850));

        topPanel.setBackground(new java.awt.Color(0, 150, 136));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        backgroundPanel.add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new java.awt.CardLayout());
        backgroundPanel.add(contentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 1300, 850));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1602, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lbMenuSismosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuSismosMouseClicked
        // TODO add your handling code here:
        PanelSismos panel = new PanelSismos();
        cargarPanel(panel);
        
    }//GEN-LAST:event_lbMenuSismosMouseClicked

    private void lbMenuSismosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuSismosMouseEntered
        // TODO add your handling code here:
        sismosMenuPanel.setBackground(overedColor);
    }//GEN-LAST:event_lbMenuSismosMouseEntered

    private void lbMenuSismosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuSismosMouseExited
        // TODO add your handling code here:
        sismosMenuPanel.setBackground(normalColor);
    }//GEN-LAST:event_lbMenuSismosMouseExited

    private void btnTipoOrigenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoOrigenMouseClicked
        // TODO add your handling code here:
        PanelPorOrigen panel = new PanelPorOrigen();
        cargarPanel(panel);
    }//GEN-LAST:event_btnTipoOrigenMouseClicked

    private void btnTipoOrigenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoOrigenMouseEntered
        // TODO add your handling code here:
        btnTipoOrigen.setForeground(overedColor);
    }//GEN-LAST:event_btnTipoOrigenMouseEntered

    private void btnTipoOrigenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTipoOrigenMouseExited
        // TODO add your handling code here:
        btnTipoOrigen.setForeground(blanco);
    }//GEN-LAST:event_btnTipoOrigenMouseExited

    private void btnConsultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseClicked

        int altura = panelConsulta.getHeight();
        int ancho = 200;
        if (altura == 0 ) {
            
            ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/images/flecha-abajo.png");
            btnConsultas.setIcon(imageIcon);
            Thread th = new Thread() {
                @Override
                public void run(){
                    try {                        
                        for ( int i = 0; i <=320; i++){
                            Thread.sleep(1);
                            panelConsulta.setSize(ancho, i);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
        }else if( altura == 320 ){
            ImageIcon imageIcon = new ImageIcon(System.getProperty("user.dir") + "/src/images/flecha-derecha.png");
            btnConsultas.setIcon(imageIcon);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try {
                        for (int i = 320; i >= 0; i--){
                            Thread.sleep(1);
                            panelConsulta.setSize(ancho, i);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
        }
    }//GEN-LAST:event_btnConsultasMouseClicked

    private void btnConsultasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseEntered
        // TODO add your handling code here:
        btnConsultasPanel.setBackground(overedColor);
    }//GEN-LAST:event_btnConsultasMouseEntered

    private void btnConsultasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultasMouseExited
        // TODO add your handling code here:
        btnConsultasPanel.setBackground(normalColor);
    }//GEN-LAST:event_btnConsultasMouseExited

    private void btnProvinciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvinciasMouseClicked
        // TODO add your handling code here:
        PanelPorProvincia panel = new PanelPorProvincia();
        cargarPanel(panel);
    }//GEN-LAST:event_btnProvinciasMouseClicked

    private void btnProvinciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvinciasMouseEntered
        // TODO add your handling code here:
        btnProvincias.setForeground(overedColor);
    }//GEN-LAST:event_btnProvinciasMouseEntered

    private void btnProvinciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProvinciasMouseExited
        // TODO add your handling code here:
         btnProvincias.setForeground(blanco);
    }//GEN-LAST:event_btnProvinciasMouseExited

    private void btnMagnitudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMagnitudMouseClicked
        // TODO add your handling code here:
        PanelMagnitud panel = new PanelMagnitud();
        cargarPanel(panel);

    }//GEN-LAST:event_btnMagnitudMouseClicked

    private void btnMagnitudMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMagnitudMouseEntered
        // TODO add your handling code here:
        btnMagnitud.setForeground(overedColor);
        
    }//GEN-LAST:event_btnMagnitudMouseEntered

    private void btnMagnitudMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMagnitudMouseExited
        // TODO add your handling code here:
        btnMagnitud.setForeground(blanco);
    }//GEN-LAST:event_btnMagnitudMouseExited

    private void btnRangoFechasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRangoFechasMouseClicked
        // TODO add your handling code here:
        PanelRangoFechas panel = new PanelRangoFechas();
        cargarPanel(panel);
    }//GEN-LAST:event_btnRangoFechasMouseClicked

    private void btnRangoFechasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRangoFechasMouseEntered
        // TODO add your handling code here:
        btnRangoFechas.setForeground(overedColor);
    }//GEN-LAST:event_btnRangoFechasMouseEntered

    private void btnRangoFechasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRangoFechasMouseExited
        // TODO add your handling code here:
        btnRangoFechas.setForeground(blanco);
    }//GEN-LAST:event_btnRangoFechasMouseExited

    private void btnMesPorYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesPorYearMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnMesPorYearMouseClicked

    private void btnMesPorYearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesPorYearMouseEntered
        // TODO add your handling code here:
        btnMesPorYear.setForeground(overedColor);
    }//GEN-LAST:event_btnMesPorYearMouseEntered

    private void btnMesPorYearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMesPorYearMouseExited
        // TODO add your handling code here:
        btnMesPorYear.setForeground(blanco);
    }//GEN-LAST:event_btnMesPorYearMouseExited

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel btnConsultas;
    private javax.swing.JPanel btnConsultasPanel;
    private javax.swing.JLabel btnMagnitud;
    private javax.swing.JLabel btnMesPorYear;
    private javax.swing.JLabel btnProvincias;
    private javax.swing.JLabel btnRangoFechas;
    private javax.swing.JLabel btnTipoOrigen;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel lbMenuSismos;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel panelConsulta;
    private javax.swing.JPanel sismosMenuPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.ButtonGroup zonaSismo;
    // End of variables declaration//GEN-END:variables

}
