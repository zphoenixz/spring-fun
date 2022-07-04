package com.phoenix.springfun.model.enums;




public enum Category {
    COOKIES,
    CANDIES,
    CAKES,
    DESSERTS,
    DRINKS;

    public static Category fromText(String text){
        for(Category r : Category.values()){
            if(r.toString().equals(text)){
                return r;
            }
        }
//        throw new IllegalArgumentException();
        return null;
    }
}
