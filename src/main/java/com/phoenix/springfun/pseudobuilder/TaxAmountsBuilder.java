package com.phoenix.springfun.pseudobuilder;

import com.phoenix.springfun.model.response.TaxAmounts;
import com.phoenix.springfun.utils.config.ApplicationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class TaxAmountsBuilder {
    private final ApplicationProperties applicationProperties;
    public TaxAmountsBuilder(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public TaxAmounts buildTaxesAmounts(final BigDecimal subTotal){
        final BigDecimal cityTax = subTotal.multiply(new BigDecimal(applicationProperties.getCityTax())).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal countyTax = subTotal.add(cityTax).multiply(new BigDecimal(applicationProperties.getCountyTax())).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal stateTax = subTotal.add(cityTax).add(countyTax).multiply(new BigDecimal(applicationProperties.getStateTax())).setScale(2, RoundingMode.HALF_UP);
        final BigDecimal federalTax = subTotal.add(cityTax).add(countyTax).add(stateTax).multiply(new BigDecimal(applicationProperties.getFederalTax())).setScale(2, RoundingMode.HALF_UP);

        return new TaxAmounts(
                cityTax,
                countyTax,
                stateTax,
                federalTax
        );

    }
}
