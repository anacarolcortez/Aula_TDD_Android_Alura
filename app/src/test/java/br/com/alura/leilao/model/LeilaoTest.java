package br.com.alura.leilao.model;

import org.junit.Test;
import static org.junit.Assert.*;
import br.com.alura.leilao.model.Lance;
import java.util.*;

public class LeilaoTest {

    private final double DELTA = 0.0001;
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
        assertEquals(200.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getMaiorLanceEmListaDeLeilaoCriadaEmOrdemCrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 200.0));
        leilaoTeste.fazerLance(new Lance(carol, 300.0));
        leilaoTeste.fazerLance(new Lance(ana, 400.0));
        leilaoTeste.fazerLance(new Lance(carol, 500.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(500.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getMaiorLanceEmListaDeLeilaoCriadaEmOrdemDecrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 500.0));
        leilaoTeste.fazerLance(new Lance(carol, 400.0));
        leilaoTeste.fazerLance(new Lance(ana, 300.0));
        leilaoTeste.fazerLance(new Lance(carol, 200.0));
        double maiorLanceDevolvido = leilaoTeste.getMaiorLance();
        assertEquals(500.0, maiorLanceDevolvido, DELTA);
    }

    @Test
    public void getMenorLanceQuandoHaUmLanceUnico() {
        leilaoTeste.fazerLance(new Lance(ana, 50.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(50.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void getMenorLanceEmListaDeLeilaoCriadaEmOrdemCrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 200.0));
        leilaoTeste.fazerLance(new Lance(carol, 300.0));
        leilaoTeste.fazerLance(new Lance(ana, 400.0));
        leilaoTeste.fazerLance(new Lance(carol, 500.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }

    @Test
    public void getMenorLanceEmListaDeLeilaoCriadaEmOrdemDecrescente() {
        leilaoTeste.fazerLance(new Lance(ana, 500.0));
        leilaoTeste.fazerLance(new Lance(carol, 400.0));
        leilaoTeste.fazerLance(new Lance(ana, 300.0));
        leilaoTeste.fazerLance(new Lance(carol, 200.0));
        double menorLanceDevolvido = leilaoTeste.getMenorLance();
        assertEquals(200.0, menorLanceDevolvido, DELTA);
    }

    //TDD: Test Driven Development
    @Test
    public void getTresMaioresLancesAoReceberTresLances() {
        leilaoTeste.fazerLance(new Lance(carol, 400.0));
        leilaoTeste.fazerLance(new Lance(ana, 300.0));
        leilaoTeste.fazerLance(new Lance(ana, 500.0));
        List<Lance> tresMaioresLances = leilaoTeste.getTresMaioresLances();
        assertEquals(3, tresMaioresLances.size());
        assertEquals(500.0, tresMaioresLances.get(0).getValorLance(), DELTA);
        assertEquals(400.0, tresMaioresLances.get(1).getValorLance(), DELTA);
        assertEquals(300.0, tresMaioresLances.get(2).getValorLance(), DELTA);
    }

}