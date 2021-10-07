/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Calendar;
import java.util.Objects;
import control.Utilities;

/**
 *
 * @author ytces
 */
public class Sismo {
    private int id;
    private Calendar fecha;
    private Calendar hora;
    private double profundidad, latitud, longitud, magnitud;
    private String localizacion;
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

    public Sismo(int id, Calendar fecha, Calendar hora, double profundidad, double latitud, double longitud, double magnitud, String localizacion, boolean terrestre, TOrigen origen, NProvincia provincia) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.profundidad = profundidad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.magnitud = magnitud;
        this.localizacion = localizacion;
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

    public String getLocalizacion() {
        return localizacion;
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

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setTerrestre(boolean terrestre) {
        this.terrestre = terrestre;
    }

    public void setProvincia(NProvincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sismo other = (Sismo) obj;
        
        if (Double.doubleToLongBits(this.profundidad) != Double.doubleToLongBits(other.profundidad)) {
            return false;
        }
        if (Double.doubleToLongBits(this.latitud) != Double.doubleToLongBits(other.latitud)) {
            return false;
        }
        if (Double.doubleToLongBits(this.longitud) != Double.doubleToLongBits(other.longitud)) {
            return false;
        }
        if (Double.doubleToLongBits(this.magnitud) != Double.doubleToLongBits(other.magnitud)) {
            return false;
        }
        if (this.terrestre != other.terrestre) {
            return false;
        }
        if (!Objects.equals(this.localizacion, other.localizacion)) {
            return false;
        }
        String fechaS = Utilities.convertirFechaToString(this.fecha);
        String fechaOther = Utilities.convertirFechaToString(other.fecha);
        
        if (!fechaS.equals(fechaOther)) {
            return false;
        }
        String horaS = Utilities.convertirHoraToString(this.hora);
        String horaOther = Utilities.convertirHoraToString(other.hora);

        if (!horaS.equals(horaOther)) {
            return false;
        }
        if (this.origen != other.origen) {
            return false;
        }
        if (this.provincia != other.provincia) {
            return false;
        }

        return true;
    }
    

    
    
}
