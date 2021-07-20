package com.ar.APIREST;

import com.ar.APIREST.exeptions.NoShapeTypeException;
import com.ar.APIREST.model.Circle;
import com.ar.APIREST.model.IShape;
import com.ar.APIREST.model.Shape;
import com.ar.APIREST.model.Square;
import com.ar.APIREST.model.Triangle;


public class ShapeFactory {
    
    public IShape makeShape(Shape shape)
    {
        IShape Ishape=null;

        if(shape.type==null){
            throw new NoShapeTypeException("Shape type not valid");
        }
        switch(shape.type){
        case CIRCLE:
            shape = new Circle(shape.diameter,shape._id);
        break;
        case TRIANGLE:
            shape= new Triangle(shape._id, shape.base, shape.height);
        break;
        case SQUARE:
            shape=new Square(shape._id,shape.base);
        break;    
		default:
			throw new NoShapeTypeException("Shape type not valid");
		}
        
        return Ishape;
    } 
}
