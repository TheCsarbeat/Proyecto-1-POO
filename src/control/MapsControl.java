/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import static com.teamdev.jxbrowser.engine.RenderingMode.*;
     
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import java.awt.BorderLayout;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
/**
 *
 * @author ytces
 */
public class MapsControl {
    private Engine engine;
    private Browser browser;
    private JFrame frame;
    private Document doc;
    String docHTML;
    
    public MapsControl(){
        this.engine = Engine.newInstance(
        EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("6P830J66YBB5YIKY4BEI2C1DWIRKHBVDGHAX9BY3HQJPBDVDV28V75PV7SW24L2HJG77")
                .build());
        this.browser = this.engine.newBrowser();
        SwingUtilities.invokeLater(() -> {
        BrowserView view = BrowserView.newInstance(browser);
         
        this.frame = new JFrame("Swing BrowserView");
        this.frame.add(view, BorderLayout.CENTER);
        this.frame.setSize(700, 500);
        this.frame.setVisible(true);
        });
    }
    
    public void crearDoc() throws IOException{
        File input = new File("src\\files\\mapIndex.html");
        this.doc = Jsoup.parse(input, "UTF-8");
    }
    
    public void generarHTML(double latitud, double longitud){
        Element script = doc.getElementById("code");
        script.html("\n        var latitud = "+latitud+";\n" +
"        var longitud = "+longitud+";\n" +
"        var map = L.map('map').setView([latitud,longitud], 15);\n" +
"\n" +
"        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {\n" +
"            attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n" +
"        }).addTo(map);\n" +
"\n" +
"        L.marker([latitud,longitud]).addTo(map)\n" +
"            .bindPopup('Epicentro<br>'+latitud+', '+longitud)\n" +
"            .openPopup();");
        this.docHTML = doc.html();
        
    }
    
    public void overwriteHTML(){
        File fnew=new File("src\\files\\mapIndex.html");
        FileWriter f2;

        try {
            f2 = new FileWriter(fnew,false);
            f2.write(docHTML);
            f2.close();
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }           
    }
    
    public void abrirBrowser(){
        browser.navigation().loadUrl("src\\files\\mapIndex.html");
    }
}
