package chess;

import boardgame.Board;
import boardgame.Position;
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

    private void initialSetup(){ // Método responsável por iniciar a partida de xadrez, colocando as peças
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
    }
}
