package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.*;

public class Lance implements Serializable, Comparable {

    private final Usuario usuario;
    private final double valor;

    public Lance(Usuario usuario, double valor) {
        this.usuario = usuario;
        this.valor = valor;
    }

    public double getValorLance(){
        return this.valor;
    }

    @Override
    public int compareTo(Object o){
        Lance lance = (Lance) o;
        if (this.valor > lance.getValorLance()){
            return -1;
        }
        if (this.valor < lance.getValorLance()){
            return 1;
        }
        return 0;
    }

}
