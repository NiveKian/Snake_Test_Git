/*
* ***************************************************************
* 
* Autor: Ian Silva Antunes Ramos 
* Matricula: 201810978 
* Inicio: 01/03/2021 Ultima alteracao: 06/03/2021
* Nome: Tela De Jogo
* Funcao: criar a interface do jogo
* 
* ****************************************************************
*/

package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import control.ViewControl;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import util.Variaveis;
import util.Variaveis.Dir;

public class TelaDeJogo extends VBox{
  
  private Canvas c;
  private GraphicsContext gc;
  private List<Canto> cobrinha = new ArrayList<>();
  private Random rand = new Random();
  private int pontos;

  /* ***************************************************************
  Metodo: TelaDeJogo
  Funcao: construir a  tela do jogo
  Parametros: void
  Retorno: void
  *************************************************************** */
  public TelaDeJogo(){
    // adiciona um painel canvas onde vai ser pintado o jogo
    c = new Canvas(Variaveis.largura * Variaveis.tamanhoCantos, Variaveis.altura * Variaveis.tamanhoCantos);
		gc = c.getGraphicsContext2D();

    // adiciona a tela
		this.getChildren().add(c);

    // cria uma nova comida no canvas
    novaComida();

    // cria as partes iniciais da cobrinha
    cobrinha.add(new Canto(Variaveis.largura / 2 ,Variaveis.altura / 2));
    cobrinha.add(new Canto(Variaveis.largura / 2 ,Variaveis.altura / 2));
    cobrinha.add(new Canto(Variaveis.largura / 2 ,Variaveis.altura / 2));

    // timer que simula os frames do jogo , excutando o jogo a cada frame/tick
    new AnimationTimer() {
      long ultimoTick = 0;

      public void handle(long now) {
        if (ultimoTick == 0) {
          ultimoTick = now;
          tick(gc);
          return;
        }

        if (now - ultimoTick > 1000000000 / Variaveis.velocidade) {
          ultimoTick = now;
          tick(gc);
        }
      }

    }.start();

  }

  /* ***************************************************************
  Metodo: tick
  Funcao: realizar as as alteracoes do jogo a cada frame passado
  Parametros: GraphicsContext gc - o contexto grafico onde sera pintado o jogo
  Retorno: void
  *************************************************************** */
  public void tick(GraphicsContext gc) {

    // verifica se o jogador perdeu
    if(Variaveis.gameOver){
      ViewControl.novoJogo();
      ViewControl.mudaCena(3);
			return;
    }

    // realiza o movimento do corpo da cobra pelas posicoes superiores
    for (int i = cobrinha.size() - 1; i >= 1; i--) {
			cobrinha.get(i).x = cobrinha.get(i - 1).x;
			cobrinha.get(i).y = cobrinha.get(i - 1).y;
		}

    // muda a direcao da cobrinha e verifica se aconteceu colisao
    switch (Variaveis.direcao) {
      case cima:
        cobrinha.get(0).y--;
        if (cobrinha.get(0).y < 0) {
          Variaveis.gameOver = true;
        }
        break;
      case baixo:
        cobrinha.get(0).y++;
        if (cobrinha.get(0).y > Variaveis.altura) {
          Variaveis.gameOver = true;
        }
        break;
      case esquerda:
        cobrinha.get(0).x--;
        if (cobrinha.get(0).x < 0) {
          Variaveis.gameOver = true;
        }
        break;
      case direita:
        cobrinha.get(0).x++;
        if (cobrinha.get(0).x > Variaveis.largura) {
          Variaveis.gameOver = true;
        }
        break;
      default:
        break;
    }
  
    // caso a cobra esteja na posicao da comida ela come e fica maior
    if (Variaveis.comidaX == cobrinha.get(0).x && Variaveis.comidaY == cobrinha.get(0).y) {
      cobrinha.add(new Canto(-1, -1));
      novaComida();
    }
  
    // caso a cobra tente "morder" seu propio rabo
    if(Variaveis.direcao != Dir.nulo){
      for (int i = 1; i < cobrinha.size(); i++) {
        if (cobrinha.get(0).x == cobrinha.get(i).x && cobrinha.get(0).y == cobrinha.get(i).y) {
          Variaveis.gameOver = true;
        }
      }
    }
  
    // usa o gc pra pintar o fundo preto no canvas
    gc.setFill(Color.BLACK);
    gc.fillRect(0, 0, Variaveis.largura * Variaveis.tamanhoCantos, Variaveis.altura * Variaveis.tamanhoCantos);
  
    // aumenta a pontuacao
    gc.setFill(Color.WHITE);
    gc.setFont(new Font("", 30));
    gc.fillText("Score: " + pontos, 10, 30);
  
    // seleciona uma nova cor para a comida
    Color cc = Color.WHITE;
  
    switch (Variaveis.corComida) {
      case 0:
        cc = Color.PURPLE;
        break;
      case 1:
        cc = Color.LIGHTBLUE;
        break;
      case 2:
        cc = Color.YELLOW;
        break;
      case 3:
        cc = Color.PINK;
        break;
      case 4:
        cc = Color.ORANGE;
        break;
    }

    // pinta uma bola na posicao da comida com a cor selecionada
    gc.setFill(cc);
    gc.fillOval(Variaveis.comidaX * Variaveis.tamanhoCantos, Variaveis.comidaY * Variaveis.tamanhoCantos, Variaveis.tamanhoCantos, Variaveis.tamanhoCantos);
  
    // pinta a cobrinha no canvas
    for (Canto c : cobrinha) {
      gc.setFill(Color.LIGHTGREEN);
      gc.fillRect(c.x * Variaveis.tamanhoCantos, c.y * Variaveis.tamanhoCantos, Variaveis.tamanhoCantos - 1, Variaveis.tamanhoCantos - 1);
      gc.setFill(Color.GREEN);
      gc.fillRect(c.x * Variaveis.tamanhoCantos, c.y * Variaveis.tamanhoCantos, Variaveis.tamanhoCantos - 2, Variaveis.tamanhoCantos - 2);
  
    }

  }

  /* ***************************************************************
  Metodo: novaComida
  Funcao: criar uma nova comida em uma posicao aleatoria do mapa
  Parametros: void
  Retorno: void
  *************************************************************** */
	public void novaComida() {
		start: while (true) {

      //gera a posicao da nova comida
			Variaveis.comidaX = rand.nextInt(Variaveis.largura);
			Variaveis.comidaY = rand.nextInt(Variaveis.altura);

      //verifica se a comida vai ser gerada na cobra
			for (Canto c : cobrinha) {
				if (c.x == Variaveis.comidaX && c.y == Variaveis.comidaY) {
					continue start;
				}
			}
      // gera uma nova cor e aumenta a velocidade
			Variaveis.corComida = rand.nextInt(5);
			Variaveis.velocidade++;
			break;

		}
	}

  /* ***************************************************************
  Metodo: resetaJogo
  Funcao: restaurar o jogo ao ser estado inicial
  Parametros: void
  Retorno: void
  *************************************************************** */
  public void resetaJogo(){
    // retorna as variaveis do jogo a seus valores base
    Variaveis.gameOver = false;
    Variaveis.velocidade = 5;
    Variaveis.direcao = Dir.nulo;
    pontos = 0;
    // cria uma nova cobrinha
    cobrinha.clear();
    cobrinha.add(new Canto(Variaveis.largura / 2 ,Variaveis.altura / 2));
    cobrinha.add(new Canto(Variaveis.largura / 2 ,Variaveis.altura / 2));
    cobrinha.add(new Canto(Variaveis.largura / 2 ,Variaveis.altura / 2));

  }
  
}
