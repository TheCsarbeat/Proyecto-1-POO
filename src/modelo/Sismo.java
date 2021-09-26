/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Calendar;
import java.time.LocalTime;

/**
 *
 * @author ytces
 */
public class Sismo {
    private int id;
    private Calendar fecha;
    private Calendar hora;
    private double profundidad, latitud, longitud, magnitud;
    private boolean terrestre;
    private TOrigen origen;
    private NProvincia provincia;
   

    //constructor

    public Sismo() {
    }
    
    public Sismo(int num, Calendar fecha, Calendar hora, double profundidad, TOrigen origen) {
        this.id = num;
        this.fecha = fecha;
        this.hora = hora;
        this.profundidad = profundidad;
        this.origen = origen;
    }

    public Sismo(int id, Calendar fecha, Calendar hora, double profundidad, double latitud, double longitud, double magnitud, boolean terrestre, TOrigen origen, NProvincia provincia) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.profundidad = profundidad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.magnitud = magnitud;
        this.terrestre = terrestre;
        this.origen = origen;
        this.provincia = provincia;
    }

    //getters
    public int getId() {
        return id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Calendar getHora() {
        return hora;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public TOrigen getOrigen() {
        return origen;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public boolean isTerrestre() {
        return terrestre;
    }

    public NProvincia getProvincia() {
        return provincia;
    }
    
    
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setOrigen(TOrigen origen) {
        this.origen = origen;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public void setTerrestre(boolean terrestre) {
        this.terrestre = terrestre;
    }

    public void setProvincia(NProvincia provincia) {
        this.provincia = provincia;
    }
    
    
}
