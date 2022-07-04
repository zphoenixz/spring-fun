package com.phoenix.springfun.model.request.schemas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.phoenix.springfun.model.enums.Category;
import com.phoenix.springfun.utils.constants.Regex;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Optional;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatchProductRequest {

    @Pattern(regexp = Regex.TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE)
    private String name;

    @Pattern(regexp = Regex.CATEGORY)
    private String category;

    @DecimalMin("0.0")
    private Double unitPrice;

    @Pattern(regexp = Regex.BOOLEAN)
    private String active;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public Optional<Category> getCategory() {
        return Optional.ofNullable(Category.fromText(category));
    }

    public Optional<Double> getUnitPrice() {
        return Optional.ofNullable(unitPrice);
    }

    public Optional<Boolean> getActive() {
        return Optional.ofNullable(Boolean.valueOf(active));
    }
}
