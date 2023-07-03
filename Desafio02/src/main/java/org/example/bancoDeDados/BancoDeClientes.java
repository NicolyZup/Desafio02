package org.example.bancoDeDados;

import org.example.Cliente;
import org.example.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class BancoDeClientes {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public boolean verificaClienteExistente(String cpf){
        for(Cliente cliente: this.clientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
}
