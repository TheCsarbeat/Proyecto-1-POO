/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import modelo.Sismo;
import java.util.Calendar;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.TOrigen;
import modelo.Asociado;
import modelo.NProvincia;
/**
 *
 * @author ytces
 */
public class Controlador {
    
    private AdmiSismos adminS = new AdmiSismos();
    private AdmiAsociados adminA = new AdmiAsociados();

    
    public boolean agregarSismo(Calendar fecha, Calendar hora, double profundidad,
            double latitud, double longitud, double magnitud, boolean terrestre, TOrigen origen, NProvincia provincia){
        // cualquier otro paso antes de completar la inclusion
        // public Sismo(int id, Calendar fecha, Calendar hora, double profundidad, double latitud, double longitud, double magnitud, boolean terrestre, TOrigen origen, NProvincia provincia) {
        Sismo nuevoSismo = new Sismo(adminS.getContadorSismos(), fecha, hora,
                profundidad, latitud, longitud, magnitud, terrestre, origen, provincia);
        return adminS.agregar(nuevoSismo);
    }
    
    public Sismo consultarSismo(int id){
        return adminS.consultar(id);
    }
    
    public String mostrarSismos(){
        return adminS.toString();
    }
    
    public boolean agregarAsociado(int id, String name, String correo, String celular, ArrayList<NProvincia> provincias){
        // cualquier otro paso antes de completar la inclusion
        Asociado nuevoAsociado = new Asociado(id, name, correo, celular, provincias);
        return adminA.agregar(nuevoAsociado);
    }
    
    public Asociado consultarAsociado(int id){
        return adminA.consultar(id);
    }
    
    public String mostrarAsociados(){
        return adminA.toString();
    }
    
    public DefaultTableModel cargarSismos(){
         return Cargador.cargarSismos(adminS.getAllSismos());
    }
    
    public NProvincia obtenerProvincia(int num){
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
    
    public TOrigen obtenerOrigen(int num){
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
}
