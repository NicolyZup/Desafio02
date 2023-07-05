import org.example.controllers.ClienteController;
import org.example.dataBase.BancoDeClientes;
import org.example.models.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @Mock
    private BancoDeClientes bancoDeClientes;
    private ByteArrayOutputStream saida;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        saida  = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));
    }

    @Test
    public void verificaClienteCadastrado(){
        String cpf = "555555555";
        when(bancoDeClientes.verificaClienteExistente(cpf)).thenReturn(false);

        boolean resultado = clienteController.verificarCadastroCliente(cpf);
        Assertions.assertEquals(false, resultado);
    }

    @Test
    public void verificaSeEmailInvalido(){
        String email = "mariana.com";
        ClienteController clienteController1 = new ClienteController();

        boolean resultado = clienteController1.verificarEmailValido(email);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void verificaSeEmailValido(){
        String email = "mariana@gmail.com";
        ClienteController clienteController1 = new ClienteController();

        boolean resultado = clienteController1.verificarEmailValido(email);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void verificaSeEmailRepetido(){
        String email = "lurdes@gmail.com";
        ClienteController clienteController1 = new ClienteController();

        boolean resultado = clienteController1.verificarEmailRepetido(email);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void verificaSeCpfRepetido(){
        String cpf = "9999999999";
        ClienteController clienteController1 = new ClienteController();

        boolean resultado = clienteController1.verificarCpfRepetido(cpf);
        Assertions.assertFalse(resultado);
    }

    @Test
    public void verificaCadastroCliente(){
        Cliente cliente = new Cliente("Luis","luis@gmail.com","33333333333");

        clienteController.cadastrarCliente(cliente);
        Assertions.assertEquals("Cliente cadastrado(a) com sucesso!", saida.toString().trim());
    }

    @Test
    public void verificaListaClientesVazia(){
        clienteController.listarClientes();
        Assertions.assertEquals("Nenhum cliente cadastrado.",saida.toString().trim());
    }
}
