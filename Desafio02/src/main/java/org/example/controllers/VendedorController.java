package org.example.controllers;

import org.example.dataBase.BancoDeVendas;
import org.example.models.Vendedor;
import org.example.dataBase.BancoDeVendedores;

public class VendedorController {
    BancoDeVendedores bancoDeVendedores = new BancoDeVendedores();

    public boolean verificarCadastroVendedor(String cpf){
        if(bancoDeVendedores.verificaVendedorExistente(cpf)){
            System.out.println("Vendedor(a) cadastrado!");
            return true;
        } else {
            System.out.println("Vendedor não cadastrado!");
            return false;
        }
    }

    public boolean verificarEmailValido(String email){
        if(email.contains("@")){
            return true;
        }
        System.out.println("E-mail inválido, tente novamente!");
        return false;
    }

    public boolean verificarEmailRepetido(String email){
        for(Vendedor vendedor: bancoDeVendedores.getVendedores()){
            if(vendedor.getEmail().equalsIgnoreCase(email)){
                System.out.println("Email já cadastrado, tente outro e-mail.");
                return true;
            }
        }
        return false;
    }

    public boolean verificarCpfRepetido(String cpf){
        for(Vendedor vendedor: bancoDeVendedores.getVendedores()){
            if(vendedor.getCpf().equalsIgnoreCase(cpf)){
                System.out.println("Cpf já cadastrado, tente novamente.");
                return true;
            }
        }
        return false;
    }

    public void cadastrarVendedor(Vendedor vendedor){
        bancoDeVendedores.adicionarVendedor(vendedor);
        System.out.println("Vendedor(a) cadastrado(a) com sucesso!");
    }

    public void listarVendedores(){
        if(bancoDeVendedores.getVendedores().size() ==0){
            System.out.println("Nenhum vendedor cadastrado.");
        } else {
            for (Vendedor vendedor : bancoDeVendedores.getVendedores()) {
                System.out.println("--------------------------");
                System.out.println("Nome: " + vendedor.getNome());
                System.out.println("cpf: " + vendedor.getCpf());
                System.out.println("e-mail: " + vendedor.getEmail());
            }
        }
    }
}
