package vega.loanhandler.dto;

import vega.loanhandler.model.DateRange;
import vega.loanhandler.model.loan.LoanRequest;
import vega.loanhandler.model.loan.LongLoanRequest;
import vega.loanhandler.model.loan.ShortLoanRequest;
import vega.loanhandler.model.loan.SpecialLoanRequest;

import java.util.function.Function;

public enum LoanRequestType {
    SHORT(loanRequestDto -> new ShortLoanRequest(
            loanRequestDto.account(),
            new DateRange(loanRequestDto.startAt(), loanRequestDto.endAt()),
            loanRequestDto.sumRequested(),
            loanRequestDto.requesterOccupation())
    ),
    LONG(loanRequestDto -> new LongLoanRequest(
            loanRequestDto.account(),
            new DateRange(loanRequestDto.startAt(), loanRequestDto.endAt()),
            loanRequestDto.sumRequested(),
            loanRequestDto.requesterOccupation())
    ),
    SPECIAL(loanRequestDto -> new SpecialLoanRequest(
            loanRequestDto.account(),
            new DateRange(loanRequestDto.startAt(), loanRequestDto.endAt()),
            loanRequestDto.sumRequested(),
            loanRequestDto.requesterOccupation())
    );

    public final Function<LoanRequestDto, LoanRequest> mapperForType;

    LoanRequestType(Function<LoanRequestDto, LoanRequest> loanHandler) {
        this.mapperForType = loanHandler;
    }
}
