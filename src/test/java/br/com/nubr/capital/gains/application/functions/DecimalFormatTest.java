package br.com.nubr.capital.gains.application.functions;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormatSymbols;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecimalFormatTest {

    @Test
    public void testDefineDecimalFormat() {
        var decimalFormat = DecimalFormat.defineDecimalFormat();
        DecimalFormatSymbols symbols = decimalFormat.getDecimalFormatSymbols();

        assertEquals('.', symbols.getDecimalSeparator());
        assertEquals(',', symbols.getGroupingSeparator());
        assertEquals("0.00", decimalFormat.toPattern().replace("#", ""));
    }
}