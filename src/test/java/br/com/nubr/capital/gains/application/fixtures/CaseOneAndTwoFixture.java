package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

public class CaseOneAndTwoFixture {

    public static List<List<Input>> createCaseOneAndTwoFixture() {
        return List.of(List.of(InputFixture.createInput("buy", 10.00, 100),
                        InputFixture.createInput("sell", 15.00, 50),
                        InputFixture.createInput("sell", 15.00, 50)),
                List.of(InputFixture.createInput("buy", 10.00, 10000),
                        InputFixture.createInput("sell", 20.00, 5000),
                        InputFixture.createInput("sell", 5.00, 5000)));
    }
}
