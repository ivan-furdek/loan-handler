package vega.loanhandler.service;

import org.springframework.stereotype.Service;
import vega.loanhandler.model.loan.LoanRequest;
import vega.loanhandler.visitor.LoanRequestValidationVisitor;

@Service
public class LoanService {

    private final LoanRequestValidationVisitor loanRequestValidationVisitor;

    public LoanService(LoanRequestValidationVisitor loanRequestValidationVisitor) {
        this.loanRequestValidationVisitor = loanRequestValidationVisitor;
    }

    public boolean RequestLone(LoanRequest loanRequest) {
        return loanRequest.accept(loanRequestValidationVisitor);
    }
}

