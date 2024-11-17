package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Logica.Estudiante;
import Logica.Usuario;


public class UsuarioTest {
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		this.usuario = new Estudiante("Usuario.1", "123", "usuario.1@gmail.com", "UsuarioNombre", "UsuarioApellido");
		//this.usuario = new Estudiante("Estudiante", "987", "estudiante.1@gmail.com", "Daniel", "Sánchez");
	}
	
	@Test
	public void logInExitoso() throws Exception{
		String respuesta = usuario.login("Usuario.1", "123");
		assertEquals("Inicio de sesión exitoso.", respuesta);
	}
	
	@Test
	public void logInFallido() throws Exception{
		String respuesta = usuario.login("Usuario.1", "abc");
		assertEquals("Usuario o contraseña incorrectas.", respuesta);
	}
	
	@Test
	public void logoutExitoso() throws Exception{
		String respuesta = usuario.logout();
		assertEquals("Sesión cerrada.", respuesta);
	}
	
	
}
