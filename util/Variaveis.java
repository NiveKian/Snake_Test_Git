/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 00/00/2021 Ultima alteracao: 00/00/2021
* Nome: Variaveis
* Funcao: guardar valores globais do jogo
*
* ****************************************************************
*/

package util;

public class Variaveis {
  // algumas variaveis para usar de forma global
  public static int velocidade = 5;
  public static int corComida = 0;
	public static int largura = 20;
	public static int altura = 20;
	public static int comidaX = 0;
	public static int comidaY = 0;
	public static int tamanhoCantos = 25;
	public static boolean gameOver = false;
  public static Dir direcao = Dir.nulo;

  public enum Dir {
	 	nulo, esquerda, direita, cima, baixo
	}

}
