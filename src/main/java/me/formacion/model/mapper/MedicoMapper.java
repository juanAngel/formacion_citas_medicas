package me.formacion.model.mapper;

import java.util.Date;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import me.formacion.model.Cita;
import me.formacion.model.Diagnostico;
import me.formacion.model.IUnique;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;
import me.formacion.model.DTO.MedicoDTO;
import me.formacion.model.DTO.MedicoWithIdDTO;
import me.formacion.service.CitaService;
import me.formacion.service.PacienteService;;

@Mapper(componentModel = "spring")
public abstract class MedicoMapper {
	@Autowired
	private CitaService citaService;
	@Autowired
	private PacienteService pacienteService;
	
	public abstract MedicoDTO toDTO(Medico m);
	public abstract MedicoWithIdDTO toDTOWithId(Medico m);
	public abstract Medico toEntity(MedicoWithIdDTO m);

	public abstract Set<Long> mapPacientes(Set<Paciente> value);
	public abstract Set<Long> mapCitas(Set<Cita> value);
	public abstract Set<Long> mapMedicos(Set<Medico> value);
	public abstract Set<Long> mapDiagnosticos(Set<Diagnostico> value);
	
	public Long map(IUnique value) {
		return value.getId();
	}
	public Long map(Date value) {
		return value.getTime();
	}
	public Cita getCita(Long id) {
		return citaService.getOne(id);
	}
	public Paciente getPaciente(Long id) {
		return pacienteService.getOne(id);
	}
	

}
