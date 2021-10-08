/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.NProvincia;
import modelo.Sismo;
import modelo.TOrigen;

/**
 *
 * @author ytces
 */
public class AdmiSismos {
    private ArrayList<Sismo> allSismos = new ArrayList();
    private int contadorSismos = 0;
    
    public AdmiSismos(){
        allSismos = new ArrayList<>();
    }
    
    
    /**
     * Agrega un sismo al registro controlando los repetidos
     * @param s
     * @return true: lo agrego, false: no se agrego
     */
    public boolean agregar(Sismo s){
        for (Sismo sismo : allSismos) {
           if (sismo.getId() == s.getId())
                return false;
        }
        allSismos.add(s);
        contadorSismos++;
        return true;
    }
    
    /**
     * Busca un entre los sismos bajo el id y lo retorna si lo encuentra
     * @param num
     * @return sismo: el objeto sismo si lo encuentra, null: si no encuentra una coincidencia
     */
    public Sismo consultar(int num){  
        for (Sismo sismo : allSismos) {
            if (sismo.getId() == num)
                return sismo;
        }
        return null;
    }
    /**
     * Valida si ya existe un sismo con esos mismos datos
     * @param obj el sismo que se quiere comparar 
     * @return  true/false de la condicion dada
     */
    public boolean validarExisteSismo(Sismo obj){  
        for (Sismo sismo : allSismos) {
            if (sismo.equals(obj))
                return true;
        }
        return false;
    }
    
    /**
     * Busca un sismo bajo el id y lo sobreescribe con el nuevo sismo que tiene nuevos valores
     * @param nuevosDatos
     * @return true: en caso de encontrar el sismo y cambiar los datos, false:  en caso de no encontrar el sismo
     */
    public boolean modificar(Sismo nuevosDatos){
        for (int i = 0; i < allSismos.size(); i++) {
            Sismo actual = allSismos.get(i);
            if (actual.getId()== nuevosDatos.getId()){
                allSismos.set(i, nuevosDatos);
                return true;            }
        }
        return false;
    }
    
    
    /**
     * busca un sismo por id y si lo encuentra lo elimina del array
     * @param num
     * @return true: si existe un match y se elimina, false: si no se encuentran coincidencias
     */
    public boolean eliminar(int num){    
        for (int i = 0; i < allSismos.size(); i++) {
            Sismo actual = allSismos.get(i);
            if (actual.getId()== num){
                allSismos.remove(i);
                return true;            }
        }             
        return false;
    }

    public int getContadorSismos() {
        return contadorSismos;
    }
    
    public int consultarSismos(NProvincia provincia){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getProvincia() == provincia){
                cant++;
            }
        }
        return cant;
    }
    
    public int consultarSismos(TOrigen origen){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getOrigen() == origen){
                cant++;
            }
        }
        return cant;
    }
    
    public int consultarSismos(Calendar fechaIni, Calendar fechaFin){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getFecha().after(fechaIni) && sismo.getFecha().before(fechaFin)){
                cant++;
            }
        }
        return cant;
    }
    
    public int consultarSismos(int mes, int annio){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getFecha().get(Calendar.MONTH) == mes && sismo.getFecha().get(Calendar.YEAR) == annio){
                cant++;
            }
        }
        return cant;
    }
    
    public int consultarSismos(double magnitud1, double magnitud2){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getMagnitud() >= magnitud1 && sismo.getMagnitud() <= magnitud2){
                cant++;
            }
        }
        return cant;
    }
    
    public boolean comprobar(int annio){
        for (Sismo sismo : allSismos){
            if(sismo.getFecha().get(Calendar.YEAR)==annio){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "AdmiSismos{" + "allSismos=" + allSismos + '}';
    }
    
    public ArrayList<Sismo> getAllSismos() {
        return allSismos;
    }
}
