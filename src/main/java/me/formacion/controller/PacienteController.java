package me.formacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.formacion.model.Paciente;

@RestController
@RequestMapping("/api/paciente/")
public class PacienteController {

	@GetMapping("/all")
	List<Paciente> getAll(){
		//Medico medico = new Medico("pepe","sanchez","pepe96","1234","00000");
		ArrayList<Paciente> list = new ArrayList<>();
		//list.add(medico);
		
		return list;
	}
	
	@GetMapping("/hello")
    String home() {
        return "Hello World!";
    }
	@GetMapping("/test")
	String test() {
		return "paciente test";
	}
}
