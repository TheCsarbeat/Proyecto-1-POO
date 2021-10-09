/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Sismo;
import control.Utilities;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.table.TableModel;

/**
 *
 * @author erksm
 */
public class PanelMagnitud extends javax.swing.JPanel {

    /**
     * Creates new form panelSismos
     */

    //Varaibles declaration
    private double magnitudInicial = 0;
    private double magnitudFinal = 0;
    private int index = -1;
    public PanelMagnitud() {
        initComponents();
        ArrayList<Sismo> sismos = new ArrayList();
        cargarTabla(sismos);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioZonaSismo = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSismos = new javax.swing.JTable();
        btnAgregarPanel = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JLabel();
        lbFechaSismo1 = new javax.swing.JLabel();
        cboMagnitud = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSismos.setBackground(new java.awt.Color(255, 255, 255));
        tableSismos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSismos.setOpaque(false);
        tableSismos.setSelectionBackground(new java.awt.Color(50, 200, 186));
        tableSismos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSismos.setShowGrid(true);
        jScrollPane1.setViewportView(tableSismos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1270, 570));

        btnAgregarPanel.setBackground(new java.awt.Color(0, 150, 136));
        btnAgregarPanel.setPreferredSize(new java.awt.Dimension(250, 50));

        btnAgregar.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa-de-busqueda.png"))); // NOI18N
        btnAgregar.setText("Consultar");
        btnAgregar.setIconTextGap(20);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAgregarPanelLayout = new javax.swing.GroupLayout(btnAgregarPanel);
        btnAgregarPanel.setLayout(btnAgregarPanelLayout);
        btnAgregarPanelLayout.setHorizontalGroup(
            btnAgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        btnAgregarPanelLayout.setVerticalGroup(
            btnAgregarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAgregarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(btnAgregarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 230, -1));

        lbFechaSismo1.setBackground(new java.awt.Color(0, 0, 0));
        lbFechaSismo1.setFont(new java.awt.Font("Roboto Slab Light", 1, 14)); // NOI18N
        lbFechaSismo1.setForeground(new java.awt.Color(0, 0, 0));
        lbFechaSismo1.setText("Seleccione la magnitud");
        lbFechaSismo1.setToolTipText("");
        add(lbFechaSismo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 50));

        cboMagnitud.setBackground(new java.awt.Color(255, 255, 255));
        cboMagnitud.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cboMagnitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Micro", "Menor", "Ligero", "Moderado", "Fuerte", "Mayor", "Gran", "Épico" }));
        add(cboMagnitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 370, -1));
    }// </editor-fold>//GEN-END:initComponents

    
    //------------------Buttons-------------------
    //btnAgregar methods
    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {
        if (btnAgregarPanel.getBackground() != Color.gray) {
            btnAgregarPanel.setBackground(VentanaPrincipal.overedColor);
        }

    }
    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {
        if (btnAgregarPanel.getBackground() != Color.gray) {
            btnAgregarPanel.setBackground(VentanaPrincipal.normalColor);
        }
    }
    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {// Agregar
            //get the data of the fields
        obtenerDatos();
        //Validaci[on de los datos
        
        ArrayList<Sismo> sismos = VentanaPrincipal.controlador.consultarSismosMagnitud(index);
        if (sismos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado datos", "IMPORTANTE!", JOptionPane.INFORMATION_MESSAGE);
        }
        cargarTabla(sismos);
        
        
    }

    // btn Modificar Methods
    
    //======================================================
    //                    Funcional Methods
    //=======================================================

    
    // -----------------field methods----------
    
    // get data of the fields
    private void obtenerDatos(){
        index = cboMagnitud.getSelectedIndex();
    }
    
    
    // tabla
    public void cargarTabla(ArrayList<Sismo> sismos) {
       
        tableSismos.setModel(VentanaPrincipal.controlador.cargarSismos(sismos));
        tableSismos.setDefaultEditor(Object.class, null);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JPanel btnAgregarPanel;
    private javax.swing.JComboBox<String> cboMagnitud;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFechaSismo1;
    private javax.swing.ButtonGroup radioZonaSismo;
    private javax.swing.JTable tableSismos;
    // End of variables declaration//GEN-END:variables
}
