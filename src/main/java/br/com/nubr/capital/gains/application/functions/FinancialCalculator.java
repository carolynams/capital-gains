package br.com.nubr.capital.gains.application.functions;

public class FinancialCalculator {

    /**
     * This method calculates the tax based on the total operation value and profit earned.
     *
     * @param totalCost The total value of the operation.
     * @param profit    The profit earned from the operation.
     * @return The tax value for the given operation.
     */
    public static double calculateTax(double totalCost, double profit) {
        double minimumProfit = 20000.00;
        double incomeTax = 0.2;
        var tax = 0.0;

        if (totalCost > minimumProfit) {
            tax = profit * incomeTax;
        }
        return tax;
    }

    /**
     * This method calculates the current profit based on the weighted average of previous transactions.
     *
     * @param weightedAverage The weighted average of previous transactions.
     * @param quantity        The quantity of shares.
     * @param totalCost       The total value of the operation.
     * @return The profit earned from the operation.
     */
    public static double calculateCurrentProfit(double weightedAverage, int quantity, double totalCost) {
        return totalCost - (quantity * weightedAverage);
    }

    /**
     * This method calculates the loss based on the previous loss and current profit.
     *
     * @param loss   The previous loss.
     * @param profit The current profit.
     * @return The updated loss.
     */
    public static double calculateLoss(double loss, double profit) {
        var minimoEntreLucroPrejuizo = Math.min(profit, loss);
        loss -= minimoEntreLucroPrejuizo;
        return loss;
    }

    /**
     * This method calculates the profit based on the previous loss and current profit.
     *
     * @param loss         The previous loss.
     * @param actualProfit The current profit.
     * @return The updated profit.
     */
    public static double calculateProfit(Double loss, double actualProfit) {
        var minimumBetweenActualProfitAndLoss = Math.min(actualProfit, loss);
        actualProfit -= minimumBetweenActualProfitAndLoss;
        return actualProfit;
    }
}