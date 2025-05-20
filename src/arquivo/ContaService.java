package arquivo;

import dominio.Linha;
import dominio.Operacao;

import java.time.LocalDateTime;
import java.util.Random;

public class ContaService {

    private static final int TAMANHO_NUMERO_CONTA = 5;
    private static final int RANGE_NUMERO_CONTA = 9;

    ArquivoService arquivoService = new ArquivoService();

    public void cadastrar(String nome, String documento, String dataNascimento, Double saldo) {
        var numeroConta = gerarNumeroConta();
        Linha ln = new Linha();
        ln.setDataCriacao(LocalDateTime.now());
        ln.setNumeroConta(numeroConta);
        ln.setDocumento(documento);
        ln.setNomeCliente(nome);
        ln.setDataNascimento(dataNascimento);
        ln.setSaldo(saldo);

        this.arquivoService.adicionarOperacaoArquivo(ln, Operacao.CADASTRO);
    }

    private Integer gerarNumeroConta() {
        Random random = new Random();
        StringBuilder n = new StringBuilder();

        for (int i = 0; i < TAMANHO_NUMERO_CONTA; i++) {
            int numero = random.nextInt(RANGE_NUMERO_CONTA);
            n.append(numero);
        }

        return Integer.parseInt(n.toString());
    }

}
