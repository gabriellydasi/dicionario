import org.junit.Assert;
import org.junit.Test;

public class DicionarioTest {
    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles() {
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Car", "Carro", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Book", "Livro", TipoDicionario.PORTUGUES);

        Assert.assertEquals("Car", dicionario.traduzir("carro", TipoDicionario.INGLES));
        Assert.assertEquals("Book", dicionario.traduzir("lIVRO", TipoDicionario.INGLES));
        Assert.assertEquals("Carro", dicionario.traduzir("cAr", TipoDicionario.PORTUGUES));
        Assert.assertEquals("Livro", dicionario.traduzir("bOoK", TipoDicionario.PORTUGUES));
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada() {
        Dicionario dicionario = new Dicionario();

        dicionario.traduzir("Caneta", TipoDicionario.INGLES);
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontradaNoDicionarioDePortugues() {
        Dicionario dicionario = new Dicionario();

        dicionario.traduzir("Flower", TipoDicionario.PORTUGUES);
    }
}