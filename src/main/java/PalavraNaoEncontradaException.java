public class PalavraNaoEncontradaException extends RuntimeException {
    public PalavraNaoEncontradaException(String palavra) {
        super("A palavra " + "'" + palavra + "'" + " não existe no dicionário");
    }
}