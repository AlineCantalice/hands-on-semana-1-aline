package com.eldorado.semana1.modelo;

public class Nota {
    private Empresa empresa;
    private Double valor;
    private String dataEmissao;
    private Integer valorNota;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Integer getValorNota() {
        return valorNota;
    }

    public void setValorNota(Integer valorNota) {
        this.valorNota = valorNota;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s", empresa.getNomeEmpresa(), empresa.getMes(), empresa.getAno(), valor, dataEmissao, valorNota);
    }
}
