package com.phoenix.springfun.model.enums;




public enum OrderStatus {
    PENDING,
    COMPLETED,
    REJECTED;

    public static OrderStatus fromText(String text){
        for(OrderStatus r : OrderStatus.values()){
            if(r.toString().equals(text)){
                return r;
            }
        }
//        throw new IllegalArgumentException();
        return null;
    }
}
