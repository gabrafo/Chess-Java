package boardgame;

public class BoardException extends RuntimeException{ // Exceção opcional para ser tratada
    private static final long serialVersionUID = 1L; // Número de versão padrão

    public BoardException(String msg) {
        super(msg);
    }
}
