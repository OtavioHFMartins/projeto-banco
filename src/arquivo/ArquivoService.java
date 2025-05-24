package arquivo;

import dominio.Linha;
import dominio.Operacao;
import utils.DataUtil;
import utils.IOUtil;

import java.util.List;

import static utils.DataUtil.getDataFormatada;

public class ArquivoService {

    public static final String CAMINHO_ARQUIVO = "C:/Users/tatah/Desktop/workspace/projeto-banco/operacoes-bancarias.txt";

    public void adicionarOperacaoArquivo(Linha linha, Operacao operacao) {
        StringBuilder linhaStr = new StringBuilder(operacao.name()).append(",");

        switch (operacao) {
            case SAQUE, DEPOSITO ->
                    linhaStr.append(getDataFormatada(linha.getDataCriacao())).append(",")
                            .append(linha.getNumeroConta()).append(",")
                            .append(linha.getValor());
            case CADASTRO ->
                    linhaStr.append(getDataFormatada(linha.getDataCriacao())).append(",")
                            .append(linha.getNumeroConta()).append(",")
                            .append(linha.getDocumento()).append(",")
                            .append(linha.getNomeCliente()).append(",")
                            .append(linha.getDataNascimento()).append(",")
                            .append(linha.getSaldo());
            case TRANSFERENCIA ->
                    linhaStr.append(getDataFormatada(linha.getDataCriacao())).append(",")
                            .append(linha.getNumeroConta()).append(",")
                            .append(linha.getNumeroContaDestino()).append(",")
                            .append(linha.getValor());
            default -> throw new IllegalArgumentException("operacao invalida");
        }

        linhaStr.append("\n");

        IOUtil.addLinha(CAMINHO_ARQUIVO, linhaStr.toString());
    }

    public Linha getLinhaPorCodigoOperacao(String codigo) {
        return null;
    }

    public List<Linha> getLinhasPorNumeroConta(Integer numero) {
        List<String> linhasString = IOUtil.getLinhas(CAMINHO_ARQUIVO);

        return linhasString.stream().map(linhaString -> {
                    String[] linhasToken = linhaString.split(",");

                    var operacao = linhasToken[0];
                    var dataCriacao = linhasToken[1];
                    var conta = Integer.parseInt(linhasToken[2]);

                    var linha = new Linha();
                    linha.setCodigoOperacao(operacao);
                    linha.setDataCriacao(DataUtil.dataStringToLocalDateTime(dataCriacao));
                    linha.setNumeroConta(conta);

                    switch (operacao) {
                        case "CADASTRO" -> {
                            var documento = linhasToken[3];
                            var nome = linhasToken[4];
                            var dataNascimento = linhasToken[5];
                            var saldo = linhasToken[6];
                            linha.setDocumento(documento);
                            linha.setNomeCliente(nome);
                            linha.setDataNascimento(dataNascimento);
                            linha.setSaldo(Double.parseDouble(saldo));
                        }
                        case "SAQUE", "DEPOSITO" -> {
                            var valor = linhasToken[3];
                            linha.setValor(Double.parseDouble(valor));
                        }
                        case "TRANSFERENCIA" -> {
                            var contaDestino = linhasToken[3];
                            var valor = linhasToken[4];
                            linha.setNumeroContaDestino(Integer.parseInt(contaDestino));
                            linha.setValor(Double.parseDouble(valor));
                        }
                        default -> throw new IllegalArgumentException("operacao invalida");
                    }

                    return linha;

                })
                .filter(linha -> linha.getNumeroConta().equals(numero))
                .toList();

    }

    public List<Linha> getLinhasPorOperacao(Operacao operacao) {
        return null;
    }

    public List<Linha> getTodos() {
        return null;
    }

}