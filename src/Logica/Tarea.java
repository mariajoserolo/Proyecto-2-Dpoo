package Logica;

import java.util.ArrayList;

public class Tarea extends Actividad{
	private int nota;
	private boolean disponible;
	private boolean hecha;
	private boolean calificada;
	
	
	public Tarea(String descripcion, String objetivo, String fechaLimite, int nivelDificultad, int duracionEsperada, boolean actividadCompletada, int nota, boolean disponible, boolean hecha, boolean calificada) {
		this.descripcion = descripcion;
		this.objetivo = objetivo;
		this.fechaLimite = fechaLimite;
		this.nivelDificultad = nivelDificultad;
		this.duracionEsperada = duracionEsperada;
		listaActividadPrevia = new ArrayList<>();
		this.actividadCompletada = actividadCompletada;
		this.profesor = profesor;
		this.tipoActividad = tipoActividad;
		this.idLP = idLP;
		this.nota = nota;
		this.disponible = disponible;
		this.hecha = hecha;
		this.calificada = calificada;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	public boolean isHecha() {
		return hecha;
	}

	public void setHecha(boolean hecha) {
		this.hecha = hecha;
	}

	public boolean isCalificada() {
		return calificada;
	}

	public void setCalificada(boolean calificada) {
		this.calificada = calificada;
	}

	public int obtenerNota(boolean disponible, boolean enviada, boolean calificada, int nota) {
		if (this.disponible==true && this.hecha==false) {
			System.out.println("La tarea está disponible, puede empezar a desarrollarla. ");
		}else if (this.disponible==true && this.hecha==true && calificada==false) {
			System.out.println("Esperando por calificación del profesor. ");
		} else if (this.disponible==true && this.hecha==true && calificada==true) {
			return nota;
		}
		return nota;
	}}

