package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.parqueadero.modelo.TicketCobro;
import com.krakedev.parqueadero.servicios.ServicioCobro;

@RestController
@RequestMapping("/cobros")
public class CobroController {
	
	private final ServicioCobro servicioCobro;
	
	//Inyección por constructor de ServicioCobro.
	public CobroController(ServicioCobro servicioCobro) {
        this.servicioCobro = servicioCobro;
    }
	
	//POST /cobros/procesar/{placa}/{horas}: 
	//Procesa la salida del vehículo y devuelve el ticket generado en formato JSON.
	@PostMapping("/procesar/{placa}/{horas}")
    public TicketCobro procesarSalida(@PathVariable String placa, @PathVariable int horas) {
        return servicioCobro.procesarSalida(placa, horas);
    }
	
	//GET /cobros/total: Retorna el monto acumulado total recaudado.
	@GetMapping("/total")
    public double totalRecaudado() {
        return servicioCobro.calcularTotalRecaudado();
    }
	
	//GET /cobros/historial: Retorna la lista de todos los tickets emitidos.
	@GetMapping("/historial")
    public ArrayList<TicketCobro> historial() {
        return servicioCobro.listarTickets();
    }
	
}
