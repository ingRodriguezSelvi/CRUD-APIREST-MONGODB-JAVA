package com.ar.APIREST.model;

public class Square extends Shape implements IShape {
    public Square(String _id, Double base) {
        super(_id, TypeShape.SQUARE, base, null, null);
    }

    public Double getArea() {
        return this.getBase() * this.getBase();
    }
}
