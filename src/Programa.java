import arquivo.ArquivoService;
import arquivo.CaixaService;
import arquivo.ContaService;
import arquivo.impl.ContaServiceImpl;

public class Programa {

    public static void main(String[] args) {

        var cadastroConta = new ContaServiceImpl();
        cadastroConta.cadastrar("otavio","53509456882","08/10/2005", 10000.00);

        var caixaService = new CaixaService();
        caixaService.transferir(72071,86354,500.00);





    }

}
