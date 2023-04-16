package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

public class CaseFourFixture {

    public static List<List<Input>> createCaseFourFixture() {
        return List.of(List.of(InputFixture.createInput("buy", 10.00, 10000),
                InputFixture.createInput("buy", 25.00, 5000),
                InputFixture.createInput("sell", 15.00, 10000)));
    }
}
