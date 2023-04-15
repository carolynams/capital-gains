package br.com.nubr.capital.gains.application.functions;

import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalFormat {

    /**
     * Defines and returns a Decimal Format object with the pattern "0.00" and decimal separator set as "." (dot).
     *
     * @return DecimalFormat object with the defined format and decimal separator
     */
    public static java.text.DecimalFormat defineDecimalFormat() {
        var symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setDecimalSeparator('.');
        return new java.text.DecimalFormat("0.00", symbols);
    }
}
