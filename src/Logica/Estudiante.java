package Logica;

import java.util.ArrayList;
import java.io.Serializable;

public class Estudiante extends Usuario{

	private ArrayList<LearningPath> listaLearningPathCompletados;
	private ArrayList<LearningPath> listaLearningPathInscritos;
	
	public Estudiante(String login, String password, String correo, String nombre, String apellido) {
		super(login, password, correo, nombre, apellido);
		this.listaLearningPathCompletados = new ArrayList<>();
		this.listaLearningPathInscritos = new ArrayList<>();
	}
		
	public boolean inscribirLP(LearningPath learningPath) {
		listaLearningPathInscritos.add(learningPath);
		if (listaLearningPathInscritos.contains(learningPath) == true){
			return true;
			}
		else { 
			return false;
			}
			
		
	}
	
	 public boolean completarLearningPath(LearningPath learningPath) {
		 if (learningPath.isCompletado()==true) {
			 listaLearningPathCompletados.add(learningPath);
			 listaLearningPathInscritos.remove(learningPath);
			 
	    }
		 if (listaLearningPathCompletados.contains(learningPath) == true){
				return true;
				}
			else { 
				return false;
				}
		 
		 }
	 }
	
	

