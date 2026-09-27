package com.krakedev.parqueadero.modelo;

public class Auto extends Vehiculo {// subclase auto
	
	//Atributo privado: numeroPuertas (int).
	private int numeroPuertas;
	
	//Constructor que reciba placa, propietario, número de puertas e 
	//inicialice el padre con super(placa, propietario).
	public Auto(String placa, String propietario, int numeroPuertas) {
		super(placa, propietario);
		this.numeroPuertas=numeroPuertas;
	}
	
	//getters y seters
	public int getNumeroPuertas() {
		return numeroPuertas;
	}

	public void setNumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}
	
	//sobreescribir toString
	@Override
    public String toString() {
        return "Auto [placa=" + getPlaca() 
        + ", propietario=" + getPropietario()
        + ", numeroPuertas=" + numeroPuertas 
        + "]";
    }


//	Sobrescribir calcularTarifa(int horasPermanencia):
//		•
//		Tarifa regular: $1.50 por cada hora.
//		•
//		Si las horas de permanencia son estrictamente mayores a 4, 
//		sumar un recargo por estadía prolongada de $2.00 al total.

	@Override
	public double calcularTarifa(int horasPermanencia) {
		double total = 1.50*horasPermanencia;
		if(horasPermanencia>4) {
			total +=2.00;
		}
		return total;
	}
	
	
	
	
	
}
