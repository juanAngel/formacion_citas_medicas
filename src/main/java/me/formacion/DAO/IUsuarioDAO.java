package me.formacion.DAO;

import me.formacion.model.Usuario;

public interface IUsuarioDAO {
	Usuario getById(Long id);
	Usuario[] getAll();
	void store(Usuario p);
	void remove(Usuario p);

	Usuario[] findByNombre(String name);
	Usuario[] findByApellidos(String apellidos);
	Usuario[] findByUsuario(String usuario);
}
