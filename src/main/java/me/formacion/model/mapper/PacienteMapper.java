package me.formacion.model.mapper;

import java.util.Date;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import me.formacion.model.Cita;
import me.formacion.model.Diagnostico;
import me.formacion.model.IUnique;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;
import me.formacion.model.DTO.MedicoWithIdDTO;
import me.formacion.model.DTO.PacienteDTO;
import me.formacion.model.DTO.PacienteWithIdDTO;
import me.formacion.service.CitaService;
import me.formacion.service.MedicoService;

@Mapper(componentModel = "spring",
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PacienteMapper {

	@Autowired
	private CitaService citaService;
	@Autowired
	private MedicoService medicoService;
	
	public abstract PacienteDTO toDTO(Paciente m);
	public abstract PacienteWithIdDTO toDTOWithId(Paciente m);
	public abstract Paciente toEntity(PacienteWithIdDTO p);

	public abstract Set<Long> mapPacientes(Set<Paciente> value);
	public abstract Set<Long> mapCitas(Set<Cita> value);
	public abstract Set<Long> mapMedicos(Set<Medico> value);
	public abstract Set<Long> mapDiagnosticos(Set<Diagnostico> value);
	
	public Long map(IUnique value) {
		if(value != null)
			return value.getId();
		return null;
	}
	public Long map(Date value) {
		if(value != null)
			return value.getTime();
		return null;
	}
	public Cita getCita(Long id) {
		return citaService.getOne(id);
	}
	public Medico getMedico(Long id) {
		return medicoService.getOne(id);
	}
}
