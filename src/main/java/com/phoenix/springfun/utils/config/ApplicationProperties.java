package com.phoenix.springfun.utils.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties
public class ApplicationProperties {
    @Value(value = "${taxes.city}")
    private Double cityTax;

    @Value(value = "${taxes.county}")
    private Double countyTax;

    @Value(value = "${taxes.state}")
    private Double stateTax;

    @Value(value = "${taxes.federal}")
    private Double federalTax;

    public ApplicationProperties() {
        this.cityTax = null;
        this.countyTax = null;
        this.stateTax = null;
        this.federalTax = null;
    }

    public Double getCityTax() {
        return cityTax;
    }

    public Double getCountyTax() {
        return countyTax;
    }

    public Double getStateTax() {
        return stateTax;
    }

    public Double getFederalTax() {
        return federalTax;
    }


}
