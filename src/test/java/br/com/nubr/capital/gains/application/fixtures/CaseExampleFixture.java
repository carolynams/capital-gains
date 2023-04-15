package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

public class CaseExampleFixture {

    public static List<List<Input>> createCaseExampleFixture() {
        return List.of(List.of(InputFixture.createInput("buy", 10.00, 10000),
                        InputFixture.createInput("sell", 20.00, 5000)),
                List.of(InputFixture.createInput("buy", 20.00, 10000),
                        InputFixture.createInput("sell", 10.00, 5000)));
    }


}
