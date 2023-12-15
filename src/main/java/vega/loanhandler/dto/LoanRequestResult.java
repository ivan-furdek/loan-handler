package vega.loanhandler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoanRequestResult {
    private final boolean IsLoanAccepted;
}
