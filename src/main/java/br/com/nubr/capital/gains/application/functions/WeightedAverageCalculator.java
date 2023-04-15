package br.com.nubr.capital.gains.application.functions;

public class WeightedAverageCalculator {

    /**
     * Calculates the new weighted average cost of an item.
     *
     * @param currentFinancialActionQuantity the current quantity of the item.
     * @param weightedAverage                the current weighted average cost.
     * @param quantity                       the quantity of the item involved in the financial action.
     * @param unitCost                       the cost per unit of the item involved in the financial action.
     * @return the new weighted average cost of the item.
     */
    public static Double weightedAverageCalculator(int currentFinancialActionQuantity, double weightedAverage, int quantity, double unitCost) {
        return ((currentFinancialActionQuantity * weightedAverage) + (quantity * unitCost)) / (currentFinancialActionQuantity + quantity);
    }
}