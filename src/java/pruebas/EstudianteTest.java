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
	private Actividad actividad;
	
	@BeforeEach
	public void setUp() {
		this.estudiante = new Estudiante("Estudiante", "987", "estudiante.1@gmail.com", "Daniel", "Sánchez");
		this.learningPath = new LearningPath("TituloLP", "DescripcionLP", "ObjetivosLP", "06-01-2024", "07-03-2024", 5, 500, 2, 6, 1);
	}
	
	@Test
	public void logInExitoso() throws Exception{
		String respuesta = estudiante.login("Estudiante.1", "987");
		assertEquals("Inicio de sesión exitoso.", respuesta);
	}
	
	@Test
	public void logInFallido() throws Exception{
		String respuesta = estudiante.login("Estudiante.1", "564");
		assertEquals("Inicio de sesión fallido. Usuario o contraseña incorrectos", respuesta);
	}
	
	@Test
	public void logoutExitoso() throws Exception{
		String respuesta = estudiante.logout();
		assertEquals("Sesión finalizada con éxito.", respuesta);
	}
	
	@Test
	public void inscripcionLPExitosa() throws Exception{
		
		boolean respuesta = estudiante.inscribirLP(this.learningPath);
		assertTrue(respuesta, "Learning Path inscrito correctamente.");
		//Verifico que el LP nuevo esté en la lista de LPs inscritos
		assertTrue(estudiante.listaLearningPathInscritos().contains(this.learningPath));		
	}
	
	
	

}
