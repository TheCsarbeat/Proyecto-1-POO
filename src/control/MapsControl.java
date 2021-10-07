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
    private Document doc;
    private String docHTML;
    private final String url = (System.getProperty("user.dir") + "/src/files/mapIndex.html");

    public static BrowserView view;

    public MapsControl() {
        this.engine = Engine.newInstance(
                EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                        .licenseKey("6P830J66YBB5YIKY4BEI2C1DWIRKHBVDGHAX9BY3HQJPBDVDV28V75PV7SW24L2HJG77")
                        .build());
        this.browser = this.engine.newBrowser();
        this.view = BrowserView.newInstance(browser);
    }

    public void leer() throws IOException {
        File input = new File(url);
        this.doc = Jsoup.parse(input, "UTF-8");
    }

    public void modificar(double latitud, double longitud) {
        Element script = doc.getElementById("code");
        script.html("\n        var latitud = " + latitud + ";\n"
                + "        var longitud = " + longitud + ";\n"
                + "        var map = L.map('map').setView([latitud,longitud], 10);\n"
                + "\n"
                + "        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {\n"
                + "            attribution: '&copy; <a href=\"https://www.openstreetmap.org/copyright\">OpenStreetMap</a> contributors'\n"
                + "        }).addTo(map);\n"
                + "\n"
                + "        L.marker([latitud,longitud]).addTo(map)\n"
                + "            .bindPopup('Epicentro<br>'+latitud+', '+longitud)\n"
                + "            .openPopup();");
        this.docHTML = doc.html();

    }

    /**
     * cualquier object
     */
    public void escribir() {
        File fnew = new File(url);
        FileWriter f2;

        try {
            f2 = new FileWriter(fnew, false);
            f2.write(docHTML);
            f2.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void open() {
        browser.navigation().loadUrl(url);
    }
}
