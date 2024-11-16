package Logica;

import java.util.ArrayList;

public class RecursoEducativo extends Actividad{
	private ArrayList<RecursoEducativo> listaRecursosEducativos;
	private boolean completado;
	private boolean exitoso;
	
	public RecursoEducativo (String descripcion, String objetivo, int duracionEsperada, boolean actividadCompletada) {
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.duracionEsperada = duracionEsperada;
		listaActividadPrevia = new ArrayList<>();
		this.profesor = profesor;
		this.tipoActividad = tipoActividad;
		this.idLP = idLP;
		this.listaRecursosEducativos = new ArrayList<RecursoEducativo>();
		this.completado = completado;
		this.exitoso = completado;
	}
	
	public void setCompletado(boolean completado) {
		this.completado = completado;
		}
	
	public void setExitoso(boolean exitoso) {
		this.exitoso = exitoso;
	}
	
	public void obtenerListaRecursos(ArrayList<RecursoEducativo> listaRecursosEducativos, RecursoEducativo recursoEducativo) {
		this.listaRecursosEducativos.add(recursoEducativo);
	}
	
	public void obtenerNota(boolean completado, boolean exitoso) {
		if (this.completado==true && this.exitoso==true) {
			System.out.println("La actividad fue completada exitosamente ");
		}else {
			System.out.println("Complete la actividad. ");
		}
	}}


