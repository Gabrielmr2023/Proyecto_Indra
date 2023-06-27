package paquete;

import org.json.*;

public class JSON {
	public static void main(String args[]) {
		JSONObject objeto = new JSONObject();
		JSONArray arrayJson = new JSONArray();
		objeto.put("nombre", "Gustavo");
		objeto.put("edad", "31");
		arrayJson.put(objeto);
		String stringJson = objeto.toString();
		System.out.println(objeto);
		System.out.println(arrayJson);
		System.out.println(stringJson);
		System.out.println("------ SALTO DE LINEA ---- \n");
		String cadenaDeCaracteres = "{\"nombre\":\"edad}";
		System.out.println(cadenaDeCaracteres);
		/*
		 * JSONObject json_objeto = new JSONObject(cadenaDeCaracteres); String nombre =
		 * json_objeto.getString("nombre"); String edad = json_objeto.getString("edad");
		 * System.out.println(json_objeto); System.out.println(nombre);
		 * System.out.println(edad);
		 */
		/////////////////////// CREAR UN JSON ///////////
		JSONObject persona = new JSONObject();
		persona.put("nombre", "Maria");
		persona.put("apellido", "perez");
		persona.put("edad", "30");

		JSONObject direccion = new JSONObject();
		direccion.put("Calle", "calle falsa");
		persona.put("direccion", direccion);
		System.out.println("La direccion de la persona" + persona);
	}
}
