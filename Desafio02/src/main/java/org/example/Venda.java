package org.example;

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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDate dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }
}
