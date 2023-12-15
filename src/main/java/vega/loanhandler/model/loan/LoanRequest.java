package vega.loanhandler.model.loan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import vega.loanhandler.model.DateRange;
import vega.loanhandler.model.RequesterOccupation;
import vega.loanhandler.visitor.LoanRequestVisitor;


@Getter
@AllArgsConstructor
public abstract class LoanRequest {
    protected final String account;
    protected final DateRange term;
    protected final Integer sumRequested;
    protected final RequesterOccupation requesterOccupation;

    public abstract <T> T accept(LoanRequestVisitor<? extends T> visitor);
}
