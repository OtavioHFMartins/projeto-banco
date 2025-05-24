package arquivo;

import dominio.Linha;
import dominio.Operacao;

import java.util.List;

public class CaixaService {

    private final ArquivoService arquivoService = new ArquivoService();

    public void saquar(Integer numeroConta, Double valor) {
        List<Linha> eventosConta = arquivoService.getLinhasPorNumeroConta(numeroConta);
        checarSeContaNaoExiste(eventosConta);
        checarSaldoInsulficiente(eventosConta,valor);
        var eventoSaque = Linha.createLinhaSaque(numeroConta, valor);
        arquivoService.adicionarOperacaoArquivo(eventoSaque, Operacao.SAQUE);

        System.out.println("Saque da conta: " + numeroConta + " realizado com sucesso");
    }

    public void transferir(Integer contaOrigem, Integer contaDestino, final Double valor) {
        try {
            saquar(contaOrigem, valor);
        } catch (Exception e) {
            throw new RuntimeException("erro na transferencia - operacao saque conta origem: " + e.getMessage());
        }

        try {
            depositar(contaDestino, valor);
        } catch (Exception e) {
            depositar(contaOrigem, valor);
            throw new RuntimeException("erro na transferencia - operacao deposito conta destino: " + e.getMessage());
        }

        var eventoTransferencia = Linha.createLinhaTransferencia(contaOrigem, contaDestino, valor);
        arquivoService.adicionarOperacaoArquivo(eventoTransferencia, Operacao.TRANSFERENCIA);
    }

    public void depositar(Integer numeroConta, Double valor) {
        List<Linha> eventosConta = arquivoService.getLinhasPorNumeroConta(numeroConta);
        checarSeContaNaoExiste(eventosConta);
        var eventoDeposito = Linha.createLinhaDeposito(numeroConta, valor);
        arquivoService.adicionarOperacaoArquivo(eventoDeposito, Operacao.DEPOSITO);
        System.out.println("deposito na conta: " + numeroConta + " realizado com sucesso");
    }

    public double calcularSaldo(List<Linha> eventos) {
        var eventoCadastro = eventos
                .stream()
                .filter(linha -> linha.getCodigoOperacao().equals("CADASTRO"))
                .findAny()
                .orElse(new Linha());

        var eventosDeposito = eventos
                .stream()
                .filter(linha -> linha.getCodigoOperacao().equals("DEPOSITO"))
                .toList();

        var eventosSaque = eventos
                .stream()
                .filter(linha -> linha.getCodigoOperacao().equals("SAQUE"))
                .toList();

        var saldoInicial = eventoCadastro.getSaldo();

        var totalDepositos = eventosDeposito
                .stream()
                .map(Linha::getValor)
                .reduce(0.0, Double::sum);

        var totalSaques = eventosSaque
                .stream()
                .map(Linha::getValor)
                .reduce(0.0, Double::sum);

        return (saldoInicial + totalDepositos) - totalSaques;
    }

    private void checarSeContaNaoExiste(List<Linha> eventosConta) {
        if (eventosConta.isEmpty()) throw new IllegalArgumentException("conta nao existe");
    }

    private void checarSaldoInsulficiente(List<Linha> eventosConta, Double valor) {
        var saldo = calcularSaldo(eventosConta);
        if (valor > saldo) throw new RuntimeException("saldo insulficiente");
    }

}