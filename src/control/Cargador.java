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
        Object [] encabezado = {"Id", "Fecha", "Hora", "Profundidad KM", "Provincia", "Origen de Falla", "Latitud", "Longitud", "Magnitud"};
        DefaultTableModel dtm = new DefaultTableModel(encabezado, array.size());
        
        for (int i = 0; i < dtm.getRowCount(); i++) {
            Sismo sismo = array.get(i);
            dtm.setValueAt(sismo.getId(), i, 0);
            dtm.setValueAt(convertirFechaToString(sismo.getFecha()), i, 1);
            dtm.setValueAt(convertirHoraToString(sismo.getHora()), i, 2);
            dtm.setValueAt(sismo.getProfundidad()+" KM", i, 3);
            dtm.setValueAt(convertirProvinciaToString(sismo.getProvincia()), i, 4);
            dtm.setValueAt(convertirOrigenFallaToString(sismo.getOrigen()), i, 5);
            dtm.setValueAt(sismo.getLatitud(), i, 6);
            dtm.setValueAt(sismo.getLongitud(), i, 7);
            dtm.setValueAt(magnitudToString(sismo.getMagnitud()), i, 8);

        }
        return dtm;
   }
    
    public static String convertirHoraToString(Calendar hora){ 
        Date date = hora.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        return format1.format(date);
//return String.valueOf(hora.get(Calendar.HOUR_OF_DAY))+":"+String.valueOf(hora.get(Calendar.MINUTE))+":"+String.valueOf(hora.get(Calendar.SECOND));
    }
    
    public static String convertirFechaToString(Calendar fecha){ 
        Date date = fecha.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("d MMM y");
        return format1.format(date);        
    }
    
    public static String convertirProvinciaToString(NProvincia provicia){
        if (provicia == null){
            return "";
        }
        switch (provicia) {
            case SAN_JOSE:
                return "San José";
            case ALAJUELA:
                return "Alajuela";
            case CARTAGO:
                return "Cartago";
            case HEREDIA:
                return "Heredia";
            case GUANACASTE:
                return "Guanacaste";
            case PUNTARENAS:
                return "Putarenas";
            case LIMON:
                return "Limón";
            default:
                return null;
        }

    }
        
    public static String convertirOrigenFallaToString(TOrigen origenFalla){ 
        switch (origenFalla) {
            case SUBDUCCION:
                return "Subducción";
            case CHOQUE_DE_PLACAS:
                return "Choque de placas";
            case TECTONICO_POR_FALLA:
                return "Tectónico por falla local";
            case INTRA_PLACA:
                return "Intra placa";
            case DEFORMACION_INTERNA:
                return "Deformación Interna";
            default:
                break;
        }
        return null;      
    }
    
    public static String magnitudToString(double magnitud){ 

        if(2.0 <= magnitud && magnitud <= 6.9){
            return magnitud + "Ml";
        }else if(magnitud>6.9){
           return magnitud + "Mw";
        }
        return magnitud + "M";
          
    }
    
    
    
    
    
}
