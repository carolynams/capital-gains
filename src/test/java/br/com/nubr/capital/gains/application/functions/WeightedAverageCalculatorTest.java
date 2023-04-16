package br.com.nubr.capital.gains.application.functions;

import org.junit.jupiter.api.Test;

import static br.com.nubr.capital.gains.application.functions.WeightedAverageCalculator.weightedAverageCalculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WeightedAverageCalculatorTest {

    @Test
    void testWeightedAverageCalculator() {
        double weightedAverage = weightedAverageCalculator(10, 5, 5, 10);
        assertEquals(6.67, weightedAverage, 0.01);
    }

}