import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private final Map<String, String> mapaPortugues;
    private final Map<String, String> mapaIngles;

    public Dicionario() {
        mapaPortugues = new HashMap<>();
        mapaIngles = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario dicionario) {
        String chave = palavra.toUpperCase();

        if (dicionario == TipoDicionario.PORTUGUES) mapaPortugues.put(chave, traducao);
        if (dicionario == TipoDicionario.INGLES) mapaIngles.put(chave, traducao);
    }

    public String traduzir(String palavra, TipoDicionario dicionarioDeBusca) {
        String chave = palavra.toUpperCase();

        if (dicionarioDeBusca == TipoDicionario.PORTUGUES) {
            if (mapaPortugues.containsKey(chave)) {
                return mapaPortugues.get(chave);
            } else {
                throw new PalavraNaoEncontradaException(chave);
            }
        } else {
            if (mapaIngles.containsKey(chave)) {
                return mapaIngles.get(chave);
            } else {
                throw new PalavraNaoEncontradaException(chave);
            }
        }
    }
}