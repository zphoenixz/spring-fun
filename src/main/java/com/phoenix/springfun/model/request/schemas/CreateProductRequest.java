package com.phoenix.springfun.model.request.schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phoenix.springfun.model.enums.Category;
import com.phoenix.springfun.utils.constants.Regex;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateProductRequest {

    @NotNull(message = "A name field is required")
    @Pattern(regexp = Regex.TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE)
    private String name;

    @NotNull(message = "A category field is required")
    @Pattern(regexp = Regex.CATEGORY)
    private String category;

    @NotNull(message = "A unitPrice field is required")
    @DecimalMin("0.0")
    private Double unitPrice;

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return Category.fromText(category);
    }

    public Double getUnitPrice() {
        return unitPrice;
    }
}
