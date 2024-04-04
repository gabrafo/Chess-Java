package boardgame;

public class Piece {
    // Relembrando, protected: apenas classes do mesmo pacote ou subclasses de Piece poderão interagir com o atributo.
    protected Position position; // É uma posição simples de matriz, portanto não deve ser visível às outras classes
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
