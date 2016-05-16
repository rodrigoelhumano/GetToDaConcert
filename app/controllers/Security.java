package controllers;

import models.Usuario;
import org.hibernate.annotations.Check;
import play.mvc.results.RenderTemplate;

/**
 * Controlador encargado del inicio de sesión de los usuarios
 *
 * @author Alejandro Rodríguez González
 */
public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {

        Usuario usuario = Usuario.find("byEmail", username).first();
        return usuario != null && usuario.password.equals(password);
    }

    static void onAuthenticated() {
        Usuario usuario = Usuario.find("byEmail", connected()).first();

        Application.main();
    }

    /**
     * Método encargado de autenticar al usuario como administrador
     *
     * @param profile
     */
    static boolean check(String profile) {
        Usuario usuario = Usuario.find("byEmail", connected()).first();
        if ("administrador".equals(profile)) {
            return usuario.isAdmin;
        } else {
            return false;
        }
    }

}
