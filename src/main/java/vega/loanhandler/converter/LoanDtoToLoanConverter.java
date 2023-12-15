package vega.loanhandler.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import vega.loanhandler.dto.LoanRequestDto;
import vega.loanhandler.model.loan.LoanRequest;

@Component
public class LoanDtoToLoanConverter implements Converter<LoanRequestDto, LoanRequest> {

    @Override
    public LoanRequest convert(LoanRequestDto source) {
        return source.toDomain();
    }
}
