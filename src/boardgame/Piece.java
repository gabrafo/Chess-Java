package boardgame;

public abstract class Piece {
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

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position){ // Método concreto que utiliza um método abstrato
        return possibleMoves()[position.getRow()][position.getColumn()]; // Hook method, utiliza as possíveis implementações do método abstrato
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}