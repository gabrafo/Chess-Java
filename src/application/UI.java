package application;

import chess.ChessPiece;

public class UI {
    public static void printBoard(ChessPiece[][] pieces){
        for(int i = 0; i<pieces.length; i++){
            System.out.print((8-i) + " "); // Imprime os números das linhas
            for(int j=0;j< pieces.length;j++){ // É pieces.length nos dois pois a matriz é quadrada
                printPiece(pieces[i][j]); // Imprime a linha toda
            }
            System.out.println(); // Faz com que passe para a próxima linha depois de imprimir tudo
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printPiece(ChessPiece piece){
        if(piece==null){
            System.out.print("-");
        } else {
            System.out.print(piece);
        }
        System.out.print(" ");
    }
}
