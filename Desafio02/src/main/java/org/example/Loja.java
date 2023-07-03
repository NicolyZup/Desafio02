package org.example;

import org.example.controllers.ClienteController;
import org.example.controllers.VendaController;
import org.example.controllers.VendedorController;

import java.time.LocalDate;
import java.util.Scanner;

public class Loja {
    public static void main(String[] args) {
        VendaController vendaController = new VendaController();
        VendedorController vendedorController = new VendedorController();
        ClienteController clienteController = new ClienteController();

        Scanner entrada = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("  GESTÃO DE VENDAS: LOJA DA NICK  ");
        System.out.println("==================================");

        boolean continuar = true;
        Vendedor vendedor = null;
        Cliente cliente = null;

        while (continuar){
            System.out.println("Informe o cpf do vendedor:");
            String cpfInfomado = entrada.next();

            boolean vendedorCadastrado = vendedorController.verificarCadastroVendedor(cpfInfomado);

            if(!vendedorCadastrado){
                System.out.println("Realize seu cadastro de vendedor para continuar.");

                System.out.println("Informe seu nome:");
                String nomeVendedor = entrada.next();

                String cpfVendedor;
                do{
                System.out.println("Informe seu cpf:");
                cpfVendedor = entrada.next();
                }while (vendedorController.verificarCpfRepetido(cpfVendedor));

                String emailVendedor;
                do{
                    System.out.println("Informe seu e-mail:");
                    emailVendedor = entrada.next();
                } while (!vendedorController.verificarEmailValido(emailVendedor) || vendedorController.verificarEmailRepetido(emailVendedor));


                Vendedor vendedorDefinido = new Vendedor(nomeVendedor,emailVendedor, cpfVendedor);
                vendedor = vendedorDefinido;
                vendedorController.cadastrarVendedor(vendedor);
            }

            System.out.println("Informe o cpf do cliente:");
            String cpfCliente = entrada.next();

            boolean clienteCadastrado = clienteController.verificarCadastroCliente(cpfCliente);

            if(!clienteCadastrado){
                System.out.println("Realize o cadastro do cliente para continuar.");

                System.out.println("Informe o nome do(a) cliente:");
                String nomeCliente = entrada.next();

                String cpfClienteCadastro;
                do {
                    System.out.println("Informe o cpf do(a) cliente:");
                    cpfClienteCadastro = entrada.next();
                } while (clienteController.verificarCpfRepetido(cpfClienteCadastro));

                String emailCliente;
                do{
                    System.out.println("Informe o email do(a) cliente:");
                    emailCliente = entrada.next();
                } while (!clienteController.verificarEmailValido(emailCliente)||clienteController.verificarEmailRepetido(emailCliente));

                Cliente clienteDefinido = new Cliente(nomeCliente,emailCliente, cpfClienteCadastro);
                cliente = clienteDefinido;
                clienteController.cadastrarCliente(cliente);
            }

            System.out.println("Informe o valor a ser pago da venda:");
            double valorVenda = entrada.nextDouble();

            LocalDate registro = LocalDate.now();
            Venda venda = new Venda(cliente,vendedor,valorVenda,registro);

            vendaController.cadastrarVenda(venda);

            System.out.println("==========================");
            System.out.println("CLIENTES");
            clienteController.listarClientes();

            System.out.println("==========================");
            System.out.println("VENDEDORES");
            vendedorController.listarVendedores();

            System.out.println("==========================");
            System.out.println("VENDAS");
            vendaController.listarVendas();

            System.out.println("Deseja registrar mais vendas?(s/n)");
            String continuarRegistrando = entrada.next();

            if(continuarRegistrando.equalsIgnoreCase("n")){
                continuar = false;
            }
        }

        System.out.println("Vendas finalizadas!");
    }
}
