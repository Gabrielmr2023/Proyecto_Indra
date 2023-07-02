/*
 * Programa:
Nos contrataron de la empresa Spotify para desarrollarles un programa nuevo que conecte con una base de datos.
En lo referido al programa, debe poder almacenar la siguiente información por consola:
- Nombre del artista
- Genero
- Cantidad de canciones
- Cantidad de reproducciones
- Cantidad de suscriptores

Se debe generar 1 función que calcule la ganancia total del artista, la misma se calcula de la siguiente manera: 

 */
public class DatosCantante {
	private String nombre;
	private String genero;
	private int numeroDeCanciones;
	private int numeroDeReproducciones;
	private int numeroDeSuscriptores;

	public DatosCantante(String nombre, String genero, int numeroDeCanciones, int numeroDeReproducciones,
			int numeroDeSuscriptores) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.numeroDeCanciones = numeroDeCanciones;
		this.numeroDeReproducciones = numeroDeReproducciones;
		this.numeroDeSuscriptores = numeroDeSuscriptores;
	}

	public DatosCantante() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumeroDeCanciones() {
		return numeroDeCanciones;
	}

	public void setNumeroDeCanciones(int numeroDeCanciones) {
		this.numeroDeCanciones = numeroDeCanciones;
	}

	public int getNumeroDeReproducciones() {
		return numeroDeReproducciones;
	}

	public void setNumeroDeReproducciones(int numeroDeReproducciones) {
		this.numeroDeReproducciones = numeroDeReproducciones;
	}

	public int getNumeroDeSuscriptores() {
		return numeroDeSuscriptores;
	}

	public void setNumeroDeSuscriptores(int numeroDeSuscriptores) {
		this.numeroDeSuscriptores = numeroDeSuscriptores;
	}

	@Override
	public String toString() {
		return "Nombre del cantante: " + nombre + "\nNumeroDeCanciones: " + numeroDeCanciones
				+ "\nNumeroDeReproducciones: " + numeroDeReproducciones +"\n" ;
	}

}
