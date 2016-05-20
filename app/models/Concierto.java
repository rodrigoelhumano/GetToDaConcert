/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.util.Date;
import play.data.validation.*;
import play.modules.morphia.Model;
import org.mongodb.morphia.annotations.Entity; 

/**
 *
 * @author alexrdgz
 */
@Entity
public class Concierto extends Model {
    
    @Required
    public int id;
    
    @Required
    public String nombre;
    
    @Required
    public String lugar;
    
    @Required
    public Date fecha;
    
    @Required
    public double costo;

    public Concierto(String nombre, String lugar, Date fecha, double costo) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Concierto agregarConcierto(String nombre, String lugar, Date fecha, double costo){
        Concierto con = new Concierto(nombre, lugar, fecha, costo);
        con.save();
        return con;
    }

    @Override
    public String toString() {
        return String.format("%s en %s el %", this.nombre, this.lugar);
    }
    
    
    
    
    
}
