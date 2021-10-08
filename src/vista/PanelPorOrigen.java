/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import javax.swing.JPanel;
import modelo.TOrigen;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author ytces
 */
public class PanelPorOrigen extends javax.swing.JPanel {

    /** Creates new form PanelPorOrigen */
    public PanelPorOrigen() {
        initComponents();
        JFreeChart chart = ChartFactory.createPieChart3D(  
         "Mobile Sales",   // chart title 
         createDataset(),          // data    
         true,             // include legend   
         true, 
         false);
        ChartPanel chartPanel = new ChartPanel(chart);
        cargarPanelCharts(chartPanel);
    }

    private void cargarPanelCharts(JPanel panel) {
        contentPanelCharts.removeAll();
        contentPanelCharts.add(panel);
        contentPanelCharts.repaint();
        contentPanelCharts.revalidate();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMenuCharts = new javax.swing.JLabel();
        contentPanelCharts = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMenuCharts.setFont(new java.awt.Font("Roboto Condensed", 0, 36)); // NOI18N
        lbMenuCharts.setForeground(new java.awt.Color(0, 0, 0));
        lbMenuCharts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMenuCharts.setText("Cantidad de sismos por origen");
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
        add(lbMenuCharts, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        contentPanelCharts.setLayout(new java.awt.CardLayout());
        add(contentPanelCharts, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 1070, 590));
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

    private static PieDataset createDataset( ) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Subducción" , VentanaPrincipal.controlador.consultarSismosOrigen(TOrigen.SUBDUCCION) );  
      dataset.setValue( "Choque de placas" , VentanaPrincipal.controlador.consultarSismosOrigen(TOrigen.CHOQUE_DE_PLACAS) );   
      dataset.setValue( "Tectónico por falla local" , VentanaPrincipal.controlador.consultarSismosOrigen(TOrigen.TECTONICO_POR_FALLA) );    
      dataset.setValue( "Intra placa" , VentanaPrincipal.controlador.consultarSismosOrigen(TOrigen.INTRA_PLACA) );
      dataset.setValue( "Deformación Interna" , VentanaPrincipal.controlador.consultarSismosOrigen(TOrigen.DEFORMACION_INTERNA) );
      return dataset;
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanelCharts;
    private javax.swing.JLabel lbMenuCharts;
    // End of variables declaration//GEN-END:variables

}
