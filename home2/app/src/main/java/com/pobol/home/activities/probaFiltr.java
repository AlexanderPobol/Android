package com.pobol.home.activities;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

public class probaFiltr implements InputFilter {
    private double min;
    private double max;

    public probaFiltr(double min, double max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        //noinspection EmptyCatchBlock
        try {
            float input = Float.parseFloat(dest.subSequence(0, dstart).toString() + source + dest.subSequence(dend, dest.length()));
            if (isInRange(min, max, input)) return null;
        } catch (NumberFormatException nfe) {
            Log.d ("myTag","isinRange error");
        } return "error";
    }

    private boolean isInRange(double a, double b, double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}