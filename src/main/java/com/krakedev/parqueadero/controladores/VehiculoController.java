package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.parqueadero.modelo.Auto;
import com.krakedev.parqueadero.modelo.Motocicleta;
import com.krakedev.parqueadero.modelo.Vehiculo;
import com.krakedev.parqueadero.servicios.ServicioVehiculos;

@RestController
@RequestMapping("/vehiculos")

public class VehiculoController {//Parte 3: CONTROLADORES REST
	
	private final ServicioVehiculos servicioVehiculos;
	//Inyección por constructor de ServicioVehiculos
	public VehiculoController(ServicioVehiculos servicioVehiculos) {
        this.servicioVehiculos = servicioVehiculos;
    }
	
	//POST /vehiculos/auto: Recibe un @RequestBody Auto auto y 
	//devuelve mensaje o estado HTTP correspondiente.
	@PostMapping("/auto")
    public boolean ingresarAuto(@RequestBody Auto auto) {
        return servicioVehiculos.ingresarVehiculo(auto);
    }
	
	//POST /vehiculos/moto: Recibe un @RequestBody Motocicleta moto.
	@PostMapping("/moto")
    public boolean ingresarMoto(@RequestBody Motocicleta moto) {
        return servicioVehiculos.ingresarVehiculo(moto);
    }
	
	//GET /vehiculos: Retorna el listado completo de vehículos estacionados.
	@GetMapping
    public ArrayList<Vehiculo> listar() {
        return servicioVehiculos.listarVehiculos();
    }
	
	//GET /vehiculos/{placa}: Recibe la placa por @PathVariable y 
	//retorna el vehículo o estado 404 si no existe.
	@GetMapping("/{placa}")
    public ResponseEntity<Vehiculo> buscar(@PathVariable String placa) {
        Vehiculo vehiculo = servicioVehiculos.buscarPorPlaca(placa);
        if (vehiculo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehiculo);
    }
	

}
