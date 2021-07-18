package com.ar.APIREST.model;


public enum TypeShape {
    
    TRIANGLE("TRIANGLE"),
    SQUARE("SQUARE"),
    CIRCLE("CIRCLE");

    private final String name;
    
    TypeShape(String s){
        this.name=s;
    }
    public String getName() {
        return name;
    }
}
