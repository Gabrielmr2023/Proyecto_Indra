package paquete;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

@SuppressWarnings("unused")
public class API {
	@Test
	public void testAppiConnection() {
		try {
			URL url = new URL(
					"https://api.open-meteo.com/v1/forecast?latitude=40.42&longitude=-3.70&hourly=temperature_2m&forecast_days=1&start_date=2023-06-27&end_date=2023-06-27");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int tiempoDeRespuesta = conn.getResponseCode();

			if (tiempoDeRespuesta != 200) {
				throw new RuntimeException("HTTPSResponseCode: " + tiempoDeRespuesta);
			} else {
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					informacion.append(sc.nextLine());
				}
				System.out.println(informacion);
				JSONObject jsonObject = new JSONObject(informacion.toString());
				BigDecimal latitude = jsonObject.getBigDecimal("latitude");
				BigDecimal longitude = jsonObject.getBigDecimal("longitude");
				System.out.println("La latitud es: " + latitude);
				System.out.println("La longitud es: " + longitude);
				sc.close();
				assertEquals(200, tiempoDeRespuesta);
				assertTrue(informacion.length() > 0);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * JUnit es un framework de pruebas unitarias para Java. Proporciona un conjunto
	 * de bibliotecas y anotaciones que facilitan la escritura, ejecución y
	 * verificación de pruebas automatizadas a nivel unitario. Las pruebas unitarias
	 * son pequeñas pruebas AUTOMATIZADAS que verifican el comportamiento de una
	 * unidad de codigo (como por ejemplo, un metodo, una clase) de forma aislada,
	 * sin depender de otros componentes o sistemas externos. Estas pruebas se
	 * centran en probar unidades especificas de codigo de manera exhaustiva,
	 * buscando errores y asegurando que el codigo cumpla con los requisitos.
	 * Aserciones: Las aserciones son expresiones que se utilizan para verificar si
	 * un resultado esperado es verdadero o falso. Tambien se lo conoce como una
	 * afirmación o afirmación de prueba. En el contexto de JUnit, las aserciones
	 * son metodos estaticos proporcionados por la biblioteca que te permitiran
	 * comparar valores y evaluar condiciones dentro de tus pruebas. Ejemplos de
	 * aserciones: assertEquals(expected, actual): Compara dos valores para verifiar
	 * si son iguales o no. Si son iguales, la prueba no falla, si no son iguales,
	 * la prueba falla. assertTrue(Condicion): Verifica si una condicion es
	 * verdadera. Si la condición no es verdadera, la prueba falla
	 * assertFalse(Condicion): Verifica si una condicion es falsa. Si la condicion
	 * es verdadera, la prueba falla. assertNull(object): Verifica si un objeto es
	 * nulo. Si el objeto no es nulo, la prueba falla. assertNotNull(object):
	 * Verifica si un objecto no es nulo. Si el objeto es nulo, la prueba falla.
	 * 
	 */
}