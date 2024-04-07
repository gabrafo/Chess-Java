package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

// Coração do sistema de xadrez
public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8,8); // É nessa classe que se diz a dimensão do tabuleiro
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        // É pra retornar a matriz de peças de xadrez da partida
        // O programa principal deverá ter acesso a essa classe e não à classe Piece, dado o desenvolvimento em camadas

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        // Loops fazendo downcasting de Piece para ChessPiece
        // Downcasting: transformar de Piece (super classe) para ChessPiece (sub classe)
        for(int i = 0;i< board.getRows();i++){
            for(int j = 0; j<board.getColumns(); j++){
                mat[i][j] = (ChessPiece)board.piece(i, j);
            }
        }

        // O downcasting (ChessPiece)board.piece(i, j) apenas realiza uma
        // conversão de tipo da referência Piece para ChessPiece. Ele não afeta os dados contidos na instância original.

        // Checar anotação 1.0
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        // Colocar peças informando coordenadas no sistema do xadrez e não a posição da matriz
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){ // Método responsável por iniciar a partida de xadrez, colocando as peças
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
