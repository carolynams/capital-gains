package br.com.nubr.capital.gains.application.functions;

import br.com.nubr.capital.gains.application.entity.Input;
import br.com.nubr.capital.gains.application.fixtures.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalGainsTest {

    private static List<Arguments> inputs() {
        return Arrays.asList(
                Arguments.of(CaseExampleFixture.createCaseExampleFixture(), List.of(List.of(getTax("0.00"),
                        getTax("10000.00")), List.of(getTax("0.00"), getTax("0.00")))),
                Arguments.of(CaseOneFixture.createCaseOneFixture(), List.of(List.of(getTax("0.00"),
                        getTax("0.00"), getTax("0.00")))),
                Arguments.of(CaseTwoFixture.createCaseTwoFixture(), List.of(List.of(getTax("0.00"),
                        getTax("10000.00"), getTax("0.00")))),
                Arguments.of(CaseOneAndTwoFixture.createCaseOneAndTwoFixture(), List.of(List.of(getTax("0.00"),
                        getTax("0.00"), getTax("0.00")), List.of(getTax("0.00"), getTax("10000.00"), getTax("0.00")))),
                Arguments.of(CaseThreeFixture.createCaseThreeFixture(), List.of(List.of(getTax("0.00"),
                        getTax("0.00"), getTax("1000.00")))),
                Arguments.of(CaseFourFixture.createCaseFourFixture(), List.of(List.of(getTax("0.00"),
                        getTax("0.00"), getTax("0.00")))),
                Arguments.of(CaseFiveFixture.createCaseFiveFixture(), List.of(List.of(getTax("0.00"),
                        getTax("0.00"), getTax("0.00"), getTax("10000.00")))),
                Arguments.of(CaseSixFixture.createCaseSixFixture(), List.of(List.of(getTax("0.00"), getTax("0.00"),
                        getTax("0.00"), getTax("0.00"), getTax("3000.00")))),
                Arguments.of(CaseSevenFixture.createCaseSevenFixture(), List.of(List.of(getTax("0.00"), getTax("0.00"),
                        getTax("0.00"), getTax("0.00"), getTax("3000.00"), getTax("0.00"), getTax("0.00"),
                        getTax("3700.00"), getTax("0.00")))),
                Arguments.of(CaseEightFixture.createCaseEightFixture(), List.of(List.of(getTax("0.00"),
                        getTax("80000.00"), getTax("0.00"), getTax("60000.00")))));
    }

    private static Map<String, String> getTax(String tax) {
        return Map.of("tax", tax);
    }

    @ParameterizedTest
    @MethodSource("inputs")
    void testCalculateCapitalGains(List<List<Input>> input, List<List<Map<String, String>>> expected) {
        List<List<Map<String, String>>> taxa = CapitalGains.calculateCapitalGains(input);
        assertEquals(expected, taxa);
    }
}