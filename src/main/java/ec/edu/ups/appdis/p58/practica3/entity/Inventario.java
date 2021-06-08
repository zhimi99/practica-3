package ec.edu.ups.appdis.p58.practica3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inventario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	@JsonIgnore
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "inventario_bodega_id")
    private List<Bodega> bodegas;
	
	
	
	
	public void addBodega(Bodega bodega) {
		if (bodegas == null) {
			bodegas= new ArrayList<>();
		}
		///cuenta.setFechaRegistro(new Date());
		bodegas.add(bodega);
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Bodega> getBodegas() {
		return bodegas;
	}

	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}


	@Override
	public String toString() {
		return "Inventario [id=" + id + ", nombre=" + nombre + ", bodegas=" + bodegas + "]";
	}
}