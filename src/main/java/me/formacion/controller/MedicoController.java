package me.formacion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.formacion.model.*;
import me.formacion.service.CitaService;
import me.formacion.service.MedicoService;
import me.formacion.service.PacienteService;

@RestController
@RequestMapping("/api/medico/")
public class MedicoController {
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private CitaService citaService;
	@GetMapping("/all")
	List<Medico> getAll(){
		Medico medico = new Medico("pepe","sanchez","pepe96","1234","00000");
		ArrayList<Medico> list = new ArrayList<>();
		list.add(medico);
		
		return list;
	}
	
	@GetMapping("/hello")
    String home() {
		
		Medico medico = medicoService.save(new Medico("pepe","sanchez","pepe96","1234","00000"));
		Paciente paciente = pacienteService.save(new Paciente("pepe","sanchez","pepe96","1234", null, null, null, null));
		
		medicoService.addPaciente(medico, paciente);
		
		
        return "Hello World!";
    }
	@GetMapping("/test")
	String test() {
		return "medico test";
	}
	
}
