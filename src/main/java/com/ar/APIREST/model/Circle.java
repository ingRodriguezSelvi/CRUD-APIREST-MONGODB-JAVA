package com.ar.APIREST.model;

public class Circle extends Shape implements IShape {

    public Circle(Double diameter, String _id) {
        super(_id, TypeShape.CIRCLE, null, null, diameter);
    }

    public Double getArea() {
        return Math.PI * Math.pow(this.getDiameter() / 2, 2);
    }
}
