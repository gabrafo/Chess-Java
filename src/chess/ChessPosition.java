package chess;

import boardgame.Position;

public class ChessPosition {
    private final char column;
    private final int row;

    public ChessPosition(char column, int row) {
        if(column<'a' || column > 'h' || row<1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        // Método para transformar de posição na matriz p/ posição no tabuleiro

        // Primeira linha da matriz (linha 8 do tabuleiro) é 0,0
        // Coluna a = 0, então 'a' - 'a' = 0, 'b' - 'a' = 1, 'c' - 'a' = 2, etc

        // matrix_row = 8 - chess_row
        // matrix_column = chess_column - 'a'

        return new Position(8-row, column-'a');
    }

    protected static ChessPosition frompPosition(Position position){
        // Método para transformar de posição no tabuleiro p/ posição na matriz

        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + column + row; // String vazio força o interpretador a concatenar os dois valores e não somá-los
    }
}