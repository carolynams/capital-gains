package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

import static br.com.nubr.capital.gains.application.fixtures.InputFixture.createInput;

public class CaseFiveFixture {

    public static List<List<Input>> createCaseFiveFixture() {
        return List.of(List.of(createInput("buy", 10.00, 10000),
                createInput("buy", 25.00, 5000),
                createInput("sell", 15.00, 10000),
                createInput("sell", 25.00, 5000)));
    }
}
