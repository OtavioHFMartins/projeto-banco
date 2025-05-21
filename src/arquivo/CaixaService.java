package arquivo;

import dominio.Linha;
import dominio.Operacao;

import java.util.List;

public class CaixaService {

    private final ArquivoService arquivoService = new ArquivoService();

    public void saquar(Integer numeroConta, Double valor){
        List<Linha> conta = arquivoService.getLinhasPorNumeroConta(numeroConta);
        if(conta.isEmpty()) throw new IllegalArgumentException("conta não existe");


    }

        public double calcularSaldo(List<Linha> eventos) {
            Linha eventoCadastro = eventos
                    .stream()
                    .filter(linha ->  isLinhaOperacaoCadastro(linha))
                    .findFirst()
                    .get();

                return 0.0;
        }

        private boolean isLinhaOperacaoCadastro(Linha linha){
             return linha.getCodigoOperacao().equals("CADASTRO");
        }
}
