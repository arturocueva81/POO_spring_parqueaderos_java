package com.krakedev.parqueadero.modelo;

import java.time.LocalDateTime;

public abstract class Vehiculo { //1. clase abstracta vehiculo
	
	// atributos privados
	private String placa;
	private String propietario;
	private LocalDateTime horaIngreso;
	
	//Constructor que reciba placa y propietario. 
	//El atributo horaIngreso debe asignarse internamente con LocalDateTime.now().
	public Vehiculo(String placa, String propietario) {
		super();
		this.placa = placa;
		this.propietario = propietario;
		this.horaIngreso = LocalDateTime.now();
	}
	
	//Métodos getters, setters y 
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	
	//sobrescritura de toString().
	
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa 
				+ ", propietario=" + propietario 
				+ ", horaIngreso=" + horaIngreso 
				+ "]";
	}

	//Método abstracto obligatorio: public abstract double calcularTarifa(int horasPermanencia);
	public abstract double calcularTarifa(int horasPermanencia);
	
	

}
