package org.example.bancoDeDados;

import org.example.Venda;

import java.util.ArrayList;
import java.util.List;

public class BancoDeVendas {
    private List<Venda> vendasRealizadas = new ArrayList<>();

    public List<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }

    public void adicionarVenda(Venda venda){
        vendasRealizadas.add(venda);
    }
}
