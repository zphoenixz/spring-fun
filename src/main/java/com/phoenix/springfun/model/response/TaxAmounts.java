package com.phoenix.springfun.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phoenix.springfun.model.enums.Category;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TaxAmounts {

    private BigDecimal cityTax;
    private BigDecimal countyTax;
    private BigDecimal stateTax;
    private BigDecimal federalTax;


    public TaxAmounts(final BigDecimal cityTax, final BigDecimal countyTax, final BigDecimal stateTax, final BigDecimal federalTax) {
        this.cityTax = cityTax;
        this.countyTax = countyTax;
        this.stateTax = stateTax;
        this.federalTax = federalTax;
    }

    public BigDecimal getTotalTaxes() {
        return cityTax.add(countyTax).add(stateTax).add(federalTax).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getCityTax() {
        return cityTax;
    }

    public void setCityTax(BigDecimal cityTax) {
        this.cityTax = cityTax;
    }

    public BigDecimal getCountyTax() {
        return countyTax;
    }

    public void setCountyTax(BigDecimal countyTax) {
        this.countyTax = countyTax;
    }

    public BigDecimal getStateTax() {
        return stateTax;
    }

    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }

    public BigDecimal getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(BigDecimal federalTax) {
        this.federalTax = federalTax;
    }
}
