import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class pruebaUnitariaMiniTest {
	@Test
	public void validacionConexion() {
		//al no saltar la excepcion, significa que se conectó bien a la api
		assertDoesNotThrow(()-> Actividades.buscarActividad());
	}
	
	@Test
	public void validacionConexion2() {
		//si se devuelve algo mas que "" significa que se ha escrito y que se conectó bien a la api
		String comillas = "";
		assertNotEquals(Actividades.buscarActividad(), comillas);
	}
}
