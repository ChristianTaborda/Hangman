/********************************************************
 * Autor: Christian Camilo Taborda Campiño 1632081-3743 *
 * Título: Principal.java                               *
 * Descripción: Contiene el método main para iniciar el *
 *              programa.                               *
 * Fecha de Creación: 10/02/2017                        *
 * Fecha de última Edición: 10/02/2017                  *
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