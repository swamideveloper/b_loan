package com.gopal.fast.vid.NewImplement.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Gixxer_ConstDecimal {
    public boolean isInteger(double d) {
        return d == ((double) ((int) d));
    }

    public String roundOfToTwo(double d) {
        return String.valueOf(new BigDecimal(d).setScale(2, 6).longValue());
    }

    public double roundOfTo(double d) {
        return new BigDecimal(d).setScale(2, 6).doubleValue();
    }

    public String round(double d) {
        return ((DecimalFormat) NumberFormat.getNumberInstance(Locale.US)).format(d);
    }
}
