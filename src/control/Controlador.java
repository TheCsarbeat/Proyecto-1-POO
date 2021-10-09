/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.io.IOException;
import modelo.Sismo;
import java.util.Calendar;
import java.util.ArrayList;
import javax.mail.MessagingException;
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
    private MapsControl mapControl = new MapsControl();
    private MailControl mailControl = new MailControl();

    /**
     * método del controlador para una instancia de un sismo al adminSismos
     * @param fecha la fecha del sismo a agregar
     * @param hora  la hora del sismo a agregar
     * @param profundidad la profundidad del sismo
     * @param latitud la longitud del sismo 
     * @param longitud longitud del sismo
     * @param magnitud magnitud del sismo
     * @param localizacion descripcion de lugar del sismo
     * @param terrestre valor para saber si es terrestre o no
     * @param origen TOrigen con el origen de la falla
     * @param provincia NProvincia la provincia donde ocurrio el sismo
     * @return true/false si se agregó el sismo
     */    
    public boolean agregarSismo(Calendar fecha, Calendar hora, double profundidad,
            double latitud, double longitud, double magnitud, String localizacion, boolean terrestre, TOrigen origen, NProvincia provincia) {
        Sismo nuevoSismo = new Sismo(adminS.getContadorSismos(), fecha, hora,
                profundidad, latitud, longitud, magnitud, localizacion, terrestre, origen, provincia);
        
        if(!adminS.validarExisteSismo(nuevoSismo)){
            if(nuevoSismo.getProvincia() != null){
                enviar(nuevoSismo);
            }
            
            return adminS.agregar(nuevoSismo);
        }
        return false;
    }
    
    /**
     * método del controlador modificar un sismo al adminSismos
     * @param fecha la fecha del sismo a agregar
     * @param hora  la hora del sismo a agregar
     * @param profundidad la profundidad del sismo
     * @param latitud la longitud del sismo 
     * @param longitud longitud del sismo
     * @param magnitud magnitud del sismo
     * @param localizacion descripcion de lugar del sismo
     * @param terrestre valor para saber si es terrestre o no
     * @param origen TOrigen con el origen de la falla
     * @param provincia NProvincia la provincia donde ocurrio el sismo
     * @return true/false si se modificó el sismo
     */  
    public boolean modificarSismo(int id, Calendar fecha, Calendar hora, double profundidad,
            double latitud, double longitud, double magnitud, String localizacion, boolean terrestre, TOrigen origen, NProvincia provincia) {
        // cualquier otro paso antes de completar la inclusion
        // public Sismo(int id, Calendar fecha, Calendar hora, double profundidad, double latitud, double longitud, double magnitud, boolean terrestre, TOrigen origen, NProvincia provincia) {
        Sismo nuevoSismo = new Sismo(id, fecha, hora,
                profundidad, latitud, longitud, magnitud, localizacion, terrestre, origen, provincia);
        if(!adminS.validarExisteSismo(nuevoSismo)){
            return adminS.modificar(nuevoSismo);
        }
        
        return false;
        
    }
    
    
    /**
     * método del controladora para eliminar un sismo
     * @param id valor entero que identifica el sismo
     * @return  true/false si se eliminó el sismo
     */
    public boolean eliminarSismo(int id) {
        return adminS.eliminar(id);
    }
    
    /**
     * método del controladora para consultar un sismo
     * @param id valor entero que identifica el sismo
     * @return  el obejto sismo encontrado
     */
    public Sismo consultarSismo(int id) {
        return adminS.consultar(id);
    }
    
    /**
     * método del controladora para mostrarlos sismo en String
     * @return  string del adminsismos
     */
    public String mostrarSismos() {
        return adminS.toString();
    }
    /**
     * método del contralor para agregar un asociado
     * @param id valor entero que identifica el asociado
     * @param name nombre del asociado
     * @param correo el correo que usa el asociado
     * @param celular   texto con el número de celular del asociado
     * @param provincias Arraylist de NProvincia con las provincias que el asocciado desea ser notificado
     * @return true/false si se agrega un asociado
     */
    public boolean agregarAsociado(String name, String correo, String celular, ArrayList<NProvincia> provincias) {
        Asociado nuevoAsociado = new Asociado(adminA.getContador(), name, correo, celular, provincias);
        return adminA.agregar(nuevoAsociado);
    }
    /**
     * método del contraldor para cosultar un asociado
     * @param id valor entero que identifica un asociado
     * @return el objeto asociado que se consultó
     */
    public Asociado consultarAsociado(int id) {
        return adminA.consultar(id);
    }
    
    /**
     * método para mostrar todos los asociados en String
     * @return String con todos los asociado
     */
    public String mostrarAsociados() {
        return adminA.toString();
    }
    
    /**
     * método del contraldor que carga los sismos
     * @return Tablemodel con los datos de los sismos cargados
     */
    public DefaultTableModel cargarSismos() {
        return Cargador.cargarSismos(adminS.getAllSismos());
    }
    
    public DefaultTableModel cargarSismos(ArrayList<Sismo> sismos) {
        return Cargador.cargarSismos(sismos);
    }
    
    /**
     * método del controlador para obtener los datos de los sismos
     */
    public void obtenerDatosArchivoExel() {     
        execelControl.obtenerDatosExel(adminS);
    }
    

    public void leerHTML() throws IOException {
        mapControl.leer();
    }
    /**
     * Modifica el archivo HTML con las nuevas coordenadas del sismo seleccionado
     * @param latitud: es la latitud recibida del sismo
     * @param longitud: es la longitud recibida del sismo
     */
    public void modificarHTML(double latitud, double longitud) {
        mapControl.modificar(latitud, longitud);
    }

    public void escribirHTML() {
        mapControl.escribir();
    }

    public MapsControl getMapsControl() {
        return mapControl;
    }

    public void openMaps() {
        mapControl.open();
    }
    /**
     * método del controlador guardar los datos en exel
     * @param table JTable con los datos que se quieren guardar
     */
    public void guarDatos(JTable table) {
        execelControl.guardarDatosExel(table);
    }
    
    public void enviar(Sismo sismo){
        for (Asociado i:adminA.getAllAsociados()) {
            if(!i.getCorreo().equals("")){        
                for (NProvincia j:  i.getProvincias()) {
                    if(j != null){
                        if(j.equals(sismo.getProvincia())){
                            mailControl.sendEmail(sismo, i.getName(), i.getCorreo());                    
                        }
                    }
                }     
            }
        }
       
    }
    
    public void obtenerAsociados(){
        execelControl.obtenerDatosExel(adminA);
    }
    
    public int consultarSismosProvincia(NProvincia provincia){
        return adminS.consultarSismos(provincia);
    }
    
    public int consultarSismosOrigen(TOrigen origen){
        return adminS.consultarSismos(origen);
    }
    
    public ArrayList<Sismo> consultarSismosRangoFecha(Calendar fechaIni, Calendar fechaFin){
        return adminS.consultarSismos(fechaIni, fechaFin);
    }
    
    public int consultarSismosMes(int mes, int annio){
        return adminS.consultarSismos(mes, annio);
    }
    
    public int consultarSismosMagnitud(double magnitud1, double magnitud2){
        return adminS.consultarSismos(magnitud1, magnitud2);
    }
    
    public boolean comprobarAnnio(int annio){
        return adminS.comprobar(annio);
    }
}
