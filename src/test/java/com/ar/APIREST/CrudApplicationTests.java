package com.ar.APIREST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.ar.APIREST.exeptions.NoShapeTypeException;
import com.ar.APIREST.model.Circle;
import com.ar.APIREST.model.IShape;
import com.ar.APIREST.model.Shape;
import com.ar.APIREST.model.Square;
import com.ar.APIREST.model.Triangle;
import com.ar.APIREST.model.TypeShape;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShapeApplicationTest {

	@Test
	public void testCircleShape() {
		Shape shape = new Shape("IdTest0001", TypeShape.CIRCLE, 40d, 780d, 20d);
		ShapeFactory factory = new ShapeFactory();
		IShape circle = factory.makeShape(shape);

		assertTrue(circle instanceof Circle);
		assertNull(circle.getBase());
		assertNull(circle.getHeight());
		assertEquals(20d, circle.getDiameter());
		assertEquals((Math.PI * Math.pow(20d / 2, 2)), circle.getArea());
	}

	@Test
	public void testTriangleShape() {
		Shape shape = new Shape("IdTest0001", TypeShape.TRIANGLE, 40d, 780d, 20d);
		ShapeFactory factory = new ShapeFactory();
		IShape triangle = factory.makeShape(shape);

		assertTrue(triangle instanceof Triangle);
		assertEquals(40d, triangle.getBase());
		assertEquals(780d, triangle.getHeight());
		assertNull(triangle.getDiameter());
		Double expectedArea = (triangle.getBase() * triangle.getHeight()) / 2;
		assertEquals(expectedArea, triangle.getArea());
	}

	@Test
	public void testSquareShape() {
		Shape shape = new Shape(null, TypeShape.SQUARE, 40d, 780d, 20d);
		ShapeFactory factory = new ShapeFactory();
		IShape square = factory.makeShape(shape);

		assertTrue(square instanceof Square);
		assertEquals(40d, square.getBase());
		assertNull(square.getHeight());
		assertNull(square.getDiameter());
		Double expectedArea = square.getBase() * square.getBase();
		assertEquals(expectedArea, square.getArea());
	}

	@Test
	public void testNoShapeTypeException() {
		Shape shape = new Shape("IdTest0001", null, 40d, 780d, 20d);
		ShapeFactory factory = new ShapeFactory();
		try {
			factory.makeShape(shape);
			fail();
		} catch (NoShapeTypeException e) {
			String message = "Shape type not valid";
			assertEquals(e.getMessage(), message);
		}
	}

}
