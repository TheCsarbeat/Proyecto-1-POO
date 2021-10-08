/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JPanel;
import modelo.NProvincia;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ytces
 */
public class PanelPorMesAnnio extends javax.swing.JPanel {

    private int annio;
    /**
     * Creates new form PanelPorMesAnnio
     */
    public PanelPorMesAnnio() {
        initComponents();
        JFreeChart barChart = ChartFactory.createBarChart(
         "Gráfico de barras",           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
        ChartPanel chartPanel = new ChartPanel( barChart );
        cargarPanelCharts(chartPanel);
    }
    private void cargarPanelCharts(JPanel panel) {
        contentPanelCharts.removeAll();
        contentPanelCharts.add(panel);
        contentPanelCharts.repaint();
        contentPanelCharts.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMenuCharts = new javax.swing.JLabel();
        contentPanelCharts = new javax.swing.JPanel();
        jYearChooser = new com.toedter.calendar.JYearChooser();
        lbFechaSismo = new javax.swing.JLabel();
        panelConsultarSismosAnnio = new javax.swing.JPanel();
        btnConsultar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMenuCharts.setFont(new java.awt.Font("Roboto Condensed", 0, 36)); // NOI18N
        lbMenuCharts.setForeground(new java.awt.Color(0, 0, 0));
        lbMenuCharts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuCharts.setText("Cantidad de sismos por mes en un año");
        lbMenuCharts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMenuChartsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbMenuChartsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbMenuChartsMouseExited(evt);
            }
        });
        add(lbMenuCharts, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        contentPanelCharts.setLayout(new java.awt.CardLayout());
        add(contentPanelCharts, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 1070, 590));

        jYearChooser.setBackground(new java.awt.Color(255, 255, 255));
        jYearChooser.setForeground(new java.awt.Color(255, 255, 255));
        add(jYearChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 100, 40));

        lbFechaSismo.setBackground(new java.awt.Color(0, 0, 0));
        lbFechaSismo.setFont(new java.awt.Font("Roboto Slab Light", 1, 14)); // NOI18N
        lbFechaSismo.setForeground(new java.awt.Color(0, 0, 0));
        lbFechaSismo.setText("Año a consultar");
        lbFechaSismo.setToolTipText("");
        add(lbFechaSismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 130, 50));

        panelConsultarSismosAnnio.setBackground(new java.awt.Color(0, 150, 136));
        panelConsultarSismosAnnio.setPreferredSize(new java.awt.Dimension(250, 50));

        btnConsultar.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plus.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelConsultarSismosAnnioLayout = new javax.swing.GroupLayout(panelConsultarSismosAnnio);
        panelConsultarSismosAnnio.setLayout(panelConsultarSismosAnnioLayout);
        panelConsultarSismosAnnioLayout.setHorizontalGroup(
            panelConsultarSismosAnnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        panelConsultarSismosAnnioLayout.setVerticalGroup(
            panelConsultarSismosAnnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConsultarSismosAnnioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(panelConsultarSismosAnnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 110, 230, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void lbMenuChartsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuChartsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMenuChartsMouseClicked

    private void lbMenuChartsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuChartsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMenuChartsMouseEntered

    private void lbMenuChartsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMenuChartsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbMenuChartsMouseExited

    private void btnConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnConsultarMouseClicked

    private void btnConsultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarMouseEntered

    private void btnConsultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarMouseExited

    private CategoryDataset createDataset( ) {
      final String enero = "Enero";        
      final String febrero = "Febrero";        
      final String marzo = "Marzo";        
      final String abril = "Abril";        
      final String mayo = "Mayo";        
      final String junio = "Junio";        
      final String julio = "Julio";
      final String provincias = "Agosto";
      final String setiembre = "Setiembre";
      final String octubre = "Octubre";
      final String noviembre = "Noviembre";
      final String diciembre = "Diciembre";
      
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.SAN_JOSE),sanjose, provincias);
      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.CARTAGO) , cartago , provincias );
      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.HEREDIA) , heredia , provincias );
      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.ALAJUELA) , alajuela , provincias );
      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.PUNTARENAS) , puntarenas , provincias );
      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.GUANACASTE) , guanacaste , provincias );
      dataset.addValue( VentanaPrincipal.controlador.consultarSismosProvincia(NProvincia.LIMON) , limon , provincias );
      
      return dataset; 
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnConsultar;
    private javax.swing.JPanel contentPanelCharts;
    private com.toedter.calendar.JYearChooser jYearChooser;
    private javax.swing.JLabel lbFechaSismo;
    private javax.swing.JLabel lbMenuCharts;
    private javax.swing.JPanel panelConsultarSismosAnnio;
    // End of variables declaration//GEN-END:variables
}
