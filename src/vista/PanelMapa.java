/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static com.teamdev.jxbrowser.engine.RenderingMode.*;
     
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
     
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author erksm
 */
public class PanelMapa extends javax.swing.JPanel {

    /**
     * Creates new form panelMapa
     */
    Browser browser;
    BrowserView view;
    public PanelMapa() {
        initComponents();
                Engine engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YBB5YIKY4BEI2C1DWIRKHBVDGHAX9BY3HQJPBDVDV28V75PV7SW24L2HJG77")
                .build());
        
        Browser browser = engine.newBrowser();
     
        SwingUtilities.invokeLater(() -> {
        BrowserView view = BrowserView.newInstance(browser);
         
        JFrame frame = new JFrame("Swing BrowserView");
        frame.add(view, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setVisible(true);
         
        browser.navigation().loadUrl("https://es.pornhub.com/");
        });
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 196, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 135, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
