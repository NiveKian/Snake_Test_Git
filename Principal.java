/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: Jogo Da Cobrinha
* Funcao: versão simplificada do famoso jogo da cobrinha
*
* ****************************************************************
*/

import control.ViewControl;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import view.TelaDeInicio;

public class Principal extends Application {

  private Image icone;
  private Scene cenaPrincipal;
  private TelaDeInicio layout;
  public ViewControl controlador;
  public Stage janela;

  @Override
	public void start(Stage palcoPrincipal) throws Exception {

    janela = palcoPrincipal;

    /*
    * INICIALIZA A CENA
    */
    layout = new TelaDeInicio();
    cenaPrincipal = new Scene(layout,500,300);
    cenaPrincipal.getStylesheets().add("view/DarkTheme.css");

    /*
    * CONTROLE
    */
    controlador = new ViewControl(janela);

    /*
    * INICIALIZA A INTERFACE
    */
    icone = new Image("/img/FeelsGoodMan.png");
    janela.setTitle("Jogo Cobrinha");
    janela.getIcons().add(icone);
    janela.setScene(cenaPrincipal);
    janela.setResizable(false);
    janela.sizeToScene();
    janela.show();

    /*********************************************
    * Metodo: setOnCloseRequest
    * Funcao: Finaliza o programa por completo ao Fechar
    * Parametros: EventHandler
    * Retorno: void
    *********************************************/
    palcoPrincipal.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent t) {
        t.consume();
        janela.close();
        System.exit(0);
      }
    });

  }

  public static void main(String[] args) {
    launch(args);
  }

}