package me.formacion.DAO;

import me.formacion.model.Paciente;
import me.formacion.model.Usuario;

public interface IPacienteDAO extends IUsuarioDAO{
	Paciente merge(Usuario p);
	Paciente[] findByTelefono(String telefono);
	Paciente[] findByNumTarjeta(String numTarjeta);
}
