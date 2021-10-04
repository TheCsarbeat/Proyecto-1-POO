/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.io.IOException;
import modelo.Sismo;
import java.util.Calendar;

import java.util.ArrayList;
import javax.swing.JTable;
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
    private ExcelControl execelControl = new ExcelControl();
    private MapsControl mapControl;
    
    public boolean agregarSismo(Calendar fecha, Calendar hora, double profundidad,
            double latitud, double longitud, double magnitud, String localizacion, boolean terrestre, TOrigen  origen, NProvincia provincia){
        // cualquier otro paso antes de completar la inclusion
        // public Sismo(int id, Calendar fecha, Calendar hora, double profundidad, double latitud, double longitud, double magnitud, boolean terrestre, TOrigen origen, NProvincia provincia) {
        Sismo nuevoSismo = new Sismo(adminS.getContadorSismos(), fecha, hora,
                profundidad, latitud, longitud, magnitud, localizacion, terrestre, origen, provincia);
        return adminS.agregar(nuevoSismo);
    }
    
    public boolean modificarSismo(int id,Calendar fecha, Calendar hora, double profundidad,
            double latitud, double longitud, double magnitud, String localizacion, boolean terrestre, TOrigen  origen, NProvincia provincia){
        // cualquier otro paso antes de completar la inclusion
        // public Sismo(int id, Calendar fecha, Calendar hora, double profundidad, double latitud, double longitud, double magnitud, boolean terrestre, TOrigen origen, NProvincia provincia) {
        Sismo nuevoSismo = new Sismo(id, fecha, hora,
                profundidad, latitud, longitud, magnitud, localizacion, terrestre, origen, provincia);
        return adminS.modificar(nuevoSismo);
    }
    
    public boolean eliminarSismo(int id){
        return adminS.eliminar(id);
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
    
    public void getExelFile(){
        execelControl.importarExcelFile(adminS);
    }
    
    public void executeAllMap(double latitud, double longitud) throws IOException{
        mapControl = new MapsControl();
        mapControl.crearDoc();
        mapControl.generarHTML(latitud, longitud);
        mapControl.overwriteHTML();         
        mapControl.abrirBrowser(); 
    }
    
    public void guarDatos(JTable table){
        execelControl.Exportar(table);
    }
}
