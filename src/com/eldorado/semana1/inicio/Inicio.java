package com.eldorado.semana1.inicio;

import com.eldorado.semana1.modelo.Faturamento;
import com.eldorado.semana1.modelo.Nota;
import com.eldorado.semana1.utilidades.GerenciadorDeArquivos;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Inicio {

    private static final Logger LOGGER = Logger.getLogger(Inicio.class.getName());
    static Scanner scanner = new Scanner(System.in);

    public void lerArquivoFaturamento() {
        var gerenciadorArquivos = new GerenciadorDeArquivos();

        List<Faturamento> faturamentos = gerenciadorArquivos.lerArquivoFaturamento("faturamento");

        List<Faturamento> listFaturamento = faturamentos.stream().collect(Collectors.toList());

        LOGGER.info(String.format("dados: %s", listFaturamento));

    }

    public void lerArquivoNota() {
        var gerenciadorArquivos = new GerenciadorDeArquivos();

        List<Nota> notas = gerenciadorArquivos.lerArquivoNota("nota_old");

        List<Nota> listNota = notas.stream().collect(Collectors.toList());

        LOGGER.info(String.format("dados: %s", listNota));

    }
}
