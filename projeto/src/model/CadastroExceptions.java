package model;

public class CadastroExceptions extends Exception { 

    // Exceção caso matrícula ja exista
    public static class MatriculaExistenteException extends Exception {
        public MatriculaExistenteException(String mensagem) {
            super(mensagem);
        }
    }

    // Exceção para caso espaço fisico ja exitsa
    public static class EspacoExistenteException extends Exception {
        public EspacoExistenteException(String mensagem) {
            super(mensagem);
        }
    }

    public CadastroExceptions(String message) {
        super(message);
    }
}