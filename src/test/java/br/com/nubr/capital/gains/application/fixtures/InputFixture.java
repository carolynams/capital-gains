package br.com.nubr.capital.gains.application.fixtures;

import br.com.nubr.capital.gains.application.entity.Input;

public class InputFixture {

    public static Input createInput(String buy, double unitCost, int quantity) {
        return Input.builder()
                .operation(buy)
                .unitCost(unitCost)
                .quantity(quantity)
                .build();
    }
}
