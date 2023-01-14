package com.eldorado.semana1;

import com.eldorado.semana1.inicio.Inicio;
import com.eldorado.semana1.utilidades.GerenciadorDeArquivos;

import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LOGGER.info("Aplicação Iniciada");

        var inicio = new Inicio();

        while (true) {
            System.out.println("Digite 1 - Relatório faturamento;\nDigite 2 - Relatório nota;\nDigite 0 - Sair;");
            var opcao = SCANNER.nextLine();

            if (Objects.equals(opcao, "1")) {
                inicio.lerArquivoFaturamento();
            } else if (Objects.equals(opcao, "2")) {
                inicio.lerArquivoNota();
            } else if (Objects.equals(opcao, "0")) {
                break;
            } else {
                LOGGER.info("Valor Digitado Invalido");
            }
        }
    }
}