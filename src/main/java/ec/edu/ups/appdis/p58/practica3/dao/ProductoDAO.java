package ec.edu.ups.appdis.p58.practica3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appdis.p58.practica3.entity.Producto;
import ec.edu.ups.appdis.p58.practica3.entity.Usuario;


@Stateless
public class ProductoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void crearProducto(Producto p) {
		em.persist(p);
	}
	
	public Producto buscarProductoNombre(String nombre) {
		Producto p = em.find(Producto.class, nombre);
		System.out.println("en dao "+p.getNoombre());
		
		return p;
	}
	
	
	public void actualizarProducto(Producto p) {
		em.merge(p);
	}

	public List<Producto> mostrarProductos() {
		String jpql = "SELECT p FROM Productos p";
		Query query = em.createQuery(jpql, Producto.class);
		List<Producto> productoList = query.getResultList();
		return productoList;
	}
}
