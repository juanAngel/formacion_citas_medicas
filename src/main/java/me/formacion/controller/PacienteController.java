package me.formacion.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.formacion.error.NotFoundException;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;
import me.formacion.model.Usuario;
import me.formacion.model.DTO.MedicoDTO;
import me.formacion.model.DTO.MedicoWithIdDTO;
import me.formacion.model.DTO.PacienteDTO;
import me.formacion.model.DTO.PacienteWithIdDTO;
import me.formacion.model.mapper.CitaMapper;
import me.formacion.model.mapper.MedicoMapper;
import me.formacion.model.mapper.PacienteMapper;
import me.formacion.service.CitaService;
import me.formacion.service.MedicoService;
import me.formacion.service.PacienteService;

@RestController
@RequestMapping("/api/paciente/")
public class PacienteController {
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private MedicoMapper medicoMapper;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private PacienteMapper pacienteMapper;
	@Autowired
	private CitaService citaService;
	@Autowired
	private CitaMapper citaMapper;

	@PostMapping("/")
	PacienteWithIdDTO save(@RequestBody PacienteWithIdDTO pacienteDTO){
		if(pacienteDTO == null) {
			throw new InvalidParameterException();
		}
		Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
		pacienteService.save(paciente);
		pacienteDTO.setId(paciente.getId());
		
		
		return pacienteDTO;
	}
	
	@DeleteMapping("/{id}")
	void removePaciente(@PathVariable Long id){
		Paciente paciente = pacienteService.getOne(id);
		if(paciente == null) {
			throw new NotFoundException();
		}
		pacienteService.remove(paciente);
	}
	
	@GetMapping("/")
	List<PacienteWithIdDTO> getAll(){
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		Paciente[] pacientes = pacienteService.getAll();
		
		for (Paciente paciente : pacientes) {
			PacienteWithIdDTO m =  pacienteMapper.toDTOWithId(paciente);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	@GetMapping("/{id}")
	PacienteDTO getById(@PathVariable Long id){

		Paciente paciente = pacienteService.getOne(id);
		if(paciente == null) {
			throw new EntityNotFoundException();
		}
		return pacienteMapper.toDTO(paciente);
	}
	
	@GetMapping("/nombre/{name}")
	public List<PacienteWithIdDTO> findByNombre(@PathVariable String name) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		Paciente[] pacientes = pacienteService.findByNombre(name);
		
		for (Paciente paciente : pacientes) {
			PacienteWithIdDTO m =  pacienteMapper.toDTOWithId(paciente);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	@GetMapping("/apellidos/{name}")
	public List<PacienteWithIdDTO> findByApellidos(@PathVariable String apellidos) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		Paciente[] pacientes = pacienteService.findByApellidos(apellidos);
		
		for (Paciente paciente : pacientes) {
			PacienteWithIdDTO m =  pacienteMapper.toDTOWithId(paciente);
			medicosList.add(m);
		}
		
		return medicosList;
	}

	@GetMapping("/usuario/{name}")
	public List<PacienteWithIdDTO> findByUsuario(@PathVariable String usuario) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		Paciente[] pacientes = pacienteService.findByUsuario(usuario);
		
		for (Paciente paciente : pacientes) {
			PacienteWithIdDTO m =  pacienteMapper.toDTOWithId(paciente);
			medicosList.add(m);
		}
		
		return medicosList;
	}

	@GetMapping("/telefono/{telefono}")
	public List<PacienteWithIdDTO> findByTelefono(@PathVariable String telefono) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		Paciente[] pacientes = pacienteService.findByTelefono(telefono);
		
		for (Paciente paciente : pacientes) {
			PacienteWithIdDTO m =  pacienteMapper.toDTOWithId(paciente);
			medicosList.add(m);
		}
		
		return medicosList;
	}

	@GetMapping("/num_tarjeta/{numTarjeta}")
	public List<PacienteWithIdDTO> findByNumTarjeta(@PathVariable String numTarjeta) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		Paciente[] pacientes = pacienteService.findByNumTarjeta(numTarjeta);
		
		for (Paciente paciente : pacientes) {
			PacienteWithIdDTO m =  pacienteMapper.toDTOWithId(paciente);
			medicosList.add(m);
		}
		
		return medicosList;
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
