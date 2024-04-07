
# Anotações

Esse arquivo servirá para guardar as coisas que desejo destacar durante o meu aprendizado no projeto.

### 1.0 Como funciona o *downcasting* de Piece na função getPieces()

Essa foi uma dúvida que surgiu enquanto assistia o curso, visto que em Board, onde o objeto Piece é passado em forma de atributo e usado como matriz, há a instanciação desse objeto e não apenas a sua declaração, uma implementação que poderia causar erros no código, como a exceção `ClassCastException`. Para mim, era entendível caso a matriz pieces houvesse apenas sido declarada como do tipo Piece, no entanto, dada a instanciação de um objeto desse mesmo tipo, deveria haver um erro no *downcast*. No entanto, entendi que:

Durante o *downcasting* de uma instância de Piece para ChessPiece usando a expressão `(ChessPiece)board.piece(i, j)`, presente no código a seguir, o construtor padrão implícito de ChessPiece é invocado para inicializar a instância resultante. Esse construtor implícito **não modifica os valores dos campos herdados de Piece, como as posições (row e column)**, a menos que esses campos sejam explicitamente definidos na classe ChessPiece.

```java
public ChessPiece[][] getPieces(){  
    // É pra retornar a matriz de peças de xadrez da partida  
    // O programa principal deverá ter acesso a essa classe e não à classe Piece, dado o desenvolvimento em camadas  
    ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];  
  
    // Loops fazendo downcasting de Piece para ChessPiece  
    // Downcasting: transformar de Piece (super classe) para ChessPiece (sub classe)    for(int i = 0;i< board.getRows();i++){  
        for(int j = 0; j<board.getColumns(); j++){  
            mat[i][j] = (ChessPiece)board.piece(i, j);  
        }  
    }  
  
    // O downcasting (ChessPiece)board.piece(i, j) apenas realiza uma  
    // conversão de tipo da referência Piece para ChessPiece. Ele não afeta os dados contidos na instância original.  
    return mat;  
}
```

Portanto, ao realizar o *downcasting*, as instâncias de ChessPiece na matriz mat serão inicializadas com os valores dos campos herdados de Piece. Isso significa que os campos row e column não serão afetados durante o *downcasting*,  mas o campo color, que não tem valor definido antes do *downcasting*, já que a variável Piece não tem esse atributo, será inicializado como *null*. Além disso, a posição dessa instância na matriz será (i, j).

Além disso, ao realizar o *downcasting* de um objeto Piece para um objeto ChessPiece usando `(ChessPiece)board.piece(i, j)`,  não há uma mudança direta do objeto Piece para ChessPiece. Em vez disso, há a obtenção de uma referência de ChessPiece para o mesmo objeto Piece original. Isso significa que o objeto Piece original não é alterado diretamente. Assim, o construtor padrão implícito de ChessPiece apenas inicializa uma nova instância de ChessPiece com base no objeto Piece original, sem mudá-lo. Essa nova instância de ChessPiece é então atribuída à matriz mat na posição (i, j), mantendo a referência ao mesmo objeto Piece original, mas agora como um objeto ChessPiece.