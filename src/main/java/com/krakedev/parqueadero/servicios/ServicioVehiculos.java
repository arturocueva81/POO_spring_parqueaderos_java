package com.krakedev.parqueadero.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.parqueadero.modelo.Vehiculo;

@Service
public class ServicioVehiculos {//Servicio ServicioVehiculos (anotado con @Service)
	
	//Atributo: private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
	private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
	
	//Constante: private final int CAPACIDAD_MAXIMA = 10;
	private final int CAPACIDAD_MAXIMA = 10;
	
	//public Vehiculo buscarPorPlaca(String placa): Recorre el ArrayList con un 
	//bucle for tradicional o enhanced for y retorna el vehículo encontrado; si no existe, 
	//retorna null.
	public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : parqueadero) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }
	
	//public boolean ingresarVehiculo(Vehiculo vehiculo):
		//Valida que no se supere la CAPACIDAD_MAXIMA.
		//Valida que la placa no esté duplicada usando buscarPorPlaca().
		//Retorna true si se pudo agregar al ArrayList, false si el cupo está lleno o la placa ya existe.
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
        if (parqueadero.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }
        if (buscarPorPlaca(vehiculo.getPlaca()) != null) {
            return false;
        }
        parqueadero.add(vehiculo);
        return true;
    }
	
	//public Vehiculo retirarVehiculo(String placa): Busca el vehículo por placa; si existe, 
	//lo remueve de la lista con .remove() y lo retorna. Si no existe, retorna null.
	public Vehiculo retirarVehiculo(String placa) {
        Vehiculo vehiculo = buscarPorPlaca(placa);
        if (vehiculo != null) {
            parqueadero.remove(vehiculo);
            return vehiculo;
        }
        return null;
    }
	
	//public ArrayList listarVehiculos(): Retorna la lista actual de vehículos estacionados.
	public ArrayList<Vehiculo> listarVehiculos() {
        return parqueadero;
    }
	
	
}
