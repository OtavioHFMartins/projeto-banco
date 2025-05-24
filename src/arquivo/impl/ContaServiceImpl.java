package arquivo.impl;

import arquivo.ArquivoService;
import arquivo.ContaService;
import dominio.Linha;
import dominio.Operacao;

import java.time.LocalDateTime;
import java.util.Random;

public class ContaServiceImpl implements ContaService {

    private static final int TAMANHO_NUMERO_CONTA = 5;
    private static final int RANGE_NUMERO_CONTA = 9;

    ArquivoService arquivoService = new ArquivoService();

    @Override
    public void cadastrar(String nome, String documento, String dataNascimento, Double saldo) {
        var numeroConta = gerarNumeroConta();
        Linha linha = new Linha();
        linha.setDataCriacao(LocalDateTime.now());
        linha.setNumeroConta(numeroConta);
        linha.setDocumento(documento);
        linha.setNomeCliente(nome);
        linha.setDataNascimento(dataNascimento);
        linha.setSaldo(saldo);

        // todo - fazer distincao de CPF e CNPJ no documento
        // todo - verficar se ja tem uma conta
        // todo - verificar se os compos nao estao nulos
        // todo - validar documento
        // todo - validar idade minima
        // todo - validar saldo minimo

        this.arquivoService.adicionarOperacaoArquivo(linha, Operacao.CADASTRO);
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