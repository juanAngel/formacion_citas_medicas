package me.formacion.model.mapper;

import java.util.Date;
import java.util.Set;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import me.formacion.model.Cita;
import me.formacion.model.Diagnostico;
import me.formacion.model.IUnique;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;
import me.formacion.model.DTO.CitaDTO;
import me.formacion.model.DTO.CitaWithIdDTO;
import me.formacion.service.CitaService;
import me.formacion.service.DiagnosticoService;
import me.formacion.service.MedicoService;
import me.formacion.service.PacienteService;

@Mapper(componentModel = "spring")
public abstract class CitaMapper {

	@Autowired
	private DiagnosticoService diagnosticoService;
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private MedicoService medicoService;
	
	public abstract CitaDTO toDTO(Cita m);
	public abstract CitaWithIdDTO toDTOWithId(Cita m);
	public abstract Cita toEntity(CitaWithIdDTO m);

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
	public abstract Date mapDate(Long value);
	
	public Diagnostico getDiagnostico(Long id) {
		return diagnosticoService.getOne(id);
	}
	public Paciente getPaciente(Long id) {
		return pacienteService.getOne(id);
	}
	public Medico getMedico(Long id) {
		return medicoService.getOne(id);
	}
}
