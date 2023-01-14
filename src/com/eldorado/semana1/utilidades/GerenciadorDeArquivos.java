package com.eldorado.semana1.utilidades;

import com.eldorado.semana1.modelo.Empresa;
import com.eldorado.semana1.modelo.Faturamento;
import com.eldorado.semana1.modelo.Nota;

import java.io.*;
import java.io.FileReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GerenciadorDeArquivos {

    private static final Logger LOGGER = Logger.getLogger(GerenciadorDeArquivos.class.getName());

    static final String CAMINHO = "resource/";

    public List<Faturamento>  lerArquivoFaturamento(String nomeArquivo) {
        List<Faturamento> notas = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format("%s/%s.txt", CAMINHO, nomeArquivo)))) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while(line != null){
                String[] vetor = line.split(";");
                var faturamento = new Faturamento();
                var empresa = new Empresa();
                empresa.setNomeEmpresa(vetor[0]);
                empresa.setMes(vetor[1]);
                empresa.setAno(vetor[2]);
                faturamento.setEmpresa(empresa);
                faturamento.setDataParcela1(vetor[3]);
                faturamento.setParcela1(getNovoValor(vetor[4]));
                faturamento.setDataParcela2(vetor[5]);
                faturamento.setParcela2(getNovoValor(vetor[6]));
                faturamento.setDataParcela3(vetor[7]);
                faturamento.setParcela3(getNovoValor(vetor[8]));

                notas.add(faturamento);
                line = bufferedReader.readLine();
            }
        } catch (IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return notas;
    }

    public List<Nota> lerArquivoNota(String nomeArquivo) {
        List<Nota> notas = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format("%s/%s.txt", CAMINHO, nomeArquivo)))) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while(line != null){
                String[] vetor = line.split(";", 6);
                var nota = new Nota();
                var empresa = new Empresa();
                empresa.setNomeEmpresa(vetor[0]);
                empresa.setMes(vetor[1]);
                empresa.setAno(vetor[2]);
                nota.setEmpresa(empresa);
                nota.setValor(getNovoValor(vetor[3]));
                nota.setDataEmissao(vetor[4]);
                nota.setValorNota(vetor[5]);

                notas.add(nota);
                line = bufferedReader.readLine();
            }
        } catch (IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return notas;
    }

    public List<Faturamento> lerFaturamentoPorAno(String ano) {
        var gerenciadorArquivos = new GerenciadorDeArquivos();
        var faturamentos = gerenciadorArquivos.lerArquivoFaturamento("faturamento");

        var faturamentoAno = faturamentos.stream().filter(faturamento -> Objects.equals(faturamento.getEmpresa().getAno(), ano)).collect(Collectors.toList());

        return faturamentoAno;
    }

    public List<Nota> lerNotaPorAno(String ano) {
        var gerenciadorArquivos = new GerenciadorDeArquivos();
        var notas = gerenciadorArquivos.lerArquivoNota("nota");

        var notaAno = notas.stream().filter(nota -> Objects.equals(nota.getEmpresa().getAno(), ano)).collect(Collectors.toList());

        return notaAno;
    }

    private static double getNovoValor(String valor) throws ParseException {
        Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        return numberFormat.parse(valor).doubleValue();
    }
}
