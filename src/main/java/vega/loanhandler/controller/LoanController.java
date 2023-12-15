package vega.loanhandler.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vega.loanhandler.converter.LoanDtoToLoanConverter;
import vega.loanhandler.dto.LoanRequestDto;
import vega.loanhandler.dto.LoanRequestResult;
import vega.loanhandler.service.LoanService;

@RestController
@RequestMapping("/loan-request")
public class LoanController {

    private final LoanService loanService;
    private final LoanDtoToLoanConverter converter;

    public LoanController(LoanService loanService, LoanDtoToLoanConverter converter) {
        this.loanService = loanService;
        this.converter = converter;
    }

    @PostMapping
    public LoanRequestResult requestLoan(@RequestBody LoanRequestDto loanRequestDto) {
        var request = converter.convert(loanRequestDto);

        return new LoanRequestResult(loanService.RequestLone(request));
    }
}
