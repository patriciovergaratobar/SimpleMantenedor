package cl.pvergara.dto;

import java.util.Date;

/**
 * Clase que contiene el modelo de un usuario.
 *
 * @author pvergara
 *
 */
public class UsuarioDto {

	private Long usuarioId;
	private String rut;
	private String nombre;
	private String clave;
	private String correo;
	private Date fechaNacimiento;

	public UsuarioDto() {

		super();
	}

	public final Long getUsuarioId() {

		return usuarioId;
	}

	public final void setUsuarioId(Long usuarioId) {

		this.usuarioId = usuarioId;
	}

	public final String getRut() {

		return rut;
	}

	public final void setRut(String rut) {

		this.rut = rut;
	}

	public final String getNombre() {

		return nombre;
	}

	public final void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public final String getClave() {

		return clave;
	}

	public final void setClave(String clave) {

		this.clave = clave;
	}

	public final String getCorreo() {
		return correo;
	}

	public final void setCorreo(String correo) {
		this.correo = correo;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
