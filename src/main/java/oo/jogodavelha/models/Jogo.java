package oo.jogodavelha.models;

import java.util.ArrayList;
import java.util.List;

import oo.jogodavelha.exceptions.ExcecaoPorCoordenadaInvalida;
import oo.jogodavelha.exceptions.ExcecaoPorSimboloInvalido;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Character historicoMarcas[] = new Character[10];
    private List<Coordenada> historicoJogadas = new ArrayList<Coordenada>();
    private int contador;

    private Character tabChar[][] = new Character[3][3];

    public void criarTabChar() {
        int x, y;
        for (x = 0; x < 3; x++) {
            for (y = 0; y < 3; y++) {
                tabChar[y][x] = ' ';
            }
            System.out.println("");
        }
    }

    public void init() {
        this.tabuleiro = new Tabuleiro();
        this.contador++;
        criarTabChar();
    }

    public void add(Jogada jogada) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido {
        if (check(jogada)) {
            this.tabuleiro.marcaTabuleiroMap(jogada.getCoordenada(), jogada.getMarca());
            this.historicoMarcas[contador] = jogada.getMarca();
            this.historicoJogadas.add(jogada.getCoordenada());
            this.tabChar[jogada.getCoordenada().getCoordenadaX()][jogada.getCoordenada().getCoordenadaY()] = jogada.getMarca();
        }
    }

    public Tabuleiro getBoard() {
        return this.tabuleiro;
    }

    public void printTabuleiro() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print("|"+this.tabChar[y][x]+"|");
            }
            System.out.println("");
        }
    }

    public boolean check(Jogada umaJogada) throws ExcecaoPorCoordenadaInvalida, ExcecaoPorSimboloInvalido{
        int coordX = umaJogada.getCoordenada().getCoordenadaX();
        int coordY = umaJogada.getCoordenada().getCoordenadaY();


        if (coordX > 2 || coordX < 0 || coordY > 2 || coordY < 0) {
            throw new ExcecaoPorCoordenadaInvalida("A posição passada esta fora do tabuleiro (Informe um valor entre 0 e 2)");
        } else if (!verificaPosicao(coordX, coordY)) {
            throw new ExcecaoPorCoordenadaInvalida("Esta coordenada encontra-se ocupado por outra marca");
        } else if (!jogandoDuasVezesSeguidas(umaJogada)) {
            throw new ExcecaoPorSimboloInvalido("Voce esta tentando jogar duas vezes seguidas");
        }
        return true;
    }

    public boolean verificaPosicao(int x, int y) throws ExcecaoPorCoordenadaInvalida {
        if (this.tabChar[x][y].equals('X') || this.tabChar[x][y].equals('O')) {
            return false;
        } else {
            return true;
        }
    }

    public boolean jogandoDuasVezesSeguidas(Jogada jogada) throws ExcecaoPorSimboloInvalido {
        if (!jogada.getMarca().equals(historicoMarcas[contador])) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasWinner() {
        int contador2;
        Character ultimaJogada = historicoMarcas[this.contador];

        for (contador2 = 0; contador2 <= 2; contador2++) {
            if (tabChar[contador2][0].equals(ultimaJogada) && tabChar[contador2][1].equals(ultimaJogada) && tabChar[contador2][2].equals(ultimaJogada)) {    
                System.out.println("Vencedor: "+ ultimaJogada);
                return true;
            }
        }

        for (contador2 = 0; contador2 <= 2; contador2++) {
            if (tabChar[0][contador2].equals(ultimaJogada) && tabChar[1][contador2].equals(ultimaJogada) && tabChar[2][contador2].equals(ultimaJogada)) {    
                System.out.println("Vencedor: "+ ultimaJogada);
                return true;
            }
        }

        if (tabChar[2][0].equals(ultimaJogada) && tabChar[1][1].equals(ultimaJogada) && tabChar[0][2].equals(ultimaJogada)) {
            System.out.println("Vencedor: "+ ultimaJogada);
            return true;
        }else if (tabChar[0][0].equals(ultimaJogada) && tabChar[1][1].equals(ultimaJogada) && tabChar[2][2].equals(ultimaJogada)) {
            System.out.println("Vencedor: "+ ultimaJogada);
            return true;
        }
        return false;
    }
}