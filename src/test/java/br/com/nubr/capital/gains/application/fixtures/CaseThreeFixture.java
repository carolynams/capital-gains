package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

import static br.com.nubr.capital.gains.application.fixtures.InputFixture.createInput;

public class CaseThreeFixture {

    public static List<List<Input>> createCaseThreeFixture() {
        return List.of(List.of(createInput("buy", 10.00, 10000),
                createInput("sell", 5.00, 5000),
                createInput("sell", 20.00, 3000)));
    }
}
