/********************************************************
 * Autor: Christian Camilo Taborda Campiño 1632081-3743 *
 * Título: Visual.java                                  *
 * Descripción: Contiene la representación del juego en *
 *              la consola.                             *
 * Fecha de Creación: 10/02/2017                        *
 * Fecha de última Edición: 10/02/2017                  *
 * ******************************************************
 */

package Hangman;

import java.util.Scanner;

public class Visual {
	
	//Atributos
	
	private Juego partida;
	private char letra;
	private String lectura;
	Scanner entrada;
	
	//Métodos
	
	public Visual(String frase){
		partida = new Juego(frase);
		entrada = new Scanner(System.in);
	}
	
	//Se encarga de dibujar el arte del juego.
	
	public void dibujar(){
		switch(partida.getErrores()){
			case 1:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |\n  |\n  |\n  |\n__|__\n");
				break;
			case 2:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |   /\n  |\n  |\n  |\n__|__\n");
				break;
			case 3:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |   / \\\n  |\n  |\n  |\n__|__\n");
				break;
			case 4:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |   /|\\\n  |\n  |\n  |\n__|__\n");
				break;
			case 5:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |  _/|\\\n  |\n  |\n  |\n__|__\n");
				break;
			case 6:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |  _/|\\_\n  |\n  |\n  |\n__|__\n");
				break;
			case 7:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |  _/|\\_\n  |  _/\n  |\n  |\n__|__\n");
				break;
			case 8:
				System.out.printf("\n  ______\n  |    |\n  |  (   )\n  |  _/|\\_\n  |  _/ \\_\n  |\n  |\n__|__\n");
				break;
			case 9:
				System.out.printf("\n  ______\n  |    |\n  |  (x  )\n  |  _/|\\_\n  |  _/ \\_\n  |\n  |\n__|__\n");
				break;
			case 10:
				System.out.printf("\n  ______\n  |    |\n  |  (x x)\n  |  _/|\\_\n  |  _/ \\_\n  |\n  |\n__|__\n");
				break;
			default:
				System.out.printf("\n  ______\n  |    |\n  |\n  |\n  |\n  |\n  |\n__|__\n");
				break;
		}
	}
	
	//Se encarga de dibujar las letras o casillas vacías de la frase.
	
	public void escribir(){
		for(int x=0; x<(partida.getFrase()).length(); x++){
			if(partida.getFrase().charAt(x) == ' '){
				System.out.printf("\t");
			}
			else {
				if(partida.getValor(x)){
					System.out.printf(" %c ", partida.getFrase().charAt(x));
				}
				else {
					System.out.printf(" __ ");
				}
			}
		}
		System.out.printf("\n\n");
	}
	
	//Se encarga de inicializar el juego.
	
	public void jugar(){
		do {
			
			System.out.printf("\n-------- HANGMAN --------\n");
			dibujar();
			System.out.printf("\n  Errores:  %d  \n\n", partida.getErrores());
			escribir();
			System.out.printf("Ingrese una letra: \n");
			lectura = entrada.nextLine();
			letra = lectura.charAt(0);
			partida.accionar(letra);
			
		} while(!partida.parada());
		
		//Aquí se dibuja el estado final del juego.
		
		System.out.printf("\n-------- HANGMAN --------\n");
		dibujar();
		System.out.printf("\n  Errores:  %d  \n\n", partida.getErrores());
		escribir();
		System.out.printf("\nTerminó el juego!!\n");
		if(partida.getErrores() == 10){
			System.out.printf("\nPerdiste!!\n");
		}
		else {
			System.out.printf("\nGanaste!!\n");
		}
	}		
}
