package com.eldorado.semana1.utilidades;

import com.eldorado.semana1.modelo.Faturamento;
import com.eldorado.semana1.modelo.Nota;
import com.eldorado.semana1.modelo.Relatorio;

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
                faturamento.setNomeEmpresa(vetor[0]);
                faturamento.setMes(vetor[1]);
                faturamento.setAno(vetor[2]);
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
                nota.setNomeEmpresa(vetor[0]);
                nota.setMes(vetor[1]);
                nota.setAno(vetor[2]);
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

    public List<Relatorio> lerRelatorioAno(String ano, String nomeArquivo) {
        List<Relatorio> relatorios = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.format("%s/%s.txt", CAMINHO, nomeArquivo)))) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] vetor = line.split(";");
                var relatorio = new Relatorio();
                relatorio.setNomeEmpresa(vetor[0]);
                relatorio.setAno(vetor[1]);
                relatorio.setTotalFaturamento(getNovoValor(vetor[2]));
                relatorio.setTotalNota(getNovoValor(vetor[3]));

                relatorios.add(relatorio);
                line = bufferedReader.readLine();
            }
        } catch (IOException | ParseException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return relatorios.stream().filter(relatorio -> Objects.equals(relatorio.getAno(), ano)).collect(Collectors.toList());
    }

    public List<Faturamento> lerFaturamentoPorAno(String ano) {
        var gerenciadorArquivos = new GerenciadorDeArquivos();
        var faturamentos = gerenciadorArquivos.lerArquivoFaturamento("faturamento");

        return faturamentos.stream().filter(faturamento -> Objects.equals(faturamento.getAno(), ano)).collect(Collectors.toList());

    }

    public List<Nota> lerNotaPorAno(String ano) {
        var gerenciadorArquivos = new GerenciadorDeArquivos();
        var notas = gerenciadorArquivos.lerArquivoNota("nota");

        return notas.stream().filter(nota -> Objects.equals(nota.getAno(), ano)).collect(Collectors.toList());

    }

    public void escreverArquivo(List<Relatorio> relatorios, String nomeDoArquivo) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.format("%s/%s.txt", CAMINHO, nomeDoArquivo), true))) {
            for (Relatorio relatorio : relatorios) {
                bufferedWriter.append(relatorio.toString()).append("\n");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    private static double getNovoValor(String valor) throws ParseException {
        Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        return numberFormat.parse(valor).doubleValue();
    }
}
