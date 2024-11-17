package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Logica.Usuario;


public class UsuarioTest {
	
	private Usuario usuario;
	
	@BeforeEach
	public void setUp() {
		this.usuario = new Usuario("Usuario.1", "123", "usuario.1@gmail.com", "UsuarioNombre", "UsuarioApellido");
	}
	
	@Test
	public void logInExitoso() throws Exception{
		String respuesta = usuario.login("Usuario.1", "123");
		assertEquals("Inicio de sesión exitoso.", respuesta);
	}
	
	@Test
	public void logInFallido() throws Exception{
		String respuesta = usuario.login("Usuario.1", "abc");
		assertEquals("Inicio de sesión fallido. Usuario o contraseña incorrectos", respuesta);
	}
	
	@Test
	public void logoutExitos() throws Exception{
		String respuesta = usuario.logout();
		assertEquals("Sesión finalizada con éxito.", respuesta);
	}
	
	
}
