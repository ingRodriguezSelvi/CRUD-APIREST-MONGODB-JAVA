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
public Optional<Shape> x;
public Shape w;

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
		this.x= repository.findById(id);
		return x;
	}

	@PutMapping("/Shape/{id}")
	public Shape update(@PathVariable String id, @Validated @RequestBody Shape p) {
		return repository.save(p);
	}

	@DeleteMapping("/Shape/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}

	@GetMapping("area/{id}")
	public IShape readAll(@PathVariable String id){
		ShapeFactory factory=new ShapeFactory();
		IShape shape=null;
		this.x=repository.findById(id);
		this.w=this.x.get();

        if(this.w.type==null){
            throw new NoShapeTypeException("Shape type not valid");
        }
        switch(this.w.type){
        case CIRCLE:
			shape=factory.makeShape(this.w._id, this.w.type, null, null, this.w.diameter);	
        break;
		case TRIANGLE:
			shape=factory.makeShape(this.w._id, this.w.type, this.w.base, this.w.height, null);
		break;
		case SQUARE:
			shape=factory.makeShape(this.w._id,this.w.type,this.w.base,null,null);
		break;
		default:
			throw new NoShapeTypeException("Shape type not valid");
		}
		return shape;
	}
				
		
}
