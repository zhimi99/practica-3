package ec.edu.ups.appdis.p58.practica3.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author andres Clase java encargada de la creacion de la tabla a nivel
 *         de Base de datos mediante la persistencia, asi mismo definr los
 *         atributos necesarios que estos requieran
 * 
 */
@Entity
public class Sesion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	private int intentos;
	private String estado;
	
	
	private String correo;
	private String clave;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	@Override
	public String toString() {
		return "Sesion [id=" + id + ", fecha=" + fecha + ", intentos=" + intentos + ", estado=" + estado + ", correo="
				+ correo + ", clave=" + clave + "]";
	}
	
	/*@Transient
	@OneToOne
	private Usuario usuario;
	
	@OneToOne
	private Cliente cliente;
	
	@Transient
	private String adminEmpleadoTemp;
	@OneToOne
	private Usuario usuario;*/
	


}
