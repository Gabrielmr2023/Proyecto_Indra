import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Actividades {
	// busca una actividad en el json y te devuelve un string
	public static String buscarActividad() {
		String actividad = "";

		try {
			URL url = new URL("http://www.boredapi.com/api/activity");
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
				actividad = jsonObject.getString("activity");

				sc.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return actividad;
	}

	// imprime la actividad en donde se indique en el fichero
	public static void imprimirActividades(String texto) {

		try {
			String ruta = "C:\\Users\\Gabriel.MARCHANTE-RO\\eclipse-workspace\\MiniTest\\recomendacion_hoy.txt";
			String contenido = texto;
			File archivo = new File(ruta);
			// Si el archivo no existe es creado
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// utiliza imprimir un numero definido de veces
	public static void crearListaActividades(int num) {
		String textofinal = "";
		for (int i = 0; i < num; i++) {
			textofinal = textofinal + ("Actividad " + (i + 1) + " " + buscarActividad() + "\n");

		}
		imprimirActividades(textofinal);
	}

	public static void main(String[] args) {
		int numeroDeActividades = 10;

		crearListaActividades(numeroDeActividades);

	}

}
