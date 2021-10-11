package oo.jogodavelha;

import java.util.Scanner;

import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;
import oo.jogodavelha.models.Coordenada;
import oo.jogodavelha.models.Jogada;
import oo.jogodavelha.models.Jogo;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {
		Jogo jogo = new Jogo();
		int numeroDeJogadas = 0, coordX, coordY;
		boolean jogoEmExecucao = true;

		jogo.init();
		while (jogoEmExecucao) {
			jogo.printTabuleiro();
			if (numeroDeJogadas % 2 != 0) {
				System.out.println("Turno de X: ");
				System.out.print("Informe a coordenada desejada(X Y): ");
				coordX = scan.nextInt(); coordY = scan.nextInt();
				Jogada novaJogada = new Jogada('X', new Coordenada(coordX, coordY));
				jogo.add(novaJogada);
			} else {
				System.out.println("Turno de O: ");
				System.out.print("Informe a coordenada desejada(X Y): ");
				coordX = scan.nextInt(); coordY = scan.nextInt();
				Jogada novaJogada = new Jogada('O', new Coordenada(coordX, coordY));
				jogo.add(novaJogada);
			}
			numeroDeJogadas++;
			if (jogo.hasWinner()) {
				jogo.printTabuleiro();
				break;
			}
			if (numeroDeJogadas == 9) {
				System.out.println("Empate");
				jogo.printTabuleiro();
				jogoEmExecucao = false;
				break;
			}
		}
	}

}
