package br.com.nubr.capital.gains.application.functions;

import br.com.nubr.capital.gains.application.entity.Input;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

import static br.com.nubr.capital.gains.application.functions.InputHandler.inputHandle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InputHandlerTest {

    @Test
    public void testHandleInput() {
        String input = "[{\"operation\":\"buy\", \"unit-cost\":10.00, \"quantity\": 10000},\n" +
                "{\"operation\":\"sell\", \"unit-cost\":20.00, \"quantity\": 5000}]\n" +
                "[{\"operation\":\"buy\", \"unit-cost\":20.00, \"quantity\": 10000},\n" +
                "{\"operation\":\"sell\", \"unit-cost\":10.00, \"quantity\": 5000}]";

        var reader = new BufferedReader(new StringReader(input));
        List<List<Input>> result = inputHandle(reader);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertListValues(result, 0, 10.0, 20.0);
        assertListValues(result, 1, 20.0, 10.0);
    }

    private void assertListValues(List<List<Input>> result, int index, double expected, double expected1) {
        List<Input> firstList = result.get(index);
        assertEquals(2, firstList.size());
        assertEquals("buy", firstList.get(0).getOperation());
        assertEquals(expected, firstList.get(0).getUnitCost());
        assertEquals(10000, firstList.get(0).getQuantity());
        assertEquals("sell", firstList.get(1).getOperation());
        assertEquals(expected1, firstList.get(1).getUnitCost());
        assertEquals(5000, firstList.get(1).getQuantity());
    }
}