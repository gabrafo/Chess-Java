package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

// Coração do sistema de xadrez
public class ChessMatch {
    private int turn;
    private Color currentPlayer;
    private final Board board;

    public ChessMatch() {
        board = new Board(8,8); // É nessa classe que se diz a dimensão do tabuleiro
        turn = 1;
        currentPlayer = Color.WHITE;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition(); // Transforma em valor da matriz
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
        if(currentPlayer!=((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){ // Checa se não é possível para a peça de origem a posição de destino
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        // Colocar peças informando coordenadas no sistema do xadrez e não a posição da matriz
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){ // Método responsável por iniciar a partida de xadrez, colocando as peças
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
