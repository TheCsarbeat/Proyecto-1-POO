/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author ytces
 */
public class Asociado {
    private int id;
    private String name;
    private String correo;
    private String celular;
    private ArrayList<NProvincia> provincias = new ArrayList();

    public Asociado() {
    }

    public Asociado(int id, String name, String correo, String celular, ArrayList<NProvincia> provincias) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.celular = celular;
        this.provincias = provincias;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public ArrayList<NProvincia> getProvincias() {
        return provincias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setProvincias(ArrayList<NProvincia> provincias) {
        this.provincias = provincias;
    }
    /**
     * agrega una provincia de interes al array donde se encuentran las provincias de interes
     * @param provincia
     * @return true: se agrego, false: no se pudo agregar por estar repetida
     */
    public boolean agregarProvincia(NProvincia provincia){
        for(NProvincia i: provincias){
            if(provincia == i){
                return false;
            }
        }
        provincias.add(provincia);
        return true;
    }

    @Override
    public String toString() {
        return "Asociado{" + "id=" + id + ", name=" + name + ", correo=" + correo + ", celular=" + celular + ", provincias=" + provincias + '}';
    }
    
}
