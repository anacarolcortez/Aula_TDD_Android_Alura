package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void fazerLance(Lance lance){
        lances.add(lance);
        Collections.sort(lances);
        double valorLance = lance.getValorLance();
        calculaMaiorLance(valorLance);
        calculaMenorLance(valorLance);
    }

    private void calculaMenorLance(double valorLance) {
        if (valorLance < menorLance ){
                menorLance = valorLance;
        }
    }

    private void calculaMaiorLance(double valorLance) {
        if (valorLance > maiorLance){
            maiorLance = valorLance;
        }
    }

    public List<Lance> getTresMaioresLances() {
        int numeroMaximoLances = lances.size();
        if (numeroMaximoLances > 3){
            numeroMaximoLances = 3;
        }
        return lances.subList(0,numeroMaximoLances);
    }

    public double getMaiorLance(){
        return this.maiorLance;
    }

    public double getMenorLance(){
        return this.menorLance;
    }

}
