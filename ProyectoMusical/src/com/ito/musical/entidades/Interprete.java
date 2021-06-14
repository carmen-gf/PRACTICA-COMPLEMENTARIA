package com.ito.musical.entidades;

import java.io.Serializable;

public class Interprete implements Serializable {
	
	private static final long serialVersionUID = -4939783796279912933L;
	private String nombre;
	
	public Interprete(String interprete) {
		this.nombre = interprete;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Interprete [nombre=" + nombre + "]";
	}

}
