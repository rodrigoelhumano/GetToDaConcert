package controllers;



import models.Concierto;
import org.hibernate.annotations.Check;
import play.mvc.Before;
import play.mvc.Router;
import play.mvc.With;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexrdgz
 */

@With(Secure.class)
public class Conciertos extends CRUD {
    
}
