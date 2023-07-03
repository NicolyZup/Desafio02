package org.example.controllers;

import org.example.Venda;
import org.example.bancoDeDados.BancoDeVendas;

public class VendaController {

    BancoDeVendas bancoDeVendas = new BancoDeVendas();

    public void cadastrarVenda(Venda venda){
        bancoDeVendas.adicionarVenda(venda);
        System.out.println("Venda realizada com sucesso!");
    }

    public void listarVendas(){
        for(Venda venda: bancoDeVendas.getVendasRealizadas()){
            System.out.println("--------------------------");
            System.out.println("cliente: "+venda.getCliente().getNome());
            System.out.println("Vendedor: "+venda.getVendedor().getNome());
            System.out.println("Valor da venda: R$"+venda.getValor());
            System.out.println("Registro: "+venda.getDataDeRegistro());
        }
    }
}
