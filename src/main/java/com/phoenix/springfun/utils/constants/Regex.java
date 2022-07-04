package com.phoenix.springfun.utils.constants;

public class Regex {
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final String TRIMMED_NO_BLANK_NUMBER_CURRENCY_NO_WHITESPACE = "^[0-9]{1,15}[.]{1,1}[0-9]{2,4}$";
    public static final String TRIMMED_NO_BLANK_NUMBER_MIN_1_MAX_15_W_NO_WHITESPACE = "^[0-9]{1,15}$";
    public static final String TRIMMED_NO_BLANK_NUMBER_MIN_1_MAX_30_W_NO_WHITESPACE = "^[0-9]{1,15}$";
    public static final String TRIMMED_NO_BLANK_MIN_1_MAX_90_W_WHITESPACE = "^.{1,90}$";
    public static final String TRIMMED_NO_BLANK_MIN_1_MAX_256_W_WHITESPACE = "^.{1,256}$";
    public static final String TRIMMED_NO_BLANK_MIN_1_MAX_15_W_NO_WHITESPACE = "^[\\S]{1,15}$";
    public static final String TRIMMED_NO_BLANK_MIN_1_MAX_30_W_NO_WHITESPACE = "^[\\S]{1,30}$";
    public static final String TRIMMED_NO_BLANK_MIN_1_MAX_90_W_NO_WHITESPACE = "^[\\S]{1,90}$";
    public static final String TRIMMED_NO_BLANK_MIN_1_MAX_256_W_NO_WHITESPACE = "^[\\S]{1,256}$";
    public static final String TRIMMED_NO_BLANK_MIN_5_MAX_90_W_WHITESPACE = "^[a-zA-Z0-9_ñ ]{5,90}$";
    public static final String CATEGORY = "^(COOKIES|CANDIES|CAKES|DESSERTS|DRINKS)$";
    public static final String STATUS = "^(PENDING|COMPLETED|REJECTED)$";
    public static final String BOOLEAN = "^true$|^false$";
}
