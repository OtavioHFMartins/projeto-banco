import arquivo.ContaService;

public class Programa {

    public static void main(String[] args) {

        var contaService = new ContaService();
        contaService.cadastrar("maria", "53509456882","08/10/2005", 100.00);

    }

}
