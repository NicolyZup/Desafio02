import org.example.controllers.VendedorController;
import org.example.dataBase.BancoDeVendedores;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VendedorControllerTest {
    @Mock
    private BancoDeVendedores bancoDeVendedores;
    private ByteArrayOutputStream saida;

    @InjectMocks
    private VendedorController vendedorController;

   @BeforeEach
   public void setup(){
       MockitoAnnotations.openMocks(this);
       saida  = new ByteArrayOutputStream();
       System.setOut(new PrintStream(saida));
   }

    @Test
    public void verificaVendedorCadastrado(){
        String cpf = "123456789";
        when(bancoDeVendedores.verificaVendedorExistente(cpf)).thenReturn(false);

        boolean resultado = vendedorController.verificarCadastroVendedor(cpf);
        Assertions.assertEquals(false, resultado);
   }

   @Test
    public void verificaSeEmailInvalido(){
       String email = "nicoly.com";
       VendedorController vendedorController1 = new VendedorController();

       boolean resultado = vendedorController1.verificarEmailValido(email);
       Assertions.assertFalse(resultado);
   }

   @Test
    public void verificaSeEmailValido(){
       String email = "nicoly@gmail.com";
       VendedorController vendedorController1 = new VendedorController();

       boolean resultado = vendedorController1.verificarEmailValido(email);
       Assertions.assertTrue(resultado);
   }

   @Test
    public void verificaSeEmailRepetido(){
       String email = "miguel@gmail.com";
       VendedorController vendedorController1 = new VendedorController();

       boolean resultado = vendedorController1.verificarEmailRepetido(email);
       Assertions.assertFalse(resultado);
   }

   @Test
    public void verificaSeCpfRepetido(){
       String cpf = "1234567890";
       VendedorController vendedorController1 = new VendedorController();

       boolean resultado = vendedorController1.verificarCpfRepetido(cpf);
       Assertions.assertFalse(resultado);
   }

   @Test
    public void verificaCadastroVendedor(){
       Vendedor vendedor = new Vendedor("Nicoly","nicoly@gmail.com","123456789");

       vendedorController.cadastrarVendedor(vendedor);
       Assertions.assertEquals("Vendedor(a) cadastrado(a) com sucesso!", saida.toString().trim());
   }

   @Test
    public void verificaListaVendedoresVazia(){
       vendedorController.listarVendedores();
       Assertions.assertEquals("Nenhum vendedor cadastrado.",saida.toString().trim());
   }
}
