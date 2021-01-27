package me.formacion.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@SuppressWarnings("unused")
	@Autowired
	private MedicoService medicoService;
	@SuppressWarnings("unused")
	@Autowired
	private MedicoMapper medicoMapper;
	@Autowired
	private PacienteService pacienteService;
	@SuppressWarnings("unused")
	@Autowired
	private PacienteMapper pacienteMapper;
	@SuppressWarnings("unused")
	@Autowired
	private CitaService citaService;
	@SuppressWarnings("unused")
	@Autowired
	private CitaMapper citaMapper;

	@PostMapping("/")
	Long save(@RequestBody PacienteWithIdDTO pacienteDTO){
		
		if(pacienteDTO == null) {
			throw new InvalidParameterException();
		}
		Long pacienteId = (long) 0;
		Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
		pacienteService.save(paciente);
		pacienteId = paciente.getId();
		
		
		return pacienteId;
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
		
		return medicosList;
	}
	
	@GetMapping("/apellidos/{name}")
	public List<PacienteWithIdDTO> findByApellidos(@PathVariable String apellidos) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		return medicosList;
	}

	@GetMapping("/usuario/{name}")
	public List<PacienteWithIdDTO> findByUsuario(@PathVariable String usuario) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		return medicosList;
	}

	@GetMapping("/telefono/{telefono}")
	public List<PacienteWithIdDTO> findByTelefono(@PathVariable String telefono) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
		return medicosList;
	}

	@GetMapping("/num_tarjeta/{numTarjeta}")
	public List<PacienteWithIdDTO> findByNumTarjeta(@PathVariable String numTarjeta) {
		ArrayList<PacienteWithIdDTO> medicosList = new ArrayList<>();
		
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
