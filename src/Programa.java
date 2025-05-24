import arquivo.CaixaService;
import arquivo.ContaService;
import arquivo.impl.ContaServiceImpl;

public class Programa {

    public static void main(String[] args) {

        var contaService = new CaixaService();
        contaService.saquar(86354,10.0);

    }

}
