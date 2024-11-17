package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Logica.LearningPath;
import Logica.Actividad;
import Logica.Profesor;
import Logica.Tarea;
//import Logica.Estudiante;


class LearningPathTest {
	
	private Actividad actividad;
	private Profesor profesor;
	private LearningPath learningPath;
	//private Estudiante estudiante;

	@BeforeEach
	public void setUp() {
		this.profesor = new Profesor("Profesor.1", "abc", "profesor.1@gmail.com", "Alexander", "Pérez");
		this.learningPath = new LearningPath(true, "Título", "Descripción", "Objetivos", "01-11-2024", "01-12-2024", 
											7, 1000, 3, 6);
		this.actividad = new Tarea("Descripcion", "Objetivo", "01-12-2024", 1, 50, true, 3, true, true, true);
		
	}
	
	@Test
	public void crearLP() throws Exception{
		boolean respuesta = profesor.addLP(this.learningPath);
		assertTrue(respuesta);
		
	}
	
	@Test
	public void agregarActividad() throws Exception{
		boolean respuesta = learningPath.addActividad(actividad);
		assertTrue(respuesta);
	}
	
	@Test
	public void quitarActividad()throws Exception{
		boolean respuesta = learningPath.eliminarActividad(actividad);
		assertTrue(respuesta);
	}
	

	}




