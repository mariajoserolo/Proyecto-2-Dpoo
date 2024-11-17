package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Logica.Actividad;
import Logica.Profesor;
import Logica.Estudiante;
import Logica.LearningPath;


public class ActividadTest {
	
	private Actividad actividad;
	private Profesor profesor;
	private LearningPath learningPath;
	private Estudiante estudiante;

	@BeforeEach
	public void setUp() {
		
		this.profesor = new Profesor("Profesor.1", "abc", "profesor.1@gmail.com", "Alexander", "Pérez");
		this.learningPath = new LearningPath("Título", "Descripción", "Objetivos", "01-11-2024", "01-12-2024", 
											7, 1000, 3, 6,1, this.profesor);
		this.actividad = new Actividad("Descripcion", "Objetivo", 1, 50, "01-12-2024", "True", this.profesor,
										this.learningPath, "Tarea", 1 );
		
	}
	
	@Test
	public void testCrearActividad() throws Exception{
		//Aquí se supone que creo la actividad
		boolean respuesta = actividad.crearActividad(true, "Tarea", this.actividad, this.learningPath, 1);
		//Si se creó la actividad, debería ser true
		assertTrue(respuesta, "Actividad creada con éxito");
		//Aquí se supone que verifico que la actividad se haya agregado al LP
		assertTrue(learningPath.getListaActividades().contains(this.actividad), "Actividad creada y agregada con éxito");
	}

}
