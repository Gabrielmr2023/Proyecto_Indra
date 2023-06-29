import java.util.Scanner;

public class EmailValidator {
	/*
	 * La clase email validator se ecangar de validar direcciones de correo
	 * electronico El usuario ingresa su email y su edad el metodo principal es
	 * emailEsValido, toma una cadena de texto como entrada y devuelve un boleano
	 * que indica si el correo es valido Escribe untiarias para la clase email
	 * validator que cubra realizar pruebas funcionales de borde para los valores de
	 * edad ingresados 5 users
	 */
	// Devuelve true si es valido
	public static boolean emailEsValido(String email) {
		boolean esValido = false;
		if (!email.isEmpty() && email.contains("@") && (email.endsWith(".com") || email.endsWith(".es"))) {
			esValido = true;
		}

		return esValido;

	}

	// Metodo para crear usuarios de forma manual
	public static User userCreateManual() {
		System.out.println("INGRESANDO USUARIO DE FORMA MANUAL");
		Scanner sc = new Scanner(System.in);
		User user1 = new User();
		System.out.println("Ingrese nombre de usuario");
		user1.nombre = sc.nextLine();
		System.out.println("Ingrado nombre de usuario: "+ user1.nombre);
		System.out.println("Ingrese email de usuario");
		user1.correo = sc.nextLine();
		System.out.println("Ingrado nombre de usuario: "+ user1.correo);
		System.out.println("Ingrese edad de usuario");
		user1.edad = sc.nextInt();
		System.out.println("Ingrado nombre de usuario: "+ user1.edad);
		return user1;
	// Metodo para crear usuarios de forma automatica
	}
	public static User userCreateAuto(String nombre,String correo,int edad) {
		System.out.println("INGRESANDO USUARIO DE FORMA AUTOMATICA");
		Scanner sc = new Scanner(System.in);
		User user1 = new User();
		System.out.println("Ingrado nombre de usuario: "+ nombre);
		user1.nombre = nombre;
		System.out.println("Ingrado email de usuario "+ correo);
		user1.correo = correo;
		System.out.println("Ingrado edad de usuario " +edad);
		user1.edad = edad;
		return user1;

	}

	// creacion de usuarios y comprobación de correos
	public static void main(String[] args) {
		User user1 = new User("Juan", "juan@hotmail.com", 18);
		User user2 = new User("Luis", "luishotmail.com", 19);
		User user3 = new User("Maria", "maria@hotmail.net", 20);
		User user4 = new User("Gustavo", "gavargas@itformacion.com", 21);
		User user5 = new User("Gabriel", "gabrielmarchante@hotmail.com", 4);

		System.out.println(emailEsValido(user1.correo));
		System.out.println(emailEsValido(user2.correo));
		System.out.println(emailEsValido(user3.correo));
		System.out.println(emailEsValido(user4.correo));
		System.out.println(emailEsValido(user5.correo));

	}

}
