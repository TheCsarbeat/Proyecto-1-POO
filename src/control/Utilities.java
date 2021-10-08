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
import modelo.NProvincia;
import modelo.TOrigen;
import java.util.regex.*;  
/**
 *
 * @author erksm
 */
public class Utilities {
    
    /**
     * Convierte un objeto Calendar a String en formato de hora HH:mm:ss
     * @param time hora a convertir
     * @return  Strng formateada
     */
    public static String convertirHoraToString(Calendar time){ 
        Date Newdate = time.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        return format1.format(Newdate);
    }
    
    /**
     * Convierte un objeto Calendar a String en formato de fecha d MMM y
     * @param date fecha a convertir
     * @return String fecha formateada
     */
    public static String convertirFechaToString(Calendar date){         
        Date Newdate = date.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        return format1.format(Newdate);        
    }
    
    /**
     * convierte un Nprovincia a string
     * @param provicia provincia aconvertir 
     * @return String formateado
     */
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
    /**
     * obtiene el indice según la provincia
     * @param provincia  NPRovincia a buscar
     * @return entero indice de la provincia
     */
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
    /**
     * obtiene la provincia según el indice 
     * @param num indece a buscar
     * @return NProvincia
     */
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
    /**
     * Convierte un string a el NProvincia
     * @param provincia char que correxponde a la primer letra de la pronvicia
     * @return NProvincia correxpondiente
     */
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
    
    /**
     * obtiene un TOrigen según el indece
     * @param num entero que corresponde al inice
     * @return  TOrigen correspondiente
     */
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
    
    /**
     * Sobtiene un indice según TOrigen
     * @param tipo
     * @return indeice
     */
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
    
    /**
     * Convierte el primer caracte de un origen a TOrigen
     * @param origen primer caracter para cosiderar
     * @return  TOrigen valido
     */
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
    
    /**
     * Convierte un TOringen a string
     * @param origenFalla TOrigne a convertir
     * @return String formateado
     */
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
    
    
    
    
    /**
     * convierte la magnitud a string adjuntado la unidad de medida
     * @param magnitud double a convertir
     * @return String convertido
     */
    public static String magnitudToString(double magnitud){ 

        if(2.0 <= magnitud && magnitud <= 6.9){
            return magnitud + "Ml";
        }else if(magnitud>6.9){
           return magnitud + "Mw";
        }
        return magnitud + "M";
          
    }
    
    /**
     * lee el parametro para convertir el string correspondiente del lugar del sismo
     * @param terrestre valor a leer
     * @return String formateado
     */
    public static String convertLugarToString(boolean terrestre){
        if (terrestre){
            return "Terrestre";
        }
        return "Marítimo";
    }
    
    /**
     * Identifica el primerar caracter del lugar del sismo 
     * @param terrestre caracter a cosiderar
     * @return true/false según sea terrestre
     */
    public static boolean convertStringTolugar(char terrestre){
        if (terrestre == 'T'){
            return true;
        }
         return false;
    }
    
    public static boolean validarNumeroCelular(String numeroCelular){
        return Pattern.matches("\\d{4}-\\d{4}", numeroCelular) ;
    }
    
    public static boolean validarCorreo(String correo){
        return Pattern.matches("([\\w-\\.]+)@((?:\\w+\\.)+)([a-zA-Z]{2,4})", correo) ; //"[\\w.%+-]+{4}[-]([a-zA-Z]{2,4})"
    }
    
    public static boolean validarProvincias(ArrayList<NProvincia> provincias){
        int contador =0 ; 
        for(NProvincia i: provincias){
            if(i != null){
                return true;
            }
            contador ++;
        }
        return false;
    }
}
