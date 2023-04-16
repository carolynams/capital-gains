package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

import java.util.List;

import static br.com.nubr.capital.gains.application.fixtures.InputFixture.createInput;

public class CaseSevenFixture {

    public static List<List<Input>> createCaseSevenFixture() {
        return List.of(List.of(createInput("buy", 10.00, 10000),
                createInput("sell", 2.00, 5000),
                createInput("sell", 20.00, 2000),
                createInput("sell", 20.00, 2000),
                createInput("sell", 25.00, 1000),
                createInput("buy", 20.00, 10000),
                createInput("sell", 15.00, 5000),
                createInput("sell", 30.00, 4350),
                createInput("sell", 30.00, 650)));
    }
}