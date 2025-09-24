import java.util.Scanner;

public class JogoDaVelha {
    static char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char jogadorAtual = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean jogarNovamente = true;
        while (jogarNovamente) {
            // Reinicia o tabuleiro
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tabuleiro[i][j] = ' ';
                }
            }
            jogadorAtual = 'X';
            boolean jogoAtivo = true;

            System.out.println("=== JOGO DA VELHA ===");

            while (jogoAtivo) {
                mostrarTabuleiro();
                System.out.println("Jogador " + jogadorAtual + ", escolha uma linha (0-2): ");
                int linha = scanner.nextInt();
                System.out.println("Jogador " + jogadorAtual + ", escolha uma coluna (0-2): ");
                int coluna = scanner.nextInt();

                if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
                    System.out.println("Posição inválida. Tente novamente.");
                    continue;
                }

                tabuleiro[linha][coluna] = jogadorAtual;

                if (verificarVitoria()) {
                    mostrarTabuleiro();
                    System.out.println("Jogador " + jogadorAtual + " venceu!");
                    jogoAtivo = false;
                } else if (verificarEmpate()) {
                    mostrarTabuleiro();
                    System.out.println("Empate!");
                    jogoAtivo = false;
                } else {
                    jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                }
            }

            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) {
                jogarNovamente = false;
            }
        }

        scanner.close();
    }

    static void mostrarTabuleiro() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    static boolean verificarVitoria() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogadorAtual && tabuleiro[1][j] == jogadorAtual && tabuleiro[2][j] == jogadorAtual) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }

        return false;
    }

    static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
