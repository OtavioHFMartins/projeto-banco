package arquivo;

import dominio.Linha;
import dominio.Operacao;
import utils.IOUtil;

import java.util.List;

import static utils.DataUtil.getDataFormatada;

public class ArquivoService {

    public static final String CAMINHO_ARQUIVO = "Users/tatah/Desktop/workspace/projeto-banco";

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

        IOUtil.addLinha(CAMINHO_ARQUIVO, linhaStr.toString());
    }

    public Linha getLinhaPorCodigoOperacao(String codigo) {
        return null;
    }

    public List<Linha> getLinhaPorNumeroConta(Integer numero) {
        return null;
    }

    public List<Linha> getLinhasPorOperacao(Operacao operacao) {
        return null;
    }

    public List<Linha> getTodos() {
        return null;
    }

}
