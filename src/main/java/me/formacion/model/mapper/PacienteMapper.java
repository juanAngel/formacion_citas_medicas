package me.formacion.model.mapper;

import java.util.Date;
import java.util.Set;

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

public abstract class PacienteMapper {

	@Autowired
	private CitaService citaService;
	@Autowired
	private MedicoService medicoService;
	
	public abstract PacienteDTO toDTO(Paciente m);
	public abstract PacienteWithIdDTO toDTOWithId(Paciente m);
	public abstract Paciente toEntity(MedicoWithIdDTO m);

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
	public Medico getMedico(Long id) {
		return medicoService.getOne(id);
	}
}
