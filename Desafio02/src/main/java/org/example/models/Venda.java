package org.example.models;

import java.time.LocalDate;

public class Venda {
    private Cliente cliente;
    private Vendedor vendedor;
    private double valor;
    private LocalDate dataDeRegistro;

    public Venda(Cliente cliente, Vendedor vendedor, double valor, LocalDate dataDeRegistro) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.valor = valor;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }
}
