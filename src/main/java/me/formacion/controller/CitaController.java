package me.formacion.controller;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.formacion.model.Cita;
import me.formacion.model.DTO.CitaDTO;
import me.formacion.model.DTO.CitaWithIdDTO;
import me.formacion.model.mapper.CitaMapper;
import me.formacion.service.CitaService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cita/")
public class CitaController {
	@Autowired
	private CitaService citaService;
	@Autowired
	private CitaMapper citaMapper;
	
	@PostMapping("/")
	Long save(@RequestBody CitaWithIdDTO citaDTO){
		
		if(citaDTO == null) {
			throw new InvalidParameterException();
		}
		Long citaID = (long) 0;
		Cita cita = citaMapper.toEntity(citaDTO);
		citaService.save(cita);
		citaID = cita.getId();
		
		return citaID;
	}
	@GetMapping("/")
	List<CitaWithIdDTO> getAll(){
		ArrayList<CitaWithIdDTO> medicosList = new ArrayList<>();
		
		Cita[] citas = citaService.getAll();
		
		for (Cita cita : citas) {
			CitaWithIdDTO c =  citaMapper.toDTOWithId(cita);
			medicosList.add(c);
		}
		
		return medicosList;
	}
	@GetMapping("/:id")
	CitaDTO getById(@PathVariable Long id){

		Cita cita = citaService.getOne(id);
		if(cita == null) {
			throw new EntityNotFoundException();
		}
		return citaMapper.toDTO(cita);
	}
	@GetMapping("/at/:start/:end")
	public List<CitaWithIdDTO> getAtDate(@PathVariable Long start,@PathVariable Long end) {
		ArrayList<CitaWithIdDTO> citasDTO = new ArrayList<>();
		
		Date s = new Date(start), e = new Date(end);
		Cita[] citas = citaService.getAtDate(s, e);
		
		if(citas == null) {
			throw new InvalidParameterException();
		}
		for (Cita cita : citas) {
			citasDTO.add(citaMapper.toDTOWithId(cita));
		}
		
		return citasDTO;
	}
}
