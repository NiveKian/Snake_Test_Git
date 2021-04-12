/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: Tela Game Over
* Funcao: Construir layout da tela apresentada quando o jogo acaba
*
* ****************************************************************
*/

package view;

import control.ViewControl;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class TelaGameOver extends VBox {

  private Image gameOverImage;
  private ImageView gameOverView;
  private Button tenteDeNovo;

  /* ***************************************************************
  Metodo: TelaGameOver
  Funcao: construtor da tela game over
  Parametros: void
  Retorno: void
  *************************************************************** */
  public TelaGameOver() {
    // imagem de fim de jogo
    gameOverImage = new Image("/img/gameover.png",365,67,true,true);
    gameOverView = new ImageView(gameOverImage);

    // butao de tentar de novo
    this.tenteDeNovo = new Button("Tente De Novo");
    tenteDeNovo.setPrefSize(170,45);
    this.tenteDeNovo.setOnAction((event) -> {
      ViewControl.mudaCena(2);
    });

    // adicionar
    this.setSpacing(10);
    this.setPadding(new Insets(15,20, 10,10));
    this.getChildren().addAll(gameOverView,tenteDeNovo);

    // ajuste
    VBox.setMargin(gameOverView, new Insets(0, 0, 0, 30));
    VBox.setMargin(tenteDeNovo, new Insets(50, 0, 0, 115));

  }
  
}
