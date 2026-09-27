package com.krakedev.parqueadero.modelo;

public class Motocicleta extends Vehiculo { //3.Subclase Motocicleta (hereda de Vehiculo):
	
	//Atributo privado: cilindraje (int).
	private int cilindraje;

	//Constructor con llamada a super(…).
	public Motocicleta(String placa, String propietario, int cilindraje) {
		super(placa, propietario);
		this.cilindraje=cilindraje;
	}
	
	//geters y setters
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	//sobreescribir toString
	@Override
    public String toString() {
        return "Motocicleta [placa=" + getPlaca() 
        + ", propietario=" + getPropietario()
        + ", cilindraje=" + cilindraje 
        + "cc]";
    }
	
//	Sobrescribir calcularTarifa(int horasPermanencia):
//		•
//		Tarifa regular: $0.75 por cada hora.
//		•
//		Si el cilindraje es mayor a 250 cc, 
//	    la tarifa por hora cambia automáticamente a $1.00 por hora.
	
	@Override
	public double calcularTarifa(int horasPermanencia) {
		double tarifaRegular;
		if(cilindraje>250) {
		 tarifaRegular=1.00;
		} else {
			tarifaRegular=0.75;
		}
		return tarifaRegular;
	}
	
	
	

	
}
