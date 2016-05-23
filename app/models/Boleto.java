
package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;
import play.modules.morphia.Model;

/**
 * Modelo para guardar los datos de un concierto en el sistema.
 *
 * @author Rodrigo Ramos Nájera
 */
@Entity
public class Boleto extends Model{
    
    @Reference
    public Concierto concert;
    @Reference
    public Usuario usuario;

    public Boleto(Concierto concert, Usuario usuario) {
        this.concert = concert;
        this.usuario = usuario;
    }
       
    public Boleto() {
    
    }
    
    public Boleto addBoleto(Concierto concert, Usuario usuario){
        
        this.save();
        return this;
    }
}
