package com.eldorado.semana1.modelo;

import java.util.List;
import java.util.Map;

public class faturamento {
    private Empresa empresa;
    private String dataParcela1;
    private Double parcela1;

    private String dataParcela2;
    private Double parcela2;

    private String dataParcela3;
    private Double parcela3;


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getDataParcela1() {
        return dataParcela1;
    }

    public void setDataParcela1(String dataParcela1) {
        this.dataParcela1 = dataParcela1;
    }

    public Double getParcela1() {
        return parcela1;
    }

    public void setParcela1(Double parcela1) {
        this.parcela1 = parcela1;
    }

    public String getDataParcela2() {
        return dataParcela2;
    }

    public void setDataParcela2(String dataParcela2) {
        this.dataParcela2 = dataParcela2;
    }

    public Double getParcela2() {
        return parcela2;
    }

    public void setParcela2(Double parcela2) {
        this.parcela2 = parcela2;
    }

    public String getDataParcela3() {
        return dataParcela3;
    }

    public void setDataParcela3(String dataParcela3) {
        this.dataParcela3 = dataParcela3;
    }

    public Double getParcela3() {
        return parcela3;
    }

    public void setParcela3(Double parcela3) {
        this.parcela3 = parcela3;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s", empresa.getNomeEmpresa(), empresa.getMes(), empresa.getAno(), dataParcela1, parcela1, dataParcela2, parcela2, dataParcela3, parcela3);
    }
}
