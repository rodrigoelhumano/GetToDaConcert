
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
    
    
   
    
    
}
