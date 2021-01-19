package me.formacion.model.DTO;

public class UsuarioWithPassDTO {
	private Long id;
    private String nombre;

	private String apellidos;
    private String usuario;
    private String clave;
    
	public UsuarioWithPassDTO(Long id, String nombre, String apellidos, String usuario, String clave) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
