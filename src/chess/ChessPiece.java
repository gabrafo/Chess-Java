package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // Color não tem set porque não é pra poder ser alterada
    public Color getColor() {
        return color;
    }
}