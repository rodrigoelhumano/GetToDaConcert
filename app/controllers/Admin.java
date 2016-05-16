
package controllers;

import java.util.List;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

/**
 * Controlador con métodos del administrador.
 * 
 * @author Alejandro Rodríguez González
 */
@With(Secure.class)
public class Admin extends Controller{
  /*   @Before
    static void setConnectedUser() {
        if (Security.isConnected()) {
            Usuario user = Usuario.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.nombre);

        }
    }

    public static void index() {
        List<Usuario> usuario = Usuario.find("email", Security.connected()).asList();
        render(usuario);
    }*/
}
