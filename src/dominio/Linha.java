package dominio;

import java.time.LocalDateTime;

public class Linha {

    private String codigoOperacao;
    private String documento;
    private Integer numeroConta;
    private String nomeCliente;
    private double saldo;
    private Integer numeroContaDestino;
    private double valor;
    private String dataNascimento;
    private LocalDateTime dataCriacao;

    public static Linha createLinhaSaque(Integer numeroConta, double valor) {
        var linha = new Linha();
        linha.numeroConta = numeroConta;
        linha.valor = valor;
        linha.dataCriacao = LocalDateTime.now();
        linha.codigoOperacao = Operacao.SAQUE.name();
        return linha;
    }

    public static Linha createLinhaDeposito(Integer numeroConta, double valor) {
        var linha = new Linha();
        linha.numeroConta = numeroConta;
        linha.valor = valor;
        linha.dataCriacao = LocalDateTime.now();
        linha.codigoOperacao = Operacao.DEPOSITO.name();
        return linha;
    }

    public static Linha createLinhaTransferencia(Integer contaOrigem, Integer contaDestino, double valor) {
        var linha = new Linha();
        linha.numeroConta = contaOrigem;
        linha.valor = valor;
        linha.dataCriacao = LocalDateTime.now();
        linha.numeroContaDestino = contaDestino;
        linha.codigoOperacao = Operacao.TRANSFERENCIA.name();
        return linha;
    }

    public String getCodigoOperacao() {
        return codigoOperacao;
    }

    public void setCodigoOperacao(String codigoOperacao) {
        this.codigoOperacao = codigoOperacao;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(Integer numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

}