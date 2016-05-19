package controllers;

import play.mvc.With;

/**
 * Controlador para un usuario.
 *
 * @author Rodrigo Ramos Nájera
 */

@With(Secure.class)
public class Usuarios extends CRUD{

}
