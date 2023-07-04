package org.example;

import org.example.controllers.ClienteController;
import org.example.controllers.VendaController;
import org.example.controllers.VendedorController;
import org.example.models.Cliente;
import org.example.models.Venda;
import org.example.models.Vendedor;

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

        do {
            String opcaoMenu = menuExibir();
            switch (opcaoMenu){
                case "1":
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
                    break;

                case "2":
                    System.out.println("Informe o cpf do cliente:");
                    String cpfClienteConsultar = entrada.next();

                    vendaController.listarComprasCliente(cpfClienteConsultar);
                    break;

                case "3":
                    System.out.println("Informe o e-mail do vendedor:");
                    String emailVendedor = entrada.next();

                    vendaController.listarVendasVendedor(emailVendedor);

                    break;

                case "4":
                    System.out.println("==========================");
                    System.out.println("CLIENTES");
                    clienteController.listarClientes();

                    System.out.println("==========================");
                    System.out.println("VENDEDORES");
                    vendedorController.listarVendedores();

                    System.out.println("==========================");
                    System.out.println("VENDAS");
                    vendaController.listarVendas();
                    break;

                case "5":
                    continuar = false;
                    System.out.println("Programa encerrado.");
                    break;
            }
        } while (continuar);
    }

    public static String menuExibir(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual operação deseja realizar?");
        System.out.println("(1) Cadastrar venda");
        System.out.println("(2) Verificar compras do(a) cliente");
        System.out.println("(3) Verificar vendas do(a) vendedor(a)");
        System.out.println("(4) Verificar lista de vendas, clientes e vendedores");
        System.out.println("(5) Sair do sistema");
        return entrada.nextLine();
    }
}
