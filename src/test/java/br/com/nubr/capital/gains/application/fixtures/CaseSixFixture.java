package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

import static br.com.nubr.capital.gains.application.fixtures.InputFixture.createInput;

public class CaseSixFixture {

    public static List<List<Input>> createCaseSixFixture() {
        return List.of(List.of(createInput("buy", 10.00, 10000),
                createInput("sell", 2.00, 5000),
                createInput("sell", 20.00, 2000),
                createInput("sell", 20.00, 2000),
                createInput("sell", 25.00, 1000)));
    }
}
