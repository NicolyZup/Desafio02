import org.example.controllers.VendaController;
import org.example.dataBase.BancoDeVendas;
import org.example.models.Cliente;
import org.example.models.Venda;
import org.example.models.Vendedor;
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
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class VendaControllerTest {
    @Mock
    private ByteArrayOutputStream saida;

    @InjectMocks
    private VendaController vendaController;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        saida  = new ByteArrayOutputStream();
        System.setOut(new PrintStream(saida));
    }

    @Test
    public void verificaCadastroVenda(){
        Cliente cliente = new Cliente("Jose","jose@gmail.com","1212121212");
        Vendedor vendedor =new Vendedor("Renata","renata@gmail.com","090909090909");
        LocalDate data = LocalDate.now();

        Venda venda = new Venda(cliente,vendedor,23,data);

        vendaController.cadastrarVenda(venda);
        Assertions.assertEquals("Venda realizada com sucesso!", saida.toString().trim());
    }

    @Test
    public void verificaListaVendasVazias(){
        vendaController.listarVendas();
        Assertions.assertEquals("Nenhuma venda cadastrada.",saida.toString().trim());
    }

    @Test
    public void verificaListaVendedoresVazias(){
        String email = "fernando@email.com";
        vendaController.listarVendasVendedor(email);
        Assertions.assertEquals("Vendedor não cadastrado ou não realizou vendas ainda.",saida.toString().trim());
    }

    @Test
    public void verificaListaClientesVazias(){
        String cpf = "111111111111";
        vendaController.listarComprasCliente(cpf);
        Assertions.assertEquals("Cliente não cadastrado ou não realizou compras ainda.",saida.toString().trim());
    }
}
