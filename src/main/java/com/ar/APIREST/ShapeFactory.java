package com.ar.APIREST;

import com.ar.APIREST.exeptions.NoShapeTypeException;
import com.ar.APIREST.model.Circle;
import com.ar.APIREST.model.IShape;
import com.ar.APIREST.model.Square;
import com.ar.APIREST.model.Triangle;
import com.ar.APIREST.model.TypeShape;

public class ShapeFactory {
    
    public IShape makeShape(String _id,TypeShape type, Double base, Double height, Double diameter)
    {
        IShape shape=null;

        if(type==null){
            throw new NoShapeTypeException("Shape type not valid");
        }

        switch(type){
        case CIRCLE:
            shape = new Circle(diameter,_id);
        break;
        case TRIANGLE:
            shape= new Triangle(_id, base, height);
        break;
        case SQUARE:
            shape=new Square(_id,base);
        break;    
		default:
			throw new NoShapeTypeException("Shape type not valid");
		}
        

        return shape;
    } 
}
