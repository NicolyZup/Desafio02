package org.example.bancoDeDados;

import org.example.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class BancoDeVendedores {
    private List<Vendedor> vendedores = new ArrayList<>();

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void adicionarVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
    }

    public boolean verificaVendedorExistente(String cpf){
        for(Vendedor vendedor: this.vendedores){
            if(vendedor.getCpf().equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
}
