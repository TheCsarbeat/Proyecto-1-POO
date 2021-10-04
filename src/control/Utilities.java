/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modelo.NProvincia;
import modelo.TOrigen;

/**
 *
 * @author erksm
 */
public class Utilities {
    
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
                return "";
        }

    }
        
    public static String convertirOrigenFallaToString(TOrigen origenFalla){ 
        if(origenFalla == null){
            return "";
        }
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
        return "";      
    }
    
    public static NProvincia obtenerProvincia(int num){
        switch(num){
            case 0:
                return NProvincia.SAN_JOSE;
            case 1:
                return NProvincia.ALAJUELA;
            case 2:
                return NProvincia.CARTAGO;
            case 3:
                return NProvincia.HEREDIA;
            case 4:
                return NProvincia.GUANACASTE;
            case 5:
                return NProvincia.PUNTARENAS;
            case 6:
                return NProvincia.LIMON;
        }
        return null;
    }
    
    public static int obtenerProvincia(NProvincia provincia){
        if(provincia == null){
            return -1;
        }
        switch(provincia){
            case SAN_JOSE:
                return 0;
            case ALAJUELA:
                return 1;
            case CARTAGO:
                return 2;
            case HEREDIA:
                return 3;
            case GUANACASTE:
                return 4;
            case PUNTARENAS:
                return 5;
            case LIMON:
                return 6;
        }
        return -1;
    }
    
    public static NProvincia convertStringToNProvincia(char provincia){
        switch(provincia){
            case 'S':
                return NProvincia.SAN_JOSE;
            case 'A':
                return NProvincia.ALAJUELA;
            case 'C':
                return NProvincia.CARTAGO;
            case 'H':
                return NProvincia.HEREDIA;
            case 'G':
                return NProvincia.GUANACASTE;
            case 'P':
                return NProvincia.PUNTARENAS;
            case 'L':
                return NProvincia.LIMON;
            case ' ':
                System.out.println("");
         
            default:
                System.out.println("Entro");
                return null;
        }
        
    }
    
    public static TOrigen obtenerOrigen(int num){
        switch(num){
            case 0:
                return TOrigen.SUBDUCCION;
            case 1:
                return TOrigen.CHOQUE_DE_PLACAS;
            case 2:
                return TOrigen.TECTONICO_POR_FALLA;
            case 3:
                return TOrigen.INTRA_PLACA;
            case 4:
                return TOrigen.DEFORMACION_INTERNA;
        }
        return null;
    }
    
    public static int obtenerOrigen(TOrigen tipo){
        switch(tipo){
            case SUBDUCCION:
                return 0;
            case CHOQUE_DE_PLACAS:
                return 1;
            case TECTONICO_POR_FALLA:
                return 2;
            case INTRA_PLACA:
                return 3;
            case DEFORMACION_INTERNA:
                return 4;
        }
        return -1;
    }
    
    public static TOrigen convertOrigenToTOrigen(char origen){
        switch(origen){
            case 'S':
                return TOrigen.SUBDUCCION;
            case 'C':
                return TOrigen.CHOQUE_DE_PLACAS;
            case 'T':
                return TOrigen.TECTONICO_POR_FALLA;
            case 'I':
                return TOrigen.INTRA_PLACA;
            case 'D':
                return TOrigen.DEFORMACION_INTERNA;
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
    
    public static String convertLugarToString(boolean terrestre){
        if (terrestre){
            return "Terrestre";
        }
        return "Marítimo";
    }
    
    public static boolean convertStringTolugar(char terrestre){
        if (terrestre == 'T'){
            return true;
        }
         return false;
    }
    
    public static boolean isNull(Calendar date){
        if(date == null){
            return true;
        }
        return false;
    }

    
}
