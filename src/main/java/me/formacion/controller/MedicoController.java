package me.formacion.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.omg.CosNaming.NamingContextPackage.NotFoundReasonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.formacion.error.NotFoundException;
import me.formacion.model.*;
import me.formacion.model.DTO.CitaDTO;
import me.formacion.model.DTO.CitaWithIdDTO;
import me.formacion.model.DTO.MedicoDTO;
import me.formacion.model.DTO.MedicoWithIdDTO;
import me.formacion.model.mapper.CitaMapper;
import me.formacion.model.mapper.MedicoMapper;
import me.formacion.model.mapper.PacienteMapper;
import me.formacion.service.CitaService;
import me.formacion.service.MedicoService;
import me.formacion.service.PacienteService;

@RestController
@RequestMapping("/api/medico/")
public class MedicoController {
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private MedicoMapper medicoMapper;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private CitaService citaService;
	@Autowired
	private CitaMapper citaMapper;
	
	@PostMapping("/")
	Long save(@RequestBody MedicoWithIdDTO medicoDTO){		
		if(medicoDTO == null) {
			throw new InvalidParameterException();
		}
		Long medicoId = (long) 0;
		Medico medico = medicoMapper.toEntity(medicoDTO);
		medicoService.save(medico);
		medicoId = medico.getId();
		
		
		return medicoId;
	}
	@GetMapping("/")
	List<MedicoWithIdDTO> getAll(){
		ArrayList<MedicoWithIdDTO> medicosList = new ArrayList<>();
		
		Medico[] medicos = medicoService.getAll();
		
		for (Medico medico : medicos) {
			MedicoWithIdDTO m =  medicoMapper.toDTOWithId(medico);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	@GetMapping("/{id}")
	MedicoDTO getById(@PathVariable Long id){
		Medico medico = medicoService.getOne(id);
		if(medico == null) {
			throw new NotFoundException();
		}
		return medicoMapper.toDTO(medico);
	}
	
	@DeleteMapping("/{id}")
	void removeMedico(@PathVariable Long id){
		Medico medico = medicoService.getOne(id);
		if(medico == null) {
			throw new NotFoundException();
		}
		medicoService.remove(medico);
	}
	
	@PostMapping("/{medicoID}/paciente/add/")
	MedicoDTO addPaciente(@PathVariable Long medicoID,@RequestBody Long pacienteID) {
		Medico m = medicoService.getOne(medicoID);
		Paciente p = pacienteService.getOne(pacienteID);
		if(m == null || p == null) {
			throw new NotFoundException();
		}
		m = medicoService.addPaciente(m, p);
		
		return medicoMapper.toDTO(m);
	}
	
	@DeleteMapping("/{medicoID}/paciente/remove/")
	void removePaciente(@PathVariable Long medicoID,@RequestBody Long pacienteID) {
		Medico m = medicoService.getOne(medicoID);
		Paciente p = pacienteService.getOne(pacienteID);
		
		if(m == null || p == null) {
			throw new NotFoundException();
		}
		m = medicoService.removePaciente(m, p);
	}
	
	@PostMapping("/{medicoID}/{pacienteID}/cita/add/")
	CitaDTO addCita(@PathVariable Long medicoID,@PathVariable Long pacienteID, @RequestBody CitaWithIdDTO cita) {
		CitaDTO citaDTO = null;
		Medico m = medicoService.getOne(medicoID);
		Paciente p = pacienteService.getOne(pacienteID);
		cita.setMedico(0);
		cita.setPaciente(0);
		
		Cita c = citaMapper.toEntity(cita);
		
		if(cita == null || p == null || m == null){
			throw new NotFoundException();
		}
		citaService.save(c);
		medicoService.addCita(m, p, c);
		
		return citaDTO;
	}
	
	@DeleteMapping("/cita/remove/")
	void removeCita(@RequestBody Long citaID) {
		Cita c = citaService.getOne(citaID);
		
		if(c == null)
			throw new NotFoundException();
		citaService.remove(c);
	}
	
	@GetMapping("/nombre/{name}")
	public List<MedicoWithIdDTO> findByNombre(@PathVariable String name) {
		ArrayList<MedicoWithIdDTO> medicosList = new ArrayList<>();

		Medico[] medicos = medicoService.findByNombre(name);
		for (Medico medico : medicos) {
			MedicoWithIdDTO m =  medicoMapper.toDTOWithId(medico);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	@GetMapping("/apellidos/{name}")
	public List<MedicoWithIdDTO> findByApellidos(@PathVariable String apellidos) {
		ArrayList<MedicoWithIdDTO> medicosList = new ArrayList<>();

		Medico[] medicos = medicoService.findByApellidos(apellidos);
		for (Medico medico : medicos) {
			MedicoWithIdDTO m =  medicoMapper.toDTOWithId(medico);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	@GetMapping("/usuario/{name}")
	public List<MedicoWithIdDTO>  findByUsuario(@PathVariable String usuario) {
		ArrayList<MedicoWithIdDTO> medicosList = new ArrayList<>();

		Medico[] medicos = medicoService.findByUsuario(usuario);
		for (Medico medico : medicos) {
			MedicoWithIdDTO m =  medicoMapper.toDTOWithId(medico);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	@GetMapping("/num_colegiado/{name}")
	public List<MedicoWithIdDTO>  findByNumColegiado(@PathVariable String numColegiado) {
		ArrayList<MedicoWithIdDTO> medicosList = new ArrayList<>();

		Medico[] medicos = medicoService.findByNumColegiado(numColegiado);
		for (Medico medico : medicos) {
			MedicoWithIdDTO m =  medicoMapper.toDTOWithId(medico);
			medicosList.add(m);
		}
		
		return medicosList;
	}
	
	/*
	
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
	}*/
	
}
