package br.com.alura.leilao.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricaoQuandoRecebeDescricao() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        String descricao = leilaoTeste.getDescricao();
        assertEquals("Leilão de Teste", descricao);
    }

    @Test
    public void getDescricaoQuandoRecebeDescricaoNula() {
        Leilao leilaoTeste = new Leilao(null);
        String descricao = leilaoTeste.getDescricao();
        assertEquals(null, descricao);
    }

    @Test
    public void getMaiorLanceQuandoHaUmLanceUnico() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 200.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceEmListaDeLeilaoCriadaEmOrdemCrescente() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 200.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mari"), 300.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mar"), 400.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Ma"), 500.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceEmListaDeLeilaoCriadaEmOrdemDecrescente() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        leilaoTeste.fazerLance(new Lance(new Usuario("Ma"), 500.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mar"), 400.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mari"), 300.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 200.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMenorLanceQuandoHaUmLanceUnico() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 50.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(50.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMenorLanceEmListaDeLeilaoCriadaEmOrdemCrescente() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 200.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mari"), 300.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mar"), 400.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Ma"), 500.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMenorLanceEmListaDeLeilaoCriadaEmOrdemDecrescente() {
        Leilao leilaoTeste = new Leilao("Leilão de Teste");
        leilaoTeste.fazerLance(new Lance(new Usuario("Ma"), 500.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mar"), 400.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mari"), 300.0));
        leilaoTeste.fazerLance(new Lance(new Usuario("Mariana"), 200.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

}