package com.ito.musical.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Composicion implements Serializable,  Comparable<Composicion> {
	
	private static final long serialVersionUID = 8617825327524028291L;
	
	private String titulo;
	private Float duracion;
	private List<Interprete> interpretes;
	private String genero;
	private Date fechaRegistro;
	private Date fechaEstreno;
	
	public Composicion() {
		interpretes = new ArrayList<Interprete>();
	}
	
	public Composicion(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Float getDuracion() {
		return duracion;
	}
	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}
	public List<Interprete> getInterpretes() {
		return interpretes;
	}
	public void setInterpretes(List<Interprete> interpretes) {
		this.interpretes = interpretes;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	@Override
	public String toString() {
		return "Composicion [titulo=" + titulo + ", duracion=" + duracion + ", interpretes=" + interpretes + ", genero="
				+ genero + ", fechaRegistro=" + fechaRegistro + ", fechaEstreno=" + fechaEstreno + "]" + "\n";
	}

	@Override
	public int compareTo(Composicion o) {
		int  result = this.titulo.equals(o.getTitulo())  ?  0:  1;
		return result;
	}
	

}
