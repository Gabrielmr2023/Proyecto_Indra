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

public class TestApiPokemon {
	@Test
	public void testJUnit() {
		{
			String pokemonName = "pikachu";

			try {
				URL url = new URL(" https://pokeapi.co/api/v2/pokemon/" + pokemonName);
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

					JSONObject jsonObject = new JSONObject(informacion.toString());
					String nombre = jsonObject.getString("name");
					int order = jsonObject.getInt("order");
					String specie = jsonObject.getJSONObject("species").getString("url");

					System.out.println("El nombre es: " + nombre);
					System.out.println("El order es: " + order);
					System.out.println("La especie es: " + specie);

					sc.close();
					// TIEMPO DE RESPUESTA = 200
					assertEquals(200, tiempoDeRespuesta);
					// TIEMPO DE RESPUESTA >0
					assertTrue(tiempoDeRespuesta > 0);
					// Nombre introducido = nombre encontrado
					assertEquals(pokemonName, nombre);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
	}
}
