package controllers;

import com.google.gson.JsonObject;

import controllers.securesocial.SecureSocial;
import models.Usuario;

import play.libs.WS;
import play.mvc.Controller;
import play.mvc.With;

import securesocial.provider.SocialUser;
import securesocial.provider.ProviderType;

/**
 *Controlador princial de la aplicación
 *
 * @author Alejandro Rodríguez González
 *
*/
//@With(Secure.class)
//@With(SecureSocial.class)
public class Application extends Controller {

    /**
     * Método que se encarga de la renderización de la landing page
     *
     */
    public static void landingPage() {
        render();
    }

    public static void main(){
        SocialUser user = SecureSocial.getCurrentUser();
        render();
    }

    /**
     * Método que se encarga del almacenamiento del registro de los usuarios

     * @param usuario
     * @param nombre
     * @param primerApellido
     * @param email
     * @param password ord
     */
    public static void registrarUsuario(String usuario, String nombre, String primerApellido, String email,
            String password) {

        Usuario usuarios = new Usuario(usuario, nombre, primerApellido, email, password);
        usuarios.addUser(usuario, nombre, primerApellido, email, password);
        usuarios.save();
        main();
    }
    
    /**
     * Método egresa el usuario buscandolo por su email.
     * @return 
     */

    static Usuario currentUser() {
        SocialUser currentUser = SecureSocial.getCurrentUser();
        return Usuario.find("email", currentUser.email).first();
    }

    static Usuario user(String email) {
        return Usuario.find("email", email).first();
    }

    static boolean isCurrentUser(Usuario user) {
        return currentUser().email.equals(user.email);
    }
}
