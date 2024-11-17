package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Logica.LearningPath;
import Logica.Actividad;
import Logica.Profesor;


class LearningPathTest {
	
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
	public void crearLPTest()throws Exception{
		boolean respuesta = learningPath.LearningPath(true, "Título", "Descripción", "Objetivos", "01-06-2024", "01-09-2024",
														5, 132480, 3, 8, 1);
		assertTrue(respuesta, "Learning Path creado con éxito.");
		
	}
	
	@Test
	public void agregarActividad()throws Exception{
		boolean respuesta2 = learningPath.addActividad(this.actividad);
		assertTrue(learningPath.listaActividades().contains(this.actividad), "Se agregó correctamente la actividad al Learning Path");
		
	}
	
	@Test
	public void quitarActividad()throws Exception{
		boolean respuesta3 = learningPath.eliminarActividad(this.actividad);
		assertFalse(learningPath.listaActividades().contains(this.actividad), "La actividad se eliminó correctamente");
	}
	

	}




