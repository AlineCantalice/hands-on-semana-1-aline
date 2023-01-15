package com.eldorado.semana1.modelo;

import com.eldorado.semana1.utilidades.Utilidades;

public class Nota implements Comparable<Nota>  {
    String nomeEmpresa;
    String mes;
    String ano;
    Double valor;
    String dataEmissao;
    Integer valorNota;

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        this.valor = Utilidades.lerValorDoubleUsuario(valor);
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

    public void setValorNota(String valorNota) {
        this.valorNota = Utilidades.lerIntegerUsuario(valorNota);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s", nomeEmpresa, mes, ano, valor, dataEmissao, valorNota);
    }

    @Override
    public int compareTo(Nota o) {
        return nomeEmpresa.compareTo(o.getNomeEmpresa());
    }
}
