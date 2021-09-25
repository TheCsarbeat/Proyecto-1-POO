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
    private LocalTime hora;
    private double profundidad;
    private TOrigen origen;

    //constructor

    public Sismo() {
    }
    
    public Sismo(int num, Calendar fecha, LocalTime hora, double profundidad, TOrigen origen) {
        this.id = num;
        this.fecha = fecha;
        this.hora = hora;
        this.profundidad = profundidad;
        this.origen = origen;
    }

    //getters
    public int getId() {
        return id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public TOrigen getOrigen() {
        return origen;
    }
    
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public void setOrigen(TOrigen origen) {
        this.origen = origen;
    }
    
    
}
