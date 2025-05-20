package dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Linha {

    private String codigoOperacao;
    private String documento;
    private Integer numeroConta;
    private String nomeCliente;
    private Double saldo;
    private Integer numeroContaDestino;
    private Double valor;
    private String dataNascimento;
    private LocalDateTime dataCriacao;

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

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroContaDestino() {
        return numeroContaDestino;
    }

    public void setNumeroContaDestino(Integer numeroContaDestino) {
        this.numeroContaDestino = numeroContaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
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
