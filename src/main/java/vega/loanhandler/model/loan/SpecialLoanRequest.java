package vega.loanhandler.model.loan;

import vega.loanhandler.model.DateRange;
import vega.loanhandler.model.RequesterOccupation;
import vega.loanhandler.visitor.LoanRequestVisitor;

public class SpecialLoanRequest extends LoanRequest {

    public SpecialLoanRequest(String account, DateRange term, Integer sumRequested, RequesterOccupation requesterOccupation) {
        super(account, term, sumRequested, requesterOccupation);
    }

    @Override
    public <T> T accept(LoanRequestVisitor<? extends T> visitor) {
        return visitor.visitSpecialLoanRequest(this);
    }
}
