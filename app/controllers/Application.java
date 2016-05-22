package controllers;

import com.google.gson.JsonObject;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;

import controllers.securesocial.SecureSocial;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jj.play.org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import jj.play.org.eclipse.mylyn.wikitext.textile.core.TextileLanguage;
import models.Concierto;
import models.Usuario;
import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.lang.time.StopWatch;
import play.Logger;
import play.Play;
import play.libs.F;
import play.libs.IO;

import play.libs.WS;
import play.modules.excel.RenderExcel;
import play.modules.pdf.PDF;
import play.mvc.Controller;
import play.mvc.With;
import securesocial.provider.ProviderType;
import play.modules.pdf.PDF.Options;
import play.mvc.Finally;

import play.libs.WS;


import securesocial.provider.SocialUser;
/**
 *Controlador princial de la aplicación
 *
 * @author Alejandro Rodríguez González
 *
*/
//@With(Secure.class)
//@With(SecureSocial.class)

//@With(ExcelControllerHelper.class)
public class Application extends Controller {
    
    private static StopWatch watch;
    

    /**
     * Método que se encarga de la renderización de la landing page
     *
     */
    public static void landingPage() {
        render();
    }
    
    public static void excel(){
        render();
    }

    public static void main(){
        SocialUser user = SecureSocial.getCurrentUser();
        List<Concierto> listaCon = listaConcierto();
        render(listaCon);
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
    
//    public static void excelLista(){
//        List<Concierto> conciertos = Concierto.findAll();
//        render(conciertos);
//    }
//    
//    public static void generarTarjetaConcierto(){
//        
//        List<Concierto> con = Concierto.findAll();
//    	Date date = new Date();
//    	request.format = "xls";
//    	String fileName= "Conciertos.xlsx";
//    	renderArgs.put(RenderExcel.RA_ASYNC, true);
//        renderArgs.put(RenderExcel.RA_FILENAME, "customer_list_report.xlsx");
//        render();
//    }
//    public static void excel(){
//        List<Concierto> conciertos = Concierto.findAll();
//        render(conciertos);
//    }
//    
//    public static void generarTarjetaConcierto(Long id){
//        Concierto con = Concierto.findById(id);
//        renderArgs.put("fileName", con.getNombre() + ".xls");
//        
//    }
//
    public static void agregarConcierto(){
        render();
    }
    
    public static void registrarConcierto(String nombre, String lugar, Date fecha, double costo){
        Concierto con = new Concierto(nombre, lugar, fecha, costo);
        con.agregarConcierto(nombre, lugar, fecha, costo);
        con.save();
    }
    
    public static List<Concierto> listaConcierto(){
        
        return Concierto.findAll();
                
    }
    
    
    public static void generar() throws FileNotFoundException, DocumentException{
        FileOutputStream file = new FileOutputStream("/home/alexrdgz/Documents/PDFS/prueba.pdf");
        //File file = new File("/home/alexrdgz/Documents/PDFS/prueba.pdf");
        //InputStream file2 = new FileInputStream("/home/alexrdgz/Documents/PDFS/prueba2.pdf");
        Document document = new Document();
        
        PDF.writePDF(file, document);
        document.open();
        document.add(new Paragraph("Hola mundo"));
        document.close();
        //renderBinary(file2);
        
        
        
                
                
                
                
                
                
                
                
                
                
                
        
    }
    
    
}
