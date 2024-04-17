package boardgame;

public class Board {
    private final int rows;
    private final int columns;
    private final Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows<1 || columns<1){
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    // Sobrecarga do método acima
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece; // Atribui à matriz de peças uma nova peça posicionada
        piece.position = position; // Posição não é mais nula!
        // Atributo position é livremente acessado por ter sido declarada no mesmo pacote que sua classe.
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        if(!thereIsAPiece(position)){
            return null;
        }
        Piece aux = piece(position);
        aux.position = null; // Peça retirada do tabuleiro por não ter mais posição
        pieces[position.getRow()][position.getColumn()] = null; // Indica que não tem mais peça naquela posição na matriz
        return aux; // Retorna a peça retirada
    }

    private boolean positionExists(int row, int column){ // Método auxiliar
        return row >= 0 && row < rows && column >= 0 && column < columns; // Retorna se a posição pode, de fato, existir
    }

    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null; // Checa se a peça na matriz naquela posição é nulo ou não e retorna true/false
    }
}
