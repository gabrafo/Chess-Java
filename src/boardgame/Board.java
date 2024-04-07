package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column){
        return pieces[row][column];
    }

    // Sobrecarga do método acima
    public Piece piece(Position position){
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece; // Atribui à matriz de peças uma nova peça posicionada
        piece.position = position; // Posição não é mais nula!
        // Atributo position é livremente acessado por ter sido declarada no mesmo pacote que sua classe.
    }
}
