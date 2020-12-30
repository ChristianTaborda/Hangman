/********************************************************
 * Autor: Christian Camilo Taborda Campiño 1632081-3743 *
 * Título: Juego.java                                   *
 * Descripción: Contiene el estado del juego y su       *
 *              funcionamiento.                         *
 * Fecha de Creación: 10/02/2017                        *
 * Fecha de última Edición: 10/02/2017                  *
 * ******************************************************
 */

package Hangman;

public class Juego {
	
	//Atributos
	
	private int errores;
	private String frase;
	private boolean[] controlador;
	
	//Métodos
	
	public Juego(String frase){
		errores = 0;
		this.frase = frase;
		controlador = new boolean[frase.length()];
		for(int x=0; x<frase.length(); x++){
			if(frase.charAt(x) == ' '){
				controlador[x] = true;
			}
			else {
				controlador[x] = false;
			}
		}
	}
	
	public int getErrores(){
		return errores;
	}
	
	public String getFrase(){
		return frase;
	}
	
	public boolean getValor(int posicion){
		return controlador[posicion];
	}
	
	//Se encarga de convertir las letras a minúsculas.
	
	public char convertir(char letra){
		if((int)letra >= 65 && (int)letra <= 90){
			letra = (char)((int)letra + 32);
		}
		return letra;
	}
	
	//Indica si una letra está o no dentro de la frase.
	
	public boolean verificar(char letra){
		for(int x=0; x<frase.length(); x++){
			if(convertir(frase.charAt(x)) == convertir(letra)){
				return true;
			}
		}
		return false;
	}
	
	//Actualiza el arreglo que contiene las posiciones para ubicar las letras.
	
	public void reescribir(char letra){
		for(int x=0; x<frase.length(); x++){
			if(convertir(frase.charAt(x)) == convertir(letra)){
				controlador[x] = true;
			}
		}
	}
	
	//Ubica las letras o suma el error al jugar.
	
	public void accionar(char letra){
		if(verificar(letra)){
			reescribir(letra);
		}
		else {
			errores += 1;
		}
	}
	
	//Indica si la frase fue totalmente descubierta.
	
	public boolean revisar(){
		for(int x=0; x<frase.length(); x++){
			if(controlador[x] != true){
				return false;
			}
		}
		return true;
	}
	
	//Indica cuándo terminar el juego.
	
	public boolean parada(){
		if(errores == 10 || revisar()){
			return true;
		}
		else {
			return false;
		}
	}
}
