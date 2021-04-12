/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: TelaDeInicio
* Funcao: construir o layout da tela inicial do programa
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

public class TelaDeInicio extends VBox {

  private Image cobraImagem;
  private ImageView cobraView;
  private Button iniciarJogo,comoJogar;

  /* ***************************************************************
  Metodo: TelaDeInicio
  Funcao: construir a tela inicial do programa
  Parametros: void
  Retorno: void
  *************************************************************** */
  public TelaDeInicio(){
    // INICIAR IMAGENS
    cobraImagem = new Image("/img/cobrinha.png",457,157,true,true);
    cobraView = new ImageView(cobraImagem);

    // BOTAO DE INICIAR O JOGO
    this.iniciarJogo = new Button("Jogar");
    this.iniciarJogo.setPrefSize(130,20);
    this.iniciarJogo.setOnAction((event) ->{
      ViewControl.mudaCena(2);
    });

    // BOTAO DE TROCAR A CENA
    this.comoJogar = new Button("Como Jogar");
    this.comoJogar.setPrefSize(130,20);
    this.comoJogar.setOnAction((event) ->{
      ViewControl.mudaCena(1);
    });

    // ADICIONAR

    this.setSpacing(10);
    this.setPadding(new Insets(15,20, 10,10));
    this.getChildren().addAll(cobraView,comoJogar,iniciarJogo);

    // AJUSTE
    VBox.setMargin(comoJogar, new Insets(0, 0, 0, 155));
    VBox.setMargin(iniciarJogo, new Insets(0, 0, 0, 155));

  }

}