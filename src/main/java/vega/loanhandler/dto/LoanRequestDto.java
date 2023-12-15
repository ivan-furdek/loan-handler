package vega.loanhandler.dto;

import vega.loanhandler.model.RequesterOccupation;
import vega.loanhandler.model.loan.LoanRequest;

import java.time.LocalDate;

public record LoanRequestDto(
        LoanRequestType loanRequestType,
        String account,
        LocalDate startAt,
        LocalDate endAt,
        Integer sumRequested,
        RequesterOccupation requesterOccupation) {

    public LoanRequest toDomain() {
        return loanRequestType.mapperForType.apply(this);
    }
}
