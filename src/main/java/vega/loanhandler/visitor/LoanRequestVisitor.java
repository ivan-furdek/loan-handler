package vega.loanhandler.visitor;

import vega.loanhandler.model.loan.LongLoanRequest;
import vega.loanhandler.model.loan.ShortLoanRequest;
import vega.loanhandler.model.loan.SpecialLoanRequest;

public interface LoanRequestVisitor<T> {
    T visitShortLoanRequest(ShortLoanRequest shortLoanRequest);
    T visitLongLoanRequest(LongLoanRequest longLoanRequest);
    T visitSpecialLoanRequest(SpecialLoanRequest specialLoanRequest);
}
