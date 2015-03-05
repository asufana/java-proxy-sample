package com.github.asufana;

public class SomeEntity {
    private final String valueObject;
    
    public SomeEntity(final String value) {
        valueObject = value;
    }
    
    public String value() {
        return valueObject;
    }
}
