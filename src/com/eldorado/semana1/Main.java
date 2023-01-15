package com.eldorado.semana1;

import com.eldorado.semana1.inicio.Inicio;

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
                System.out.println("Digite 1 - Gerar relatório;\nDigite 2 - Gerar relatório por ano;\nDigite 0 - Voltar;");
                var subMenu = SCANNER.nextLine();
                if(Objects.equals(subMenu, "1")){
                    inicio.lerArquivoFaturamento();
                } else if(Objects.equals(subMenu, "2")){
                    System.out.println("Digite o ano que deseja;");
                    inicio.lerArquivoFaturamentoPorAno(SCANNER.nextLine());
                }
            } else if (Objects.equals(opcao, "2")) {
                System.out.println("Digite 1 - Gerar relatório;\nDigite 2 - Gerar relatório por ano;\nDigite 0 - Voltar;");
                var subMenu = SCANNER.nextLine();
                if(Objects.equals(subMenu, "1")){
                    inicio.lerArquivoNota();
                } else if(Objects.equals(subMenu, "2")){
                    System.out.println("Digite o ano que deseja;");
                    inicio.lerArquivoNotaPorAno(SCANNER.nextLine());
                }
            }  else if (Objects.equals(opcao, "0")) {
                break;
            } else {
                LOGGER.info("Valor Digitado Invalido");
                inicio.escreverRelatorio();
            }
        }
    }
}