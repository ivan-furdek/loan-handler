package vega.loanhandler.model;

import java.time.LocalDate;
import java.time.Period;

public record DateRange(LocalDate Start, LocalDate End) {

    public boolean isLongerThan(Period period) {

        return Start.plus(period).isBefore(End);
    }

    public boolean isBetween(Period longerThan, Period shorterThan) {

        return isLongerThan(longerThan) && !isLongerThan(shorterThan);
    }
}
