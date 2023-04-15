package br.com.nubr.capital.gains.application.functions;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.nubr.capital.gains.application.functions.DecimalFormat.defineDecimalFormat;
import static br.com.nubr.capital.gains.application.functions.FinancialCalculator.*;
import static br.com.nubr.capital.gains.application.functions.WeightedAverageCalculator.weightedAverageCalculator;

public class CapitalGains {

    /**
     * This method receives a List of operations with stocks and calculates the capital gains for each operation.
     *
     * @param input List of operations with stocks. Each operation is a List of Input objects that contains the quantity
     *              and the unit-cost of the stock, and the type of operation (buy or sell).
     * @return List of List of Maps, where each inner List of Maps represents the taxes paid for each operation.
     * Each Map contains the tax value as a String.
     */
    public static List<List<Map<String, String>>> calculateCapitalGains(List<List<Input>> input) {
        List<List<Map<String, String>>> response = new ArrayList<>();

        for (var operations : input) {
            List<Map<String, String>> taxes = new ArrayList<>();
            double loss = 0.0;
            double weightedAverage = 0.0;
            var currentFinancialActionQuantity = 0;
            var tax = 0.0;

            for (var operation : operations) {
                var quantity = operation.getQuantity();
                var unitCost = operation.getUnitCost();

                if (operation.getOperation().equals("buy")) {
                    weightedAverage = weightedAverageCalculator(currentFinancialActionQuantity, weightedAverage, quantity, unitCost);
                    currentFinancialActionQuantity += quantity;
                    tax = 0.0;
                } else if (operation.getOperation().equals("sell")) {
                    currentFinancialActionQuantity -= quantity;
                    var valorTotalOperacao = quantity * unitCost;
                    var lucroAtual = calculateCurrentProfit(weightedAverage, quantity, valorTotalOperacao);

                    double lucro = calculateProfit(loss, lucroAtual);
                    loss = calculateLoss(loss, lucroAtual);

                    tax = calculateTax(valorTotalOperacao, lucro);
                }
                taxes.add(Map.of("tax", defineDecimalFormat().format(tax)));
            }
            response.add(taxes);
        }
        return response;
    }
}