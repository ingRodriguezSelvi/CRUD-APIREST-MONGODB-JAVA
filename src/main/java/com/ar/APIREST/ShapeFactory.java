package com.ar.APIREST;

import com.ar.APIREST.exeptions.NoShapeTypeException;
import com.ar.APIREST.model.Circle;
import com.ar.APIREST.model.IShape;
import com.ar.APIREST.model.Shape;
import com.ar.APIREST.model.Square;
import com.ar.APIREST.model.Triangle;

public class ShapeFactory {

    public IShape makeShape(Shape inshape) {
        IShape shape = null;
        if (inshape.type == null) {
            throw new NoShapeTypeException("Shape type not valid");
        }
        switch (inshape.type) {
            case CIRCLE:
                shape = new Circle(inshape.diameter, inshape._id);
                break;
            case TRIANGLE:
                shape = new Triangle(inshape._id, inshape.base, inshape.height);
                break;
            case SQUARE:
                shape = new Square(inshape._id, inshape.base);
                break;
            default:
                throw new NoShapeTypeException("Shape type not valid");
        }
        return shape;
    }
}
