package com.eldorado.semana1.inicio;

import com.eldorado.semana1.modelo.Faturamento;
import com.eldorado.semana1.modelo.Nota;
import com.eldorado.semana1.modelo.Relatorio;
import com.eldorado.semana1.utilidades.GerenciadorDeArquivos;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Inicio {

    private static final Logger LOGGER = Logger.getLogger(Inicio.class.getName());
    static Scanner scanner = new Scanner(System.in);

    public void lerArquivoFaturamento() {
        var gerenciadorArquivos = new GerenciadorDeArquivos();

        List<Faturamento> faturamentos = gerenciadorArquivos.lerArquivoFaturamento("faturamento").stream().collect(Collectors.toList());

        LOGGER.info(String.format("%s", faturamentos));

    }

    public void lerArquivoNota() {
        var gerenciadorArquivos = new GerenciadorDeArquivos();

        List<Nota> notas = gerenciadorArquivos.lerArquivoNota("nota").stream().collect(Collectors.toList());

        LOGGER.info(String.format("%s", notas));

    }

    public void lerArquivoFaturamentoPorAno(String ano){
        var gerenciadorArquivo = new GerenciadorDeArquivos();
        List<Faturamento> faturamentos = gerenciadorArquivo.lerFaturamentoPorAno(ano).stream().collect(Collectors.toList());

        LOGGER.info(String.format("%s", faturamentos));
    }

    public void lerArquivoNotaPorAno(String ano){
        var gerenciadorArquivo = new GerenciadorDeArquivos();
        List<Nota> notas = gerenciadorArquivo.lerNotaPorAno(ano).stream().collect(Collectors.toList());

        LOGGER.info(String.format("%s", notas));
    }

    public void escreverRelatorio(){
        var gerenciadorArquivo = new GerenciadorDeArquivos();

        List<Faturamento> faturamentos = gerenciadorArquivo.lerArquivoFaturamento("faturamento");
        List<Nota> notas = gerenciadorArquivo.lerArquivoNota("nota");
        List<Relatorio> relatoriosConformidade = new ArrayList<>();
        List<Relatorio> relatoriosNaoConformidade = new ArrayList<>();

        Map<String, Map<String, List<Nota>>> mapNotas = notas.parallelStream().collect(groupingBy(Nota::getNomeEmpresa, Collectors.groupingBy(Nota::getAno)));

        Map<String, Map<String, List<Faturamento>>> mapFaturamento = faturamentos.parallelStream().collect(groupingBy(Faturamento::getNomeEmpresa, Collectors.groupingBy(Faturamento::getAno)));

        mapNotas.forEach((key, values) -> {
            values.forEach((subKey, subValues) -> {
                var valorNotaAno = subValues.stream().mapToDouble(Nota::getValor).sum();
                var valorFaturamentoAno = Optional.ofNullable(mapFaturamento.get(key).get(subKey)).orElse(new ArrayList<>()).stream().mapToDouble(Faturamento::getTotal).sum();
                var relatorio = new Relatorio();
                if (valorNotaAno == valorFaturamentoAno){
                    relatorio.setNomeEmpresa(key);
                    relatorio.setTotalFaturamento(valorFaturamentoAno);
                    relatorio.setTotalNota(valorNotaAno);
                    relatorio.setAno(subKey);

                    relatoriosConformidade.add(relatorio);
                } else {
                    relatorio.setNomeEmpresa(key);
                    relatorio.setTotalFaturamento(valorFaturamentoAno);
                    relatorio.setTotalNota(valorNotaAno);
                    relatorio.setAno(subKey);

                    relatoriosNaoConformidade.add(relatorio);
                }
            });
        });
        if (!relatoriosConformidade.isEmpty()){
            gerenciadorArquivo.escreverArquivo(relatoriosConformidade, "conformidade");
        }
        if (!relatoriosNaoConformidade.isEmpty()) {
            gerenciadorArquivo.escreverArquivo(relatoriosNaoConformidade, "nao-conformidade");
        }
    }
}
