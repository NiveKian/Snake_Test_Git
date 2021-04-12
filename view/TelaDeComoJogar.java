/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: TelaDeComoJogar
* Funcao: construir o layout da tela de tutorial do programa
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

public class TelaDeComoJogar extends VBox {

  private Image tutorialImage;
  private ImageView tutorialView;
  private Button voltar;

  /* ***************************************************************
  Metodo: TelaDeComoJogar
  Funcao: construir a tela que explica como jogar
  Parametros: void
  Retorno: void
  *************************************************************** */
  public TelaDeComoJogar(){
    // adiciona imagem explicativa
    tutorialImage = new Image("/img/tutorial.png",615,600,true,true);
    tutorialView = new ImageView(tutorialImage);

    // Adiciona botao de voltar para o menu
    this.voltar = new Button("Voltar");
    this.voltar.setOnAction((event) ->{
      ViewControl.mudaCena(0);
    });

    // adicionar
    this.setSpacing(10);
    this.setPadding(new Insets(15,20, 10,10));
    this.getChildren().addAll(voltar,tutorialView);

  }
  
}
