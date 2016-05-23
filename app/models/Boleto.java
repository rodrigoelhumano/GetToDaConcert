
package models;

import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import play.modules.morphia.Model;

/**
 * Modelo para guardar los datos de un concierto en el sistema.
 *
 * @author Rodrigo Ramos Nájera
 */
@Entity
public class Boleto extends Model{
    /*
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    public String id;*/
    
    @Reference
    public Concierto concert;
    @Reference
    public Usuario usuario;

    public Boleto(Concierto concert, Usuario usuario) {
        this.concert = concert;
        this.usuario = usuario;
    }
       
    public Boleto() {
    @Override
    public String toString() {
        return String.format("Nombre: %s Concierto: %s ", this.usuario, this.concert);
    }
    
    
    
    
    }
    
    public Boleto addBoleto(Concierto concert, Usuario usuario){
        
        this.save();
        return this;
    }
}
