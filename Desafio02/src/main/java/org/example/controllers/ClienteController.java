package org.example.controllers;

import org.example.Cliente;
import org.example.Vendedor;
import org.example.bancoDeDados.BancoDeClientes;

public class ClienteController {

    BancoDeClientes bancoDeClientes = new BancoDeClientes();
    public boolean verificarCadastroCliente(String cpf){
        if(bancoDeClientes.verificaClienteExistente(cpf)){
            System.out.println("Cliente cadastrado(a)!");
            return true;
        } else {
            System.out.println("Cliente não cadastrado(a)!");
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
        for(Cliente cliente: bancoDeClientes.getClientes()){
            if(cliente.getEmail().equalsIgnoreCase(email)){
                System.out.println("Email já cadastrado, tente outro e-mail.");
                return true;
            }
        }
        return false;
    }

    public boolean verificarCpfRepetido(String cpf){
        for(Cliente cliente: bancoDeClientes.getClientes()){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                System.out.println("Cpf já cadastrado, tente novamente.");
                return true;
            }
        }
        return false;
    }

    public void cadastrarCliente(Cliente cliente){
        bancoDeClientes.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado(a) com sucesso!");
    }

    public void listarClientes(){
        for(Cliente cliente: bancoDeClientes.getClientes()){
            System.out.println("--------------------------");
            System.out.println("Nome: "+cliente.getNome());
            System.out.println("cpf: "+cliente.getCpf());
            System.out.println("e-mail: "+cliente.getEmail());
        }
    }
}
