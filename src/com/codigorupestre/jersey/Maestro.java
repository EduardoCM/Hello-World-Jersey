package com.codigorupestre.jersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Maestro {

	private int numeroCuenta;
	private String nombre;
	private String apellidos;
	private String materia;

	public Maestro() {
		
	}
	
	public Maestro(int numeroCuenta, String nombre, String apellidos, String materia) {
		this.numeroCuenta = numeroCuenta;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.materia = materia;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Alumno [numeroCuenta=" + numeroCuenta + ", nombre=" + nombre + ", apellidos=" + apellidos + ", materia="
				+ materia + "]";
	}
	
	

}