package br.com.alura.leilao.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LeilaoTest {

    private Leilao leilaoTeste = new Leilao("Leilão de Teste");
    private Usuario ana = new Usuario("Ana");
    private Usuario carol = new Usuario("Carol");


    @Test
    public void getDescricaoQuandoRecebeDescricao() {
        String descricao = leilaoTeste.getDescricao();
        assertEquals("Leilão de Teste", descricao);
    }

    @Test
    public void getDescricaoQuandoRecebeDescricaoNula() {
        Leilao leilaoDescNula = new Leilao(null);
        String descricao = leilaoDescNula.getDescricao();
        assertEquals(null, descricao);
    }

    @Test
    public void getMaiorLanceQuandoHaUmLanceUnico() {
        leilaoTeste.fazerLance(new Lance(ana, 200.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceEmListaDeLeilaoCriadaEmOrdemCrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 200.0));
        leilaoTeste.fazerLance(new Lance(carol, 300.0));
        leilaoTeste.fazerLance(new Lance(ana, 400.0));
        leilaoTeste.fazerLance(new Lance(carol, 500.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceEmListaDeLeilaoCriadaEmOrdemDecrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 500.0));
        leilaoTeste.fazerLance(new Lance(carol, 400.0));
        leilaoTeste.fazerLance(new Lance(ana, 300.0));
        leilaoTeste.fazerLance(new Lance(carol, 200.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMenorLanceQuandoHaUmLanceUnico() {
        leilaoTeste.fazerLance(new Lance(ana, 50.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(50.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMenorLanceEmListaDeLeilaoCriadaEmOrdemCrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 500.0));
        leilaoTeste.fazerLance(new Lance(carol, 400.0));
        leilaoTeste.fazerLance(new Lance(ana, 300.0));
        leilaoTeste.fazerLance(new Lance(carol, 200.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMenorLanceEmListaDeLeilaoCriadaEmOrdemDecrescente() {
        leilaoTeste.fazerLance(new Lance(new Usuario("Ma"), 500.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mar"), 400.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mari"), 300.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 200.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

}