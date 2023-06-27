package Calculos;

import java.util.Scanner;

public class Calculadora {

	
	public static void main(String[] args) {
		/*
		 * Ejecucion de una calculadora en base a dos valores introducidos por el usuario
		 */

		System.out.println(
				"Calculadora lista, que operación desea realizar: \n1.- Suma \n2.- Resta \n3.- Multiplicación \n4.- División");
		Scanner sc = new Scanner(System.in);
		int x;
		/*
		 * El usuario debe insertar un valor comprendido entre 1 y el 4
		 * en caso contrario se le devuelve la peticion
		 */
		do {
			System.out.println("Por favor introduzca un numero entre el 1 y el 4)");
			x = sc.nextInt();
		} while (x < 1 || x > 4);
		/*
		 * 1 SUMA
		 * 2 RESTA
		 * 3 MULTIPLICACION
		 * 4 DIVISION
		 */

		switch (x) {
		case 1:
			/*
			 * SUMA, se le piden dos valores y se suman
			 */
			int a, b, c;
			System.out.println("---SUMAR---");
			System.out.println("Introduzca valor 1:\n");
			a = sc.nextInt();
			System.out.println("Introduzca valor 2:\n");
			b = sc.nextInt();
			c = a + b;
			System.out.println("Resultado: " + c);
			break;
		case 2:
			/*
			 * RESTA, se le piden dos valores y se resta el segundo valor introducido 
			 */
			int d, e, f;
			System.out.println("---RESTAR---");
			System.out.println("Introduzca valor 1:\n");
			d = sc.nextInt();
			System.out.println("Introduzca valor 2:\n");
			e = sc.nextInt();
			f = d - e;
			System.out.println("Resultado: " + f);
			break;
		case 3:
			/*
			 * MULTIPLICACION, se piden dos valores y se multiplican
			 */
			int g, h, i;
			System.out.println("---MULTIPLICAR---");
			System.out.println("Introduzca valor 1:\n");
			g = sc.nextInt();
			System.out.println("Introduzca valor 2:\n");
			h = sc.nextInt();
			i = g * h;
			System.out.println("Resultado: " + i);
			break;
		case 4:
			/*
			 * DIVISION,se piden dos valores y el segundo valor divide al primero
			 * en caso de que el segundo valor valga 0, se le vuelve a solicitar ese segundo valor
			 */
			double j, k;
			double l;
			System.out.println("---DIVIDIR---");

			System.out.println("Introduzca dividendo:\n");
			j = sc.nextInt();
			System.out.println("Introduzca divisor:\n");

			k = sc.nextInt();
			while (k == 0) {
				System.out.println("Introduzca divisor distinto de 0:\n");

				k = sc.nextInt();
			}
			l = j / k;
			System.out.println("Resultado: " + l);
			break;
		

		}
	}

}
