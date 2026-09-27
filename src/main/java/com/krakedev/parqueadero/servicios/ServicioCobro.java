package com.krakedev.parqueadero.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.parqueadero.modelo.TicketCobro;
import com.krakedev.parqueadero.modelo.Vehiculo;

@Service
public class ServicioCobro { //Servicio ServicioCobro (anotado con @Service):
	
	//Inyección de dependencia por constructor:
	private final ServicioVehiculos servicioVehiculos;
	public ServicioCobro(ServicioVehiculos servicioVehiculos) { this.servicioVehiculos = servicioVehiculos;}
	
	//Atributo: private ArrayList<TicketCobro> historicoTickets = new ArrayList<>();
	private ArrayList<TicketCobro> historicoTickets = new ArrayList<>();
	
//	public TicketCobro procesarSalida(String placa, int horas):
//		–
//		Invoca servicioVehiculos.retirarVehiculo(placa). Si retorna null, el método retorna null.
//		–
//		Si el vehículo existe, calcula la tarifa invocando directamente el método polimórfico:
//		double total = vehiculo.calcularTarifa(horas);
	
	public TicketCobro procesarSalida(String placa, int horas) {
        Vehiculo vehiculo = servicioVehiculos.retirarVehiculo(placa);
        if (vehiculo == null) {
            return null;
        }
        double total = vehiculo.calcularTarifa(horas);

        String codigo = "TCK-" + (int)(Math.random() * 900 + 100);
        TicketCobro ticket = new TicketCobro(codigo, vehiculo, horas, total);
        historicoTickets.add(ticket);
        return ticket;
    }
	
	
	//public double calcularTotalRecaudado(): 
	//Recorre historicoTickets con un ciclo acumulando la suma de todos los tickets cobrados.
	
	public double calcularTotalRecaudado() {
        double total = 0;
        for (TicketCobro t : historicoTickets) {
            total += t.getTotalPagar();
        }
        return total;
    }
	
	//public ArrayList listarTickets(): Retorna el historial de cobros.
	public ArrayList<TicketCobro> listarTickets() {
        return historicoTickets;
    }
	

}
