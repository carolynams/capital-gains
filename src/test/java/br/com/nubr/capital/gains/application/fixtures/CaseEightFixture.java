package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

import static br.com.nubr.capital.gains.application.fixtures.InputFixture.createInput;

public class CaseEightFixture {

    public static List<List<Input>> createCaseEightFixture() {
        return List.of(List.of(createInput("buy", 10.00, 10000),
                createInput("sell", 50.00, 10000),
                createInput("buy", 20.00, 10000),
                createInput("sell", 50.00, 10000)));
    }
}