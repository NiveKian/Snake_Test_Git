/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: ViewControl
* Funcao: fazer o controle das cenas apresentadas na janela principal
*
* ****************************************************************
*/

package control;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import util.Variaveis;
import view.TelaDeComoJogar;
import view.TelaDeInicio;
import view.TelaDeJogo;
import view.TelaGameOver;

public class ViewControl {

  private static Stage janela;
  private TelaDeInicio layoutDeInicio;
  private TelaDeComoJogar layoutComoJogar;
  private static TelaDeJogo layoutDeJogo;
  private TelaGameOver layoutGameOver;
  private static Scene inicio, comoJogo, jogo, fimDeJogo;

  /* ***************************************************************
  Metodo: ViewControl
  Funcao: armazenar todos os estados de tela e controlar as suas aparicoes
  Parametros: Stage janela - a janela onde as cenas serao apresentadas
  Retorno: void
  *************************************************************** */
  public ViewControl(Stage janela) {

    // salva a janela como referencia
    ViewControl.janela = janela;

    // cria as interfaces
    layoutDeInicio = new TelaDeInicio();
    layoutComoJogar = new TelaDeComoJogar();
    layoutGameOver = new TelaGameOver();
    layoutDeJogo = new TelaDeJogo();

    inicio = new Scene(layoutDeInicio, 500, 300);
    inicio.getStylesheets().add("view/DarkTheme.css");

    comoJogo = new Scene(layoutComoJogar, 565, 650);
    comoJogo.getStylesheets().add("view/DarkTheme.css");

    fimDeJogo = new Scene(layoutGameOver, 450, 315);
    fimDeJogo.getStylesheets().add("view/DarkTheme.css");

    jogo = new Scene(layoutDeJogo, Variaveis.largura * Variaveis.tamanhoCantos,
        Variaveis.altura * Variaveis.tamanhoCantos);
    jogo.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
      Movimento.direcao(key);
    });

  }

  /* ***************************************************************
  Metodo: novoJogo
  Funcao: chamar a funcao resetaJogo no layout de jogo
  Parametros: void
  Retorno: void
  *************************************************************** */
  public static void novoJogo() {

    // precisa resetar o layout e adicionar ao jogo
    layoutDeJogo.resetaJogo();

  }

  /* ***************************************************************
  Metodo: mudaCena
  Funcao: alterar a cena apresentada na janela
  Parametros: int cenaNova - valor corespondente a cena a ser apresentada
  Retorno: void
  *************************************************************** */
  public static void mudaCena(int cenaNova) {

    switch (cenaNova) {
      case 0:
        janela.setScene(inicio);
        break;
      case 1:
        janela.setScene(comoJogo);
        break;
      case 2:
        janela.setScene(jogo);
        break;
      case 3:
        janela.setScene(fimDeJogo);
        break;
    }

  }
  
}
