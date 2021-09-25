/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import modelo.Sismo;
import java.util.Calendar;
import java.time.LocalTime;
import java.util.ArrayList;
import modelo.TOrigen;
import modelo.Asociado;
import modelo.NProvincia;
/**
 *
 * @author ytces
 */
public class Controlador {
    
    private AdmiSismos admS = new AdmiSismos();
    private AdmiAsociados admA = new AdmiAsociados();
    
    public boolean agregarSismo(int id, Calendar fecha, LocalTime hora, double profundidad, TOrigen origen){
        // cualquier otro paso antes de completar la inclusion
        Sismo nuevoSismo = new Sismo(id, fecha, hora, profundidad, origen);
        return admS.agregar(nuevoSismo);
    }
    
    public Sismo consultarSismo(int id){
        return admS.consultar(id);
    }
    
    public String mostrarSismos(){
        return admS.toString();
    }
    
    public boolean agregarAsociado(int id, String name, String correo, String celular, ArrayList<NProvincia> provincias){
        // cualquier otro paso antes de completar la inclusion
        Asociado nuevoAsociado = new Asociado(id, name, correo, celular, provincias);
        return admA.agregar(nuevoAsociado);
    }
    
    public Asociado consultarAsociado(int id){
        return admA.consultar(id);
    }
    
    public String mostrarAsociados(){
        return admA.toString();
    }
}
