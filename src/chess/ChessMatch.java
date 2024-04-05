package chess;

import boardgame.Board;

// Coração do sistema de xadrez
public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8,8); // É nessa classe que se diz a dimensão do tabuleiro
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

        /*
        Durante o downcasting de uma instância de Piece para ChessPiece usando (ChessPiece)board.piece(i, j),
        o construtor padrão implícito de ChessPiece é invocado para inicializar a instância resultante.
        Esse construtor implícito não modifica os valores dos campos herdados de Piece, como as posições (row e column),
        a menos que esses campos sejam explicitamente definidos na classe ChessPiece.

        Portanto, ao realizar o downcasting, as instâncias de ChessPiece na matriz mat serão inicializadas com os valores padrão
        dos campos herdados de Piece. Isso significa que os campos row e column não serão afetados durante o downcasting,
        enquanto o campo color será inicializado como null. Além disso, a posição dessa instância na matriz será [i][j].

        Ao realizar o downcasting de um objeto Piece para um objeto ChessPiece usando (ChessPiece)board.piece(i, j),
        não há uma mudança direta do objeto Piece para ChessPiece. Em vez disso, há a obtenção de uma referência de ChessPiece
        para o mesmo objeto Piece original. Isso significa que o objeto Piece original não é alterado diretamente. O construtor
        padrão implícito de ChessPiece é chamado para inicializar uma nova instância de ChessPiece com base no objeto
        Piece original. Essa nova instância de ChessPiece é então atribuída à matriz mat na posição (i, j), mantendo a referência
        ao mesmo objeto Piece original, mas agora como um objeto ChessPiece.
        */
        return mat;
    }
}
