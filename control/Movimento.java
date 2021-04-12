/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: Movimento
* Funcao: controlar as variaveis de direcao do jogo
*
* ****************************************************************
*/

package control;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import util.Variaveis;
import util.Variaveis.Dir;

public class Movimento {
  
  /* ***************************************************************
  Metodo: direcao
  Funcao: alterar o estado de direcao da cobra para um novo
  Parametros: KeyEvent key - tecla pressionada
  Retorno: void
  *************************************************************** */
  public static void direcao(KeyEvent key) {

    if (key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP) {
      if(Variaveis.direcao == Dir.baixo) {
        return;
      }else{
        Variaveis.direcao = Variaveis.Dir.cima;
      }
    }
    if (key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) {
      if(Variaveis.direcao == Dir.direita) {
        return;
      }else{
        Variaveis.direcao = Variaveis.Dir.esquerda;
      }
    }
    if (key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) {
      if(Variaveis.direcao == Dir.cima) {
        return;
      }else{
        Variaveis.direcao = Variaveis.Dir.baixo;
      }
    }
    if (key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) {
      if(Variaveis.direcao == Dir.esquerda) {
        return;
      }else{
        Variaveis.direcao = Variaveis.Dir.direita;
      }
    }
    
  }

}
