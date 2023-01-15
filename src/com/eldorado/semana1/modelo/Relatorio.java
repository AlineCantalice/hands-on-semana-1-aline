package com.eldorado.semana1.modelo;

public class Relatorio implements Comparable<Relatorio> {

    String nomeEmpresa;
    Double totalFaturamento;
    Double totalNota;
    String ano;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Double getTotalFaturamento() {
        return totalFaturamento;
    }

    public void setTotalFaturamento(Double totalFaturamento) {
        this.totalFaturamento = totalFaturamento;
    }

    public Double getTotalNota() {
        return totalNota;
    }

    public void setTotalNota(Double totalNota) {
        this.totalNota = totalNota;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", nomeEmpresa, ano, totalFaturamento, totalNota);
    }

    @Override
    public int compareTo(Relatorio o) {
        return nomeEmpresa.compareTo(o.getNomeEmpresa());
    }
}
