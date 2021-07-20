package com.ar.APIREST.model;

public class Triangle extends Shape implements IShape {
    public Triangle(String _id,Double base,Double height ){
        super(_id,TypeShape.TRIANGLE,base,height,null);
    }

    public Double getArea(){
        return (this.getBase()*this.getHeight())/2;
    }
    
}
