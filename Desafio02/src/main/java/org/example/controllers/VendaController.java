package org.example.controllers;

import org.example.models.Venda;
import org.example.dataBase.BancoDeVendas;

public class VendaController {
    BancoDeVendas bancoDeVendas = new BancoDeVendas();

    public void cadastrarVenda(Venda venda){
        bancoDeVendas.adicionarVenda(venda);
        System.out.println("Venda realizada com sucesso!");
    }

    public void listarVendas(){
        if(bancoDeVendas.getVendasRealizadas().size() == 0){
            System.out.println("Nenhuma venda cadastrada.");
        } else {
            for (Venda venda : bancoDeVendas.getVendasRealizadas()) {
                System.out.println("--------------------------");
                System.out.println("cliente: " + venda.getCliente().getNome());
                System.out.println("Vendedor: " + venda.getVendedor().getNome());
                System.out.println("Valor da venda: R$" + venda.getValor());
                System.out.println("Registro: " + venda.getDataDeRegistro());
            }
        }
    }

    public void listarVendasVendedor(String email){
        boolean vendedorEncontrado = false;

        for(Venda venda : this.bancoDeVendas.getVendasRealizadas()){
            if(venda.getVendedor().getEmail().equals(email)){
                System.out.println("Vendedor: "+venda.getVendedor().getNome());
                System.out.println("cpf: "+venda.getVendedor().getCpf());
                System.out.println("E-mal: "+venda.getVendedor().getEmail());
                System.out.println("Cliente: "+venda.getCliente().getNome());
                System.out.println("Valor da compra: R$"+venda.getValor());
                System.out.println("Registro: "+venda.getDataDeRegistro());
                System.out.println("+++++++++++++++++++++++++++++++");
                vendedorEncontrado = true;
            }
        }

        if (!vendedorEncontrado){
            System.out.println("Vendedor não cadastrado ou não realizou vendas ainda.");
        }
    }

    public void listarComprasCliente(String cpf){
        boolean clienteEncontrado = false;
        for(Venda venda : this.bancoDeVendas.getVendasRealizadas()){
            if(venda.getCliente().getCpf().equals(cpf)){
                System.out.println("Cliente: "+venda.getCliente().getNome());
                System.out.println("cpf: "+venda.getCliente().getCpf());
                System.out.println("E-mal: "+venda.getCliente().getEmail());
                System.out.println("Vendedor: "+venda.getVendedor().getNome());
                System.out.println("Valor pago: R$"+venda.getValor());
                System.out.println("Data da compra: "+venda.getDataDeRegistro());
                System.out.println("+++++++++++++++++++++++++++++++");
                clienteEncontrado = true;
            }
        }

        if(!clienteEncontrado){
            System.out.println("Cliente não cadastrado ou não realizou compras ainda.");
        }
    }
}
