/*
 * Ganancia total = cantidad de reproducciones * 0.02 
(!)  Generarlo para al menos 3 artistas (!)
La información se debe imprimir en un TXT de salida. 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Spotify {

	public static double gananciaTotal(DatosCantante datos) {
		double total = 0;
		total = datos.getNumeroDeReproducciones() * 0.02;
		return total;
	}

	public static List<DatosCantante> recogidaDatos() {
		List<DatosCantante> cantantes = new ArrayList<DatosCantante>();

		Connection conn = null;
		String dbServer = "mssql-133676-0.cloudclusters.net";
		int dbPort = 16840;
		String dbName = "Ejercicio8";
		String userName = "Gabriel";
		String password = "gustavoCrack31";
		String url = String.format(
				"jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;trustServerCertificate=true", dbServer,
				dbPort, dbName, userName, password);
		try {

			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			String sql = "SELECT  Artista.Nombre, SUM(Cancion.Numero_De_Reproducciones), COUNT(Cancion.ID_USUARIO)\r\n" + "FROM Cancion \r\n"
					+ "INNER JOIN Artista  \r\n" + "ON Artista.ID_USUARIO = Cancion.ID_USUARIO\r\n"
					+ "GROUP BY Nombre ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DatosCantante datos = new DatosCantante();
				String nombre = rs.getObject(1).toString();
				int reproducciones = Integer.parseInt(rs.getObject(2).toString());
				int numeroCanciones = Integer.parseInt(rs.getObject(3).toString());		
				datos.setNombre(nombre);
				datos.setNumeroDeReproducciones(reproducciones);
				datos.setNumeroDeCanciones(numeroCanciones);
				cantantes.add(datos);

				
				// Person table has name and gender column

			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantantes;

	}

	public static String resultado(List<DatosCantante> datos) {
		String resultado = "--- INICIO DEL DOCUMENTO --- \n \nSe van a tratar los siguientes cantantes: \n";

		for (DatosCantante data : datos) {
			
			resultado = resultado + data.getNombre()+" ";
		}
		resultado = resultado + "\n \nA continuacion devolveremos la informacion para cada cantante: \n";
		for (DatosCantante data : datos) {
			resultado = resultado + data.toString() ;
			resultado = resultado + "- Las ganancias totales : " + gananciaTotal(data) + "€\n\n";
		}
		resultado = resultado + "--- FIN DEL DOCUMENTO ---";
		System.out.println(resultado);
		return resultado;
		
	}
	
	public static void imprimirResultados(String texto) {

		try {
			String ruta = "C:\\Users\\Gabriel.MARCHANTE-RO\\eclipse-workspace\\Ejercicio8\\Datos_cantantes.txt";
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
	
	public static void main(String[] args) {
		imprimirResultados(resultado(recogidaDatos()));
	}
}
