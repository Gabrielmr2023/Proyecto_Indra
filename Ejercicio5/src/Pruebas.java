import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class Pruebas {

	private User usuario;
	private EmailValidator objeto;

	@Before
	public void setup() {
		usuario = new User("juan", "hola@gmail.com", 5);
		objeto = new EmailValidator();
	}

	// PRUEBAS UNITARIAS
	//Si se introducen bien los datos, devuelve true, al no estar vacio el correo.
	//siempre y cuando el correo no sea null, pasará la prueba como usuario creado.
	@Test
	public void usuarioCreado() {
		assertFalse(objeto.userCreateManual().correo.isEmpty());
	}

	// PRUEBAS FUNCIONALES DE BORDE

	@Test
	// si se entrega un nulo el sistema debería devolver false
	// prueba de String vacio, falla porque el sistema no está preparado para
	// soportar este ejemplo de borde
	public void testStringConVacios() {
		@SuppressWarnings("static-access")
		boolean resultado = EmailValidator.emailEsValido(null);
		assertEquals(false, resultado);
	}
	@Test
	public void creacionUsuarioEdadMaxima()
	{
	
		User resultado = objeto.userCreateAuto("juan","juan@gmail.com",Integer.MAX_VALUE); //Integer.MAX_VALUE es una constante predefinida en Java que representa el valor maximo posible para un tipo de dato entero. 
		
		assertNotNull(resultado);
	}

}
