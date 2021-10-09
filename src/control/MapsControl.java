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

import java.io.*;
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
    /**
     * lee el archivo HTML y guarda una copia editable
     * @throws IOException en caso de que al convertir el documento este no puede ser convertido
     */
    public void leer() throws IOException {
        File input = new File(url);
        this.doc = Jsoup.parse(input, "UTF-8");
    }
    /**
     * se encarga de modificar la copia editable del archivo HTML basado en las coordenadas ingresadas
     * @param latitud la latidud de la localizacion
     * @param longitud la longitud de la localizacion 
     */
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
     * se encarga de sobrescribir el archivo HTML con la copia ya editada
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
    /**
     * se encarga de abrir el HTML atraves del browser
     */
    public void open() {
        browser.navigation().loadUrl(url);
    }
}
