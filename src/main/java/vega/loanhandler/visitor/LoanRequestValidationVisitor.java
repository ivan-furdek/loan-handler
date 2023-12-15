package vega.loanhandler.visitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vega.loanhandler.model.RequesterOccupation;
import vega.loanhandler.model.loan.LongLoanRequest;
import vega.loanhandler.model.loan.ShortLoanRequest;
import vega.loanhandler.model.loan.SpecialLoanRequest;

import java.time.Period;

@Slf4j
@Component
public class LoanRequestValidationVisitor implements LoanRequestVisitor<Boolean> {

    @Override
    public Boolean visitShortLoanRequest(ShortLoanRequest shortLoanRequest) {
        return !shortLoanRequest.getTerm().isLongerThan(Period.ofYears(1)) &&
                shortLoanRequest.getSumRequested() > 0 &&
                shortLoanRequest.getSumRequested() <= 2000;
    }

    @Override
    public Boolean visitLongLoanRequest(LongLoanRequest longLoanRequest) {
        return longLoanRequest.getTerm().isBetween(Period.ofYears(1), Period.ofYears(3)) &&
                longLoanRequest.getSumRequested() > 0 &&
                longLoanRequest.getSumRequested() <= 4000 &&
                longLoanRequest.getRequesterOccupation() != RequesterOccupation.PRODUCT_MANAGER;
    }

    @Override
    public Boolean visitSpecialLoanRequest(SpecialLoanRequest specialLoanRequest) {
        var isValid = !specialLoanRequest.getTerm().isLongerThan(Period.ofYears(5)) &&
                specialLoanRequest.getSumRequested() > 0 &&
                specialLoanRequest.getSumRequested() <= 10000 &&
                specialLoanRequest.getRequesterOccupation() == RequesterOccupation.PROGRAMMER;

        if (isValid && specialLoanRequest.getSumRequested() > 5000) log.warn("Big special loan!");

        return isValid;
    }
}
