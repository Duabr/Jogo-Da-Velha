package jogo_da_velha;
import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[][] tabuleiro = {
				{' ',' ',' '},
				{' ',' ',' '},
				{' ',' ',' '}
		};
		int turno;
		int linha;
		int coluna;
		char[] jogadores = {'X', 'O'};
		for (int i = 0; i < 10; i++) {
			turno = i%2;
			System.out.printf("  0   1   2\n");
			System.out.printf("0 %s | %s | %s\n", tabuleiro[0][0], tabuleiro[0][1], tabuleiro[0][2]);
			System.out.printf("  --+---+--\n");
			System.out.printf("1 %s | %s | %s\n", tabuleiro[1][0], tabuleiro[1][1], tabuleiro[1][2]);
			System.out.printf("  --+---+--\n");
			System.out.printf("2 %s | %s | %s\n", tabuleiro[2][0], tabuleiro[2][1], tabuleiro[2][2]);
			System.out.printf("Vez do jogador %s;\n", jogadores[turno]);
			do {
				System.out.printf("selecione o número da linha: ");
				linha = scanner.nextInt();
				System.out.printf("selecione o número da coluna: ");
				coluna = scanner.nextInt();
				boolean jogadaInvalida = linha>2 || coluna>2 || tabuleiro[linha][coluna] != ' ';
				if (jogadaInvalida) {
					System.out.println("Jogada Inválida!");
				}
			}while (linha>2 || coluna>2 || tabuleiro[linha][coluna] != ' ');
			tabuleiro[linha][coluna] = jogadores[turno];
			
			boolean tabuleiroCheio = true;
			for (int l = 0; l <=2; l++) {
				for (int c = 0; c<=2; c++) {
					if (tabuleiro[l][c] == ' ') {
						tabuleiroCheio = false; // Tô aqui. Falta consertar a lógica da feature de dar velha
						break;
					}
				}
				if (!tabuleiroCheio) {
					break;
				}
			}
			if (tabuleiroCheio) {
				System.out.println("O jogo deu velha!! Empate!!!!!!!!!!!!!!");
				break;
			}
			
			boolean fimDePartida = false;
			switch (linha) {
			case 0:
				if (tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1] == tabuleiro[0][2] && tabuleiro[0][0] != ' ') {
					System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
					fimDePartida = true;
					break;
				}
			case 1: 
				if (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2] && tabuleiro[1][0] != ' ') {
					System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
					fimDePartida = true;
					break;
				}
			case 2: 
				if (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2] && tabuleiro[2][0] != ' ') {
					System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
					fimDePartida = true;
					break;
				}
			
			}
			switch (coluna) {
			case 0:
				if (tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0] && tabuleiro[0][0] != ' ') {
					System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
					fimDePartida = true;
					break;
				}
			case 1:
				if (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1] && tabuleiro[0][1] != ' ') {
					System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
					fimDePartida = true;
					break;
				}
			case 2:
				if (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2] && tabuleiro[0][2] != ' ') {
					System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
					fimDePartida = true;
					break;
				}
			}
			
			if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ') {
				System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
				fimDePartida = true;
			}
			else if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ') {
				System.out.printf("Jogador %s venceu!!!!!!!!!!!!!!!!!!!\n", jogadores[turno]);
				fimDePartida = true;
			}
			
			if (fimDePartida) {
				break;
			}
		}
		scanner.close();
	};
}
