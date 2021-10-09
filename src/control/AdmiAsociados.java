/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.ArrayList;
import modelo.Asociado;

/**
 *
 * @author ytces
 */
public class AdmiAsociados {
    private ArrayList<Asociado> allAsociados = new ArrayList();
    private int contador = 0;
    public AdmiAsociados(){
        allAsociados = new ArrayList<>();
        
    }
    
    
    /**
     * Agrega un asociado al registro controlando los repetidos
     * @param a el asociado a agregar
     * @return true: lo agrego, false: no se agrego
     */
    public boolean agregar(Asociado a){
        for (Asociado sismo : allAsociados) {
           if ( sismo.getId() == a.getId())
                return false;
        }
        allAsociados.add(a);
        contador++;
        return true;
    }
    
    /**
     * Busca un entre los asociados bajo el id y lo retorna si lo encuentra
     * @param id el asociado a consultar
     * @return sismo: el objeto sismo si lo encuentra, null: si no encuentra una coincidencia
     */
    public Asociado consultar(int id){  
        for (Asociado asociado : allAsociados) {
            if (asociado.getId() == id)
                return asociado;
        }
        return null;
    }
    
    /**
     * Busca un asociado bajo el id y lo sobreescribe con el nuevo sismo que tiene nuevos valores
     * @param nuevosDatos el asociado con los nuevos datos
     * @return true: en caso de encontrar el asociado y cambiar los datos, false:  en caso de no encontrar el asociado
     */
    public boolean modificar(Asociado nuevosDatos){
        for (int i = 0; i < allAsociados.size(); i++) {
            Asociado actual = allAsociados.get(i);
            if (actual.getId()== nuevosDatos.getId()){
                allAsociados.set(i, nuevosDatos);
                return true;            }
        }
        return false;
    }
    
    
    /**
     * busca un asociado por id y si lo encuentra lo elimina del array
     * @param id el id del asociado para ser eliminado
     * @return true: si existe un match y se elimina, false: si no se encuentran coincidencias
     */
    public boolean eliminar(int id){    
        for (int i = 0; i < allAsociados.size(); i++) {
            Asociado actual = allAsociados.get(i);
            if (actual.getId()== id){
                allAsociados.remove(i);
                return true;            }
        }             
        return false;
    }

    @Override
    public String toString() {
        return "AdmiAsociados{" + "allAsociados=" + allAsociados + '}';
    }
    
    /**
     * retorna un arraylist con todos los asociados registrados
     * @return 
     */
    public ArrayList<Asociado> getAllAsociados() {
        return allAsociados;
    }

    /**
     * Retorna la cantidad de asociados registrados
     * @return 
     */
    public int getContador() {
        return contador;
    }
    
    
}
