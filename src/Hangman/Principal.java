/********************************************************
 * Autor: Christian Camilo Taborda Campi�o 1632081-3743 *
 * T�tulo: Principal.java                               *
 * Descripci�n: Contiene el m�todo main para iniciar el *
 *              programa.                               *
 * Fecha de Creaci�n: 10/02/2017                        *
 * Fecha de �ltima Edici�n: 10/02/2017                  *
 * ******************************************************
 */

package Hangman;

public class Principal {

	public static void main(String[] args) {
		
		//El juego funciona con cualquier frase que se desee.
		
		Visual consola = new Visual("Programacion Interactiva Univalle");
		consola.jugar();
	}
}