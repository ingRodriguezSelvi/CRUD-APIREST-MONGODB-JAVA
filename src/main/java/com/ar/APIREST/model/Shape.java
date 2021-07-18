package com.ar.APIREST.model;



import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shapes")
public class Shape   {
	
	@Id
    @NonNull
	public String _id;
	
	public TypeShape type;
	
	public Double base;

	public Double height;

	public Double diameter;

	public Shape(String _id,TypeShape type, Double base, Double height, Double diameter) {
        this._id=_id;
		this.type = type;
		this.base = base;
		this.height = height;
		this.diameter = diameter;
	}
	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public TypeShape getType() {
		return type;
	}

	public void setType(TypeShape type) {
		this.type = type;
	}

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getDiameter() {
		return diameter;
	}

	public void setDiameter(Double diameter) {
		this.diameter = diameter;
	}
}
