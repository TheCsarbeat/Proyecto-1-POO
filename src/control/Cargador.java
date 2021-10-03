/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import modelo.NProvincia;
import modelo.Sismo;
import modelo.TOrigen;
/**
 *
 * @author erksm
 */
public class Cargador {
    
    public static DefaultTableModel cargarSismos(ArrayList<Sismo> array){
        Object [] encabezado = {"Id", "Fecha", "Hora", "Profundidad KM", "Magnitud", "Localizacion", "Origen de Falla", "Latitud", "Longitud", "Provincia", "Lugar"};
        DefaultTableModel dtm = new DefaultTableModel(encabezado, array.size());
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
            Sismo sismo = array.get(i);
            dtm.setValueAt(sismo.getId(), i, 0);
            dtm.setValueAt(Utilities.convertirFechaToString(sismo.getFecha()), i, 1);
            dtm.setValueAt(Utilities.convertirHoraToString(sismo.getHora()), i, 2);
            dtm.setValueAt(String.format("%.3f", sismo.getProfundidad()), i, 3);
            dtm.setValueAt(Utilities.magnitudToString(sismo.getMagnitud()), i, 4);
            dtm.setValueAt(sismo.getLocalizacion(), i, 5);
            dtm.setValueAt(Utilities.convertirOrigenFallaToString(sismo.getOrigen()), i, 6);
            dtm.setValueAt(String.format("%.3f", sismo.getLatitud()), i, 7);
            dtm.setValueAt(String.format("%.3f", sismo.getLongitud()), i, 8);
            dtm.setValueAt(Utilities.convertirProvinciaToString(sismo.getProvincia()), i, 9);
            dtm.setValueAt(Utilities.convertLugarToString(sismo.isTerrestre()), i, 10);
        }
        return dtm;
   }
}
