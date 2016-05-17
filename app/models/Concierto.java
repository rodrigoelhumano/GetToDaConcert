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
    public String nombre;
    
    @Required
    public String donde;
    
    @Required
    public Date fecha;
    
    @Required
    public double costo;

    public Concierto(String nombre, String donde, Date fecha, double costo) {
        this.nombre = nombre;
        this.donde = donde;
        this.fecha = fecha;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }
    
    

    @Override
    public String toString() {
        return String.format("%s en %s", this.nombre, this.donde);
    }
    
    
    
    
    
}
