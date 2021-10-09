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
     * @param s el sismo a agregar
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
     * @param id el id del sismo a consultar
     * @return sismo: el objeto sismo si lo encuentra, null: si no encuentra una coincidencia
     */
    public Sismo consultar(int id){  
        for (Sismo sismo : allSismos) {
            if (sismo.getId() == id)
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
     * @param nuevosDatos el sismo con los nuevos datos para modificar
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
     * @param id el id del sismo a eliminar
     * @return true: si existe un match y se elimina, false: si no se encuentran coincidencias
     */
    public boolean eliminar(int id){    
        for (int i = 0; i < allSismos.size(); i++) {
            Sismo actual = allSismos.get(i);
            if (actual.getId()== id){
                allSismos.remove(i);
                return true;            }
        }             
        return false;
    }

    /**
     * Retorna el contador de sismos, el cual almacena la cantidad total de sismos registrados
     * @return un int de cantidad de sismos total
     */
    public int getContadorSismos() {
        return contadorSismos;
    }
    /**
     * Retorna la cantidad de sismos registrados en un provincia especifica
     * @param provincia es la provincia en la que se desea contar los sismos
     * @return un int de cantidad de sismos filtrados
     */
    public int consultarSismos(NProvincia provincia){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getProvincia() == provincia){
                cant++;
            }
        }
        return cant;
    }
    /**
     * Retorna la cantidad de sismos con un tipo de origen especifico
     * @param origen es el origen de los sismos que se quiere contar
     * @return un int de cantidad de sismos filtrados
     */
    public int consultarSismos(TOrigen origen){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getOrigen() == origen){
                cant++;
            }
        }
        return cant;
    }
    /**
     * Retorna un arraylist de sismos que se encuentren entre dos fechas indicadas
     * @param fechaIni la fecha inicial de donde se quieren los sismos
     * @param fechaFin la fecha final del periodo de tiempo de donde se quieren extraer los sismos
     * @return arraylist de sismos filtrados
     */
    public ArrayList<Sismo> consultarSismos(Calendar fechaIni, Calendar fechaFin){
        ArrayList<Sismo> sismosConultados = new ArrayList();
        for (Sismo sismo : allSismos){
            if( (sismo.getFecha().after(fechaIni) && sismo.getFecha().before(fechaFin)) || 
                    fechaIni.compareTo(sismo.getFecha()) == 0 || fechaFin.compareTo(sismo.getFecha()) == 0){
                sismosConultados.add(sismo);
            }
        }
        return sismosConultados;
    }
    /**
     * Retorna la cantidad de sismos de un mes especifico y un año especifico
     * @param mes el mes del que se desean los sismos
     * @param annio el año de donde se desean los sismos
     * @return int: cantidad de sismos filtrados
     */
    public int consultarSismos(int mes, int annio){
        int cant = 0;
        for (Sismo sismo : allSismos){
            if(sismo.getFecha().get(Calendar.MONTH) == mes && sismo.getFecha().get(Calendar.YEAR) == annio){
                cant++;
            }
        }
        return cant;
    }
    /**
     * Retorna un arraylist de sismos filtrados por su magnitud
     * @param index el index de un CBO segun las opciones que se muestran al usuario
     * @return arraylist de sismos filtrados
     */
    public ArrayList<Sismo> consultarSismos(int index){
        
        ArrayList<Sismo> sismosConsultados = new ArrayList();
        
        for (Sismo sismo : allSismos){
            if (index == 0){
                if (sismo.getMagnitud()< 2){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 1){
                if (sismo.getMagnitud()>= 2 && sismo.getMagnitud()<4){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 2){
               if (sismo.getMagnitud()>= 4 && sismo.getMagnitud()<5){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 3){
                if (sismo.getMagnitud()>= 5 && sismo.getMagnitud()<6){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 4){
                if (sismo.getMagnitud()>= 6 && sismo.getMagnitud()<7){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 5){
                if (sismo.getMagnitud()>= 7 && sismo.getMagnitud()<8){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 6){
                if (sismo.getMagnitud()>= 8 && sismo.getMagnitud()<10){
                    sismosConsultados.add(sismo);
                }
            }else if (index == 7){
                if (sismo.getMagnitud() >= 10){
                    sismosConsultados.add(sismo);
                }
            }
        }
        return sismosConsultados;
    }
    
    /**
     * devuelve un boolean dependiendo de si encuentra en algun sismo el año especificado
     * @param annio el año que se desea comprobar si existe en algún sismo con el año
     * @return true: en caso de encontrar una coincidencia, false: en caso de encontrar niguna coincidencia
     */
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
    /**
     * retorna un arraylist de todos los sismos registrados
     * @return arralist de sismos
     */
    public ArrayList<Sismo> getAllSismos() {
        return allSismos;
    }
}
