package Main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Logica.Profesor;
import Logica.Usuario;
import Logica.Estudiante;
import Logica.LearningPath;
import Logica.Encuesta;
import Logica.Examen;
import Logica.Quiz;
import Logica.RecursoEducativo;
import Logica.Tarea;
import Persistencia.ArchivoCSV;
import Persistencia.ArchivoSerializable;



public class Principal {
	public Principal(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 ArrayList<Profesor> profesores = new ArrayList<>();
		 ArrayList<Estudiante> estudiantes = new ArrayList<>();
		 boolean correrUsuario = true;
		 
		 try {
	            profesores = (ArrayList<Profesor>) ArchivoSerializable.leerObjetoSerializable("profesor.ser");
	            System.out.println("Profesores cargados!");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("No existen profesores. Se crea nueva lista");
	        }
		 try {
	            estudiantes = (ArrayList<Estudiante>) ArchivoSerializable.leerObjetoSerializable("estudiante.ser");
	            System.out.println("Estudiantes cargados!");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("No existen estudiantes. Se crea nueva lista");
	        }
	while (correrUsuario) {


	System.out.println("Bienvenido");
	            System.out.println("1. Crear Usuario");
	            System.out.println("2. Login");
	            System.out.println("3. Salir");
	            System.out.print("Elija una opción: ");
	            int option = scanner.nextInt();
	            scanner.nextLine(); 

		switch(option) {
	  case 1:

		crearUsuario(scanner, profesores, estudiantes);
		break;

	case 2: 
	 if (login(scanner, profesores, estudiantes)) {
		 correrUsuario = false;
	 }
	 
	break;

	case 3: 
		System.out.println("Hasta luego");
	                    return;

	default:
	                    System.out.println("No es una opción: intente de nuevo");

	}
	}
	}

	private static Usuario crearUsuario(Scanner scanner, ArrayList profesores, ArrayList estudiantes){
	System.out.print("Usuario: ");
	        String usuario = scanner.nextLine();
	        System.out.print("Contraseña: ");
	        String contrasena = scanner.nextLine();
	        System.out.print("Nombre: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Apellido: ");
	        String apellido = scanner.nextLine();
	        System.out.print("Email: ");
	        String email = scanner.nextLine();
	        System.out.print("Tipo (Profesor/Estudiante): ");
	        String tipo = scanner.nextLine();
	        String usuarioCompleto = usuario + "," + contrasena + "," + nombre + "," + apellido + "," + email + "," + tipo;

	try{

		ArrayList<String> usuarios = ArchivoCSV.leerArchivoCSV("usuarios.txt");
		usuarios.add(usuarioCompleto);
		ArchivoCSV.guardarTextoCSV(usuarios, "usuarios.txt");
		System.out.println("Usuario creado!");
	} catch (IOException e){
		System.out.println("No se pudo guardar el ususario");
	            e.printStackTrace();
	}
	if ("profesor".equalsIgnoreCase(tipo)) {	
		Profesor prof = new Profesor(usuario, contrasena, email, nombre, apellido);
		profesores.addLast(prof);
		try {
		    ArchivoSerializable.guardarObjetoSerializable(profesores, "profesor.ser");
		    System.out.println("Se ha guardado el profesor.");
		} catch (IOException e) {
		    e.printStackTrace();
		};
	} else if ("estudiante".equalsIgnoreCase(tipo)) {
		Estudiante est = new Estudiante(usuario, contrasena, email, nombre, apellido);
		estudiantes.addLast(est);
		try {
		    ArchivoSerializable.guardarObjetoSerializable(estudiantes, "estudiante.ser");
		    System.out.println("Se ha guardado el profesor.");
		} catch (IOException e) {
		    e.printStackTrace();}
	}
	return null;
	}

	private static boolean login(Scanner scanner, ArrayList<Profesor> profesores, ArrayList<Estudiante> estudiantes){
		System.out.print("Usuario: ");
	        String user = scanner.nextLine();
	        System.out.print("Contraseña: ");
	        String contra = scanner.nextLine();

	try{
	ArrayList<String> usuarios = ArchivoCSV.leerArchivoCSV("usuarios.txt");
	for (String linea : usuarios){
	String[] informacionUsuario = linea.split(",");
	if(informacionUsuario[0].equals(user) && informacionUsuario[1].equals(contra)){
	System.out.println("Login logrado!");
	                    String tipoUsuario = informacionUsuario[5];
	                    if ("profesor".equalsIgnoreCase(tipoUsuario)) {
	                    	for (Profesor profesorCorrecto : profesores) {
	                    		if (profesorCorrecto.getLogin().equals(user)){
	                    			profesorMenu(scanner, profesorCorrecto);
	                    			break;
	                    		}
	                    	}
	                    } else if ("estudiante".equalsIgnoreCase(tipoUsuario)) {
	                    	for (Estudiante estudianteCorrecto : estudiantes) {
	                    		if (estudianteCorrecto.getLogin().equals(user)) {
	                    			estudianteMenu(scanner, estudianteCorrecto);
	                    			break;
	                    		}
	                    	}
	                    } else {
	                        System.out.println("Tipo de usuario desconocido");
	                    }
	                    return true;
	                }
	            }
	            System.out.println("Contraseña o Usuario invialido");
	        } catch (IOException e) {
	            System.out.println("Ocurrio un error leyendo el archivo");
	            e.printStackTrace();
	        }
	return false;
	    }


