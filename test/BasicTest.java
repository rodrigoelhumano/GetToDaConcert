import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void crearYRecuperarUsuario(){
        //Crear nuevo usuario y guardarlo
//        new Usuario("Alex", "alex@gmail.com", "123456").save();
        
        //Recuperar el usuario con la direccion de email alex@gmail.com
        Usuario alex = Usuario.find("byEmail","alex@gmail.com").first();
        
        // Test 
        assertNotNull(alex);
        assertEquals("Alex", alex.usuario);
    
    }
}
