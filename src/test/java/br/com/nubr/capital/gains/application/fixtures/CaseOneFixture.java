package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

public class CaseOneFixture {

    public static List<List<Input>> createCaseOneFixture() {
        return List.of(List.of(InputFixture.createInput("buy", 10.00, 100),
                InputFixture.createInput("sell", 15.00, 50),
                InputFixture.createInput("sell", 15.00, 50)));
    }
}