	public static void profesorMenu( Scanner scanner, Profesor profesor){
		ArrayList<LearningPath> learningPaths = new ArrayList<>();
		try {
            learningPaths = (ArrayList<LearningPath>) ArchivoSerializable.leerObjetoSerializable("learningPaths.ser");
            System.out.println("Profesores cargados!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existen learning paths. Se crea nueva lista");
        }
		boolean correrProfesor = true;
		while (correrProfesor) {
		System.out.println("Menu profesor:");
		System.out.println("1. Crear Learning Path");
        System.out.println("2. Crear Actividad");
        System.out.println("3. Actualizar Learning Path");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 
        
        switch(option) {
        case 1: 
        	System.out.print("Titulo: ");
	        String titulo = scanner.nextLine();
	        System.out.print("Descripción general: ");
	        String descripcion = scanner.nextLine();
	        System.out.print("Objetivos: ");
	        String objetivos = scanner.nextLine();
	        System.out.print("Fecha Inicio: ");
	        String fechaInicio = scanner.nextLine();
	        LearningPath learningPath = new LearningPath(true, titulo, descripcion, objetivos, fechaInicio, "-", 0, 0, 1, 0);
	        learningPaths.add(learningPath);
	        try {
			    ArchivoSerializable.guardarObjetoSerializable(learningPaths, "learningPaths.ser");
			    System.out.println("Se ha guardado el learning path.");
			} catch (IOException e) {
			    e.printStackTrace();
			}
        	break;
        case 2: 
        	System.out.print("Digite el titulo del learning path al que desea añadir una actividad: ");
	        String tituloLP = scanner.nextLine();
	        LearningPath lpActualizar = null;
	        for (LearningPath lpLista : learningPaths) {
	        	if(tituloLP.equalsIgnoreCase(lpLista.getTitulo())) {
	        		lpActualizar = lpLista;
	        		break;
	        	}
	        }
	        System.out.println("Digite el numero correspondiente para indicar el tipo de actividad que desea: ");
	        System.out.println("1. Tarea ");
	        System.out.println("2. Quiz ");
	        System.out.println("3. RecursoEducativo ");
	        System.out.println("4. Examen ");
	        System.out.println("5. Encuesta ");
	        String opcion = scanner.nextLine();
	        if(lpActualizar != null) {
	        if(opcion.equals("1")) {
	        	System.out.print("Descripcion: ");
		        String desc1 = scanner.nextLine();
		        System.out.print("Objetivo: ");
		        String obj1 = scanner.nextLine();
		        System.out.print("Duración aproximada (minutos): ");
		        String dur1 = scanner.nextLine();
		        int duration = 0;
		        try {
		            duration = Integer.parseInt(dur1);  // Convert the string to an integer
		            System.out.println("Duración aproximada en minutos: " + duration);
		        } catch (NumberFormatException e) {
		            System.out.println("Por favor, introduce un número válido.");
		        }
		        Tarea tarea = new Tarea(desc1, obj1, "NA", 0, duration, false, 0, true, false, false);
		        learningPaths.remove(lpActualizar);
		        lpActualizar.addActividad(tarea);	
		        learningPaths.add(lpActualizar);
		        try {
				    ArchivoSerializable.guardarObjetoSerializable(learningPaths, "learningPaths.ser");
				    System.out.println("Se ha guardado el learning path.");
				} catch (IOException e) {
				    e.printStackTrace();
				}
	        }else if(opcion.equals("2")) {
	        	System.out.print("Descripcion: ");
		        String desc2 = scanner.nextLine();
		        System.out.print("Objetivo: ");
		        String obj2 = scanner.nextLine();
		        System.out.print("Duración aproximada (minutos): ");
		        String dur2 = scanner.nextLine();
		        int duration2 = 0;
		        try {
		            duration2 = Integer.parseInt(dur2);  // Convert the string to an integer
		            System.out.println("Duración aproximada en minutos: " + duration2);
		        } catch (NumberFormatException e) {
		            System.out.println("Por favor, introduce un número válido.");
		        }
		        Quiz quiz = new Quiz(desc2, obj2, "NA", 0, duration2, false, 0, true, false, false, false, false );
		        learningPaths.remove(lpActualizar);
		        lpActualizar.addActividad(quiz);
		        learningPaths.add(lpActualizar);
		        try {
				    ArchivoSerializable.guardarObjetoSerializable(learningPaths, "learningPaths.ser");
				    System.out.println("Se ha guardado el learning path.");
				} catch (IOException e) {
				    e.printStackTrace();
				}
	        }else if(opcion.equals("3")) {
	        	System.out.print("Descripcion: ");
		        String desc3 = scanner.nextLine();
		        System.out.print("Objetivo: ");
		        String obj3 = scanner.nextLine();
		        System.out.print("Duración aproximada (minutos): ");
		        String dur3 = scanner.nextLine();
		        int duration3 = 0;
		        try {
		            duration3 = Integer.parseInt(dur3);  // Convert the string to an integer
		            System.out.println("Duración aproximada en minutos: " + duration3);
		        } catch (NumberFormatException e) {
		            System.out.println("Por favor, introduce un número válido.");
		        }
		        RecursoEducativo recursoEd = new RecursoEducativo(desc3, obj3, duration3, false);
		        learningPaths.remove(lpActualizar);
	        	lpActualizar.addActividad(recursoEd);
	        	learningPaths.add(lpActualizar);
		        try {
				    ArchivoSerializable.guardarObjetoSerializable(learningPaths, "learningPaths.ser");
				    System.out.println("Se ha guardado el learning path.");
				} catch (IOException e) {
				    e.printStackTrace();
				}
	        }else if(opcion.equals("4")) {
	        	System.out.print("Descripcion: ");
		        String desc4 = scanner.nextLine();
		        System.out.print("Objetivo: ");
		        String obj4 = scanner.nextLine();
		        System.out.print("Duración aproximada (minutos): ");
		        String dur4 = scanner.nextLine();
		        int duration4 = 0;
		        try {
		            duration4 = Integer.parseInt(dur4);  // Convert the string to an integer
		            System.out.println("Duración aproximada en minutos: " + duration4);
		        } catch (NumberFormatException e) {
		            System.out.println("Por favor, introduce un número válido.");
		        }
		        Examen Examen = new Examen(desc4, obj4, duration4, 0, false, false, false);
		        learningPaths.remove(lpActualizar);
		        lpActualizar.addActividad(Examen);
		        learningPaths.add(lpActualizar);
		        try {
				    ArchivoSerializable.guardarObjetoSerializable(learningPaths, "learningPaths.ser");
				    System.out.println("Se ha guardado el learning path.");
				} catch (IOException e) {
				    e.printStackTrace();
				}
	        }else if(opcion.equals("5")) {
	        	System.out.print("Descripcion: ");
		        String desc5 = scanner.nextLine();
		        System.out.print("Objetivo: ");
		        String obj5 = scanner.nextLine();
		        System.out.print("Duración aproximada (minutos): ");
		        String dur5 = scanner.nextLine();
		        int duration5 = 0;
		        try {
		            duration5 = Integer.parseInt(dur5);  // Convert the string to an integer
		            System.out.println("Duración aproximada en minutos: " + duration5);
		        } catch (NumberFormatException e) {
		            System.out.println("Por favor, introduce un número válido.");
		            break;
		        }
		        Encuesta encuesta = new Encuesta(desc5, obj5, duration5, false);
		        learningPaths.remove(lpActualizar);
		        lpActualizar.addActividad(encuesta);
		        learningPaths.add(lpActualizar);
		        try {
				    ArchivoSerializable.guardarObjetoSerializable(learningPaths, "learningPaths.ser");
				    System.out.println("Se ha guardado el dato.");
				} catch (IOException e) {
				    e.printStackTrace();
				}
	        }else {
	        	System.out.println("No es una opción");
	        }
	        }else {
	        	System.out.println("No se ha encontrado learning path!");
	        }
        	break;
        	
        case 3:
        	break;
        case 4: 
        	correrProfesor = false;
        	System.out.println("Chao!");
        	return;
        }
		}
	}
	
	public static void estudianteMenu( Scanner scanner, Estudiante estudiante) {
		boolean correrEstudiante = true;
		while (correrEstudiante) {
		System.out.println("Menu estudiante:");
		System.out.println("1. Registrar Learning Path");
        System.out.println("2. Hacer Actividad");
        System.out.println("3. Salir");
        System.out.print("Elija una opción: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 
        switch(option) {
        case 1: 
        	System.out.println("Aun no ha sido implementado (ver codigo)");
        	break;
        case 2: 
        	System.out.println("Aun no ha sido implementado (ver codigo)");
        	break;

        	
        case 3:
        	
        	break;
        
        case 4:
        	correrEstudiante = false;
        	System.out.println("Chao!");
        	return;
        }
	}
	}
	
	public static void main(String[] args) {
		new Principal(args);
	}
	
}
