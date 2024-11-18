package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Logica.Estudiante;
import Logica.Actividad;
import Logica.LearningPath;


public class EstudianteTest {

	private Estudiante estudiante;
	private LearningPath learningPath;
	//private Actividad actividad;
	
	@BeforeEach
	public void setUp() {
		this.estudiante = new Estudiante("Estudiante.1", "987", "estudiante.1@gmail.com", "Daniel", "Sánchez");
		//this.learningPath = learningPath;
		this.learningPath = new LearningPath(false, "Título", "Descripción", "Objetivos", "01-11-2024", "01-12-2024", 
				7, 1000, 3, 6);
	}
	
	@Test
	public void logInExitoso() throws Exception{
		String respuesta = estudiante.login("Estudiante.1", "987");
		assertEquals("Inicio de sesión exitoso.", respuesta);
	}
	
	@Test
	public void logInFallido() throws Exception{
		String respuesta = estudiante.login("Estudiante.1", "564");
		assertEquals("Usuario o contraseña incorrectas.", respuesta);
	}
	
	@Test
	public void logoutExitoso() throws Exception{
		String respuesta = estudiante.logout();
		assertEquals("Sesión cerrada.", respuesta);
	}
	
	@Test
	public void inscripcionLPExitosa() throws Exception{
		
		//boolean respuesta = estudiante.inscribirLP(this.learningPath);
		assertTrue(estudiante.inscribirLP(learningPath));
		//Verifico que el LP nuevo esté en la lista de LPs inscritos
		//boolean respuesta2 = estudiante.completarLearningPath(this.learningPath);
		
		//(estudiante.listaLearningPathInscritos().contains(this.learningPath));		
	}
	@Test
	public void completarLP() throws Exception{
		assertFalse(estudiante.completarLearningPath(learningPath));
	}
	
	
	

}
