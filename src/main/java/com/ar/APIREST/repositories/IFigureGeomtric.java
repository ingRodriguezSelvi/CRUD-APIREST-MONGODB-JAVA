package com.ar.APIREST.repositories;

import com.ar.APIREST.model.Shape;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFigureGeomtric extends MongoRepository<Shape, String> {

}
