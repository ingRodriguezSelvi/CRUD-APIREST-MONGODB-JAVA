package com.ar.APIREST.controllers;

import java.util.List;
import java.util.Optional;

import com.ar.APIREST.ShapeFactory;
import com.ar.APIREST.exeptions.NoShapeTypeException;
import com.ar.APIREST.model.IShape;
import com.ar.APIREST.model.Shape;

import com.ar.APIREST.repositories.IFigureGeomtric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE })
@RequestMapping("/api/Shape")
public class FigureGeometricController {
public Optional<Shape> shape;
public Shape shapeArea;

	@Autowired
	private IFigureGeomtric repository;

	@PostMapping("/addShape")
	public Shape create(@Validated @RequestBody Shape p) {
		return repository.insert(p);
	}

	@GetMapping("/")
	public List<Shape> readAll() {
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public  Optional<Shape> readId(@PathVariable String id) {
		this.shape= repository.findById(id);
		return shape;
	}

	@PutMapping("/{id}")
	public Shape update(@PathVariable String id, @Validated @RequestBody Shape p) {
		return repository.save(p);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}

	@GetMapping("area/{id}")
	public IShape readAll(@PathVariable String id){
		ShapeFactory factory=new ShapeFactory();
		IShape shape=null;
		this.shape=repository.findById(id);
		this.shapeArea=this.shape.get();	
        if(this.shapeArea.type==null){
            throw new NoShapeTypeException("Shape type not valid");
        }else{
			shape=factory.makeShape(this.shapeArea);
		} 
		return shape;
	}		
}
