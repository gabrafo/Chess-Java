package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(true) {
            try {
                UI.clearScreen(); // Limpa a tela a cada execução do loop (só funciona em terminais)
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece!=null){ // Se houver uma peça capturada, a adiciona à lista de peças capturadas
                    captured.add(capturedPiece);
                }
            } catch(ChessException | InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine(); // Aguardar o usuário apertar enter
            }
        }

    }
}