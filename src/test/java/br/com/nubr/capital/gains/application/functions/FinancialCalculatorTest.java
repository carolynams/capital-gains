package br.com.nubr.capital.gains.application.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinancialCalculatorTest {

    @Test
    public void testCalculateTax() {
        double totalCost = 25000.00;
        double profit = 15000.00;
        double expectedTax = 3000.00;
        double actualTax = FinancialCalculator.calculateTax(totalCost, profit);
        assertEquals(expectedTax, actualTax);
    }

    @Test
    public void testCalculateCurrentProfit() {
        double weightedAverage = 2.5;
        int quantity = 10;
        double totalCost = 30.0;
        double expectedProfit = 5.0;
        double actualProfit = FinancialCalculator.calculateCurrentProfit(weightedAverage, quantity, totalCost);
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    public void testCalculateLoss() {
        double loss = 1000.0;
        double profit = 500.0;
        double expectedLoss = 500.0;
        double actualLoss = FinancialCalculator.calculateLoss(loss, profit);
        assertEquals(expectedLoss, actualLoss);
    }

    @Test
    public void testCalculateProfit() {
        Double loss = 1000.0;
        double actualProfit = 1500.0;
        double expectedProfit = 500.0;
        double actualResult = FinancialCalculator.calculateProfit(loss, actualProfit);
        assertEquals(expectedProfit, actualResult);
    }
}