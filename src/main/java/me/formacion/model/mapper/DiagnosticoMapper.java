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
import me.formacion.model.DTO.DiagnosticoDTO;
import me.formacion.model.DTO.DiagnosticoWithIdDTO;
import me.formacion.service.CitaService;

@Mapper(componentModel = "spring",
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class DiagnosticoMapper {
	@Autowired
	private CitaService citaService;
	
	public abstract DiagnosticoDTO toDTO(Diagnostico m);
	public abstract DiagnosticoWithIdDTO toDTOWithId(Diagnostico m);
	public abstract Diagnostico toEntity(DiagnosticoWithIdDTO m);

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
}
