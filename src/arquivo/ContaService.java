package arquivo;

import dominio.Linha;
import dominio.Operacao;

import java.time.LocalDateTime;
import java.util.Random;

public class ContaService {

    ArquivoService arquivoService = new ArquivoService();

    public void cadastrar(String nome, String documento, String dataNascimento, Double saldo) {
        var numeroConta = gerarNumeroConta(5);
        Linha ln = new Linha();
        ln.setDataCriacao(LocalDateTime.now());
        ln.setNumeroConta(numeroConta);
        ln.setDocumento(documento);
        ln.setNomeCliente(nome);
        ln.setDataNascimento(dataNascimento);
        ln.setSaldo(saldo);

        this.arquivoService.adicionarOperacaoArquivo(ln, Operacao.CADASTRO);
    }

    private Integer gerarNumeroConta(Integer tamanho) {
        Random random = new Random();
        StringBuilder n = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int numero = random.nextInt();
            n.append(numero);
        }

        return Integer.parseInt(n.toString());
    }

}
