package com.eldorado.semana1.modelo;

import com.eldorado.semana1.utilidades.Utilidades;

public class Nota {
    Empresa empresa;
    Double valor;
    String dataEmissao;
    Integer valorNota;

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
        return String.format("%s;%s;%s;%s;%s;%s", empresa.getNomeEmpresa(), empresa.getMes(), empresa.getAno(), valor, dataEmissao, valorNota);
    }
}
