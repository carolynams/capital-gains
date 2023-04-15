package br.com.nubr.tax.application;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class Main {

    public static List<List<Map<String, Double>>> handleInput(String stdinInput) {
        Gson gson = new Gson();
        List<List<Map<String, Double>>> result = new ArrayList<>();

        String[] inputArray = stdinInput.replace("\n", "").split("]");
        for (String s : inputArray) {
            String jsonStr = s + "]";

            var list = gson.fromJson(jsonStr, List.class);
            result.add(list);
        }
        System.out.println("Input: " + result);
        return result;
    }

    @SneakyThrows
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<List<Map<String, String>>> response = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            sb.append(line.replace(",,", ","));
        }
        System.out.println("Input lines: " + sb);
        var lists = handleInput(sb.toString());

        for (var operations : lists) {
            double prejuizo = 0.0;
            double mediaPonderada = 0.0;
            var tax = 0.0;
            var quantidadeDeAcaoAtual = 0;
            double mediaPonderadaAtual = 0.0;
            var df = defineDecimalFormat();

            for (var operation : operations) {
                System.out.println(operation);
                List<Map<String, String>> taxa = new ArrayList<>();
                if (Objects.equals(operation.get("operation"), "buy")) {
                    final var quantity = getValueFromJson(operation, "quantity").intValue();
                    final var unitCost = getValueFromJson(operation, "unit-cost");
                    mediaPonderada = (quantidadeDeAcaoAtual * mediaPonderadaAtual) + (quantity * unitCost) / (quantidadeDeAcaoAtual + quantity);
                    taxa.add(Map.of("tax", df.format(tax)));
                    System.out.println("tax: " + tax);
                    System.out.println("mediaPonderada: " + mediaPonderada);
                } else {
                    final var quantity = getValueFromJson(operation, "quantity").intValue();
                    final var unitCost = getValueFromJson(operation, "unit-cost");

                    var custoTotal = quantity * mediaPonderada;
                    System.out.println("custoTotal: " + custoTotal);

                    double lucro = quantity * unitCost - custoTotal;
                    System.out.println("lucro: " + lucro);

                    if (lucro > 0) {
                        // há lucro na operação
                        if (prejuizo > 0) {
                            if (lucro >= prejuizo) {
                                // o lucro cobre todo o prejuízo
                                lucro -= prejuizo;
                                prejuizo = 0;
                            } else {
                                // o prejuízo não foi totalmente coberto
                                prejuizo -= lucro;
                                lucro = 0;
                            }
                        }
                        tax = lucro * 0.2;
                        taxa.add(Map.of("tax", df.format(tax)));
                        System.out.println("tax: " + tax);

                    } else {
                        prejuizo += Math.abs(lucro);
                        System.out.println("prejuizo: " + prejuizo);
                        taxa.add(Map.of("tax", df.format(tax)));
                    }
                }
                response.add(taxa);
            }
        }
        System.out.println("Taxa: " + response);
    }

    private static DecimalFormat defineDecimalFormat() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);
        return df;
    }

    private static Double getValueFromJson(Map<String, Double> operation, String fieldName) {
        return operation.get(fieldName);
    }

}