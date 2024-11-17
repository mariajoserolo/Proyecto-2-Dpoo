package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Logica.Usuario;
import Logica.Profesor;
import Logica.Actividad;
import Logica.LearningPath;



public class ProfesorTest {

	private Profesor profesor;
	private Actividad actividad;
	private LearningPath learningPath;
	
	@BeforeEach
	public void setUp() {
		this.profesor = new Profesor("Profesor.1", "abc", "profesor.1@gmail.com", "Alexander", "Pérez");
		this.learningPath = new LearningPath("Título", "Descripción", "Objetivos", "01-11-2024", "01-12-2024", 
				7, 1000, 3, 6,1, this.profesor);
		this.actividad = new Actividad("Descripcion", "Objetivo", 1, 50, "01-12-2024", "True", this.profesor,
			this.learningPath, "Tarea", 1 );
	}
	
	@Test
	public void logInExitoso() throws Exception{
		String respuesta = profesor.login("Profesor.1", "abc");
		assertEquals("Inicio de sesión exitoso.", respuesta);
	}
	
	@Test
	public void logInFallido() throws Exception{
		String respuesta = profesor.login("Profesor.1", "xyz");
		assertEquals("Inicio de sesión fallido. Usuario o contraseña incorrectos", respuesta);
	}
	
	@Test
	public void logoutExitoso() throws Exception{
		String respuesta = profesor.logout();
		assertEquals("Sesión finalizada con éxito.", respuesta);
	}
	@Test
	public void agregarActividad() throws Exception{
		boolean respuesta = actividad.crearActividad(true, "Tarea", this.actividad, this.learningPath, 1);
		assertTrue(respuesta, "Actividad creada con éxito");
		boolean respuesta2 = profesor.addActividadCreada(this.actividad);
		assertTrue(profesor.listaActividadesCreadas().contains(this.actividad));		
		
	}
	@Test
	public void crearLP() throws Exception{
		boolean respuesta = learningPath.LearningPath(true, "Título", "Descripción", "Objetivos", "01-06-2024", "01-09-2024",
				5, 132480, 3, 8, 1);
		assertTrue(respuesta, "Learning Path creado con éxito.");
		//Con esto quiero verificar que efectivamente se agregó el LP a la lista de LPs
		boolean respuesta2 = profesor.addLP(this.learningPath);
		assertTrue(profesor.listaLearningPath().contains(this.learningPath));
	}

}
