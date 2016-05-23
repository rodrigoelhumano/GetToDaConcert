
package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import play.data.validation.*;
import play.modules.morphia.Model;
import org.mongodb.morphia.annotations.Entity; 

/**
 *
 * Modelo que almacena los datos de un usuario en el sistema.
 * 
 * @author Rodrigo Ramos Nájera
 */
@Entity
public class Usuario extends Model{
    
    @Required
    @MinSize(value=3)
    public String usuario;
    
    @Email
    @Required
    @Unique
    public String email;
    
    @Password
    public String password;
    
    public String nombre;
    public String primerApellido;
    public String segundoApellido;
    public Date fechaNacimiento;
    public List<Boleto> boletos;
    
    public boolean isAdmin;

    public Usuario() {}

    /**
     * Método constructor de un usuario.
     * 
     * @param usuario
     * @param nombre
     * @param primerApellido
     * @param email
     * @param password 
     */
    
    public Usuario(String usuario,String nombre,String primerApellido, String email, String password) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.email = email;
        this.password = password;
        boletos = new ArrayList<Boleto>();
    }

    @Override
    public String toString() {
        return String.format("%s %s ", this.nombre, this.primerApellido);
    }
    
    /**
     * Método para agregar un usuario.
     * 
     * @param usuario
     * @param nombre
     * @param primerApellido
     * @param email
     * @param password
     * @return 
     */
    
    public Usuario addUser(String usuario,String nombre, String primerApellido, String email, String password){
        Usuario nuevoUsuario = new Usuario(usuario, nombre, primerApellido, 
                email, password);
        //nuevoUsuario.addUser(usuario, email, password);
        this.save();
        return this;
    }

    /**
     * Método para obtener Nombre y Apellido de un usuario.
     * @return 
     */
    
    public String getNombreCompleto(){
        return String.format("%s %s", this.nombre,this.primerApellido);
    }
    
    
}
