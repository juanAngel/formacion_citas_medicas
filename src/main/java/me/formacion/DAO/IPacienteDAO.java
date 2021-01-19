package me.formacion.DAO;

import me.formacion.model.Paciente;

public interface IPacienteDAO extends IUsuarioDAO{
	Paciente[] findByTelefono(String telefono);
	Paciente[] findByNumTarjeta(String numTarjeta);
}
