package ec.edu.ups.appdis.p58.practica3.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import ec.edu.ups.appdis.p58.practica3.entity.Sesion;
import ec.edu.ups.appdis.p58.practica3.entity.Usuario;

/**
 * 
 * @author andres Clase java encargada del manejo de opraciones sobre la base de
 *         datos, tendremos operaciones CRUD si los requerimientos nos lo pide
 * 
 */

@Stateless
public class SesionDAO {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Metodo que permite crear un objeto mediante la persitencia
	 * 
	 * @param sesion pide el objeto que va a ser insertado en nuestra DB
	 */
	public void crearSesion(Sesion sesion) {
		System.out.println("en dao" + sesion.toString());
		this.em.persist(sesion);
	}

	/*
	 * public Cuenta buscarCuenta(String nombres) { String jpql =
	 * "SELECT a FROM Autor a JOIN FETCH a where a.nombres = :nombres"; Query query
	 * = em.createQuery(jpql, Autor.class); query.setParameter("nombres", nombres);
	 * Autor autor = (Autor) query.getSingleResult(); return autor; }
	 */

	/**
	 * Metodo que permite tener un arreglo de todas las sesiones, esto lo realizamos
	 * mediante jpql
	 * 
	 * @return arreglo de sesiones
	 */

	public List<Sesion> mostrarSesiones() {
		String jpql = "SELECT a FROM Sesion a";
		Query query = em.createQuery(jpql, Sesion.class);
		List<Sesion> sesiones = query.getResultList();

		return sesiones;
	}

	public void removeSesion(int id) throws Exception {
		em.remove(this.buscarSesion(id));
	}

	public void update(int id) throws Exception {
		em.merge(id);
	}

	public Sesion buscarSesion(int id) {
		Sesion sesion = em.find(Sesion.class, id);
		return sesion;
	}

	public Sesion buscarSesionCorreo(String correo) {
		Sesion cli = new Sesion();
		// public Cliente buscarClienteCedula(String cedula) {
		// Cliente cli = new Cliente();
		try {
			String jpql = "SELECT c FROM Sesion c where c.correo = :correo";
			Query query = em.createQuery(jpql, Usuario.class);
			query.setParameter("correo", correo);
			cli = (Sesion) query.getSingleResult();
		} catch (Exception e) {
			cli = null;
		}

		return cli;

	}

	public List<Sesion> getSesionesCorreo(String correo) {
		String jpql = "SELECT c FROM Sesion c where c.correo = :correo";
		
		Query query = em.createQuery(jpql, Sesion.class);
		query.setParameter("correo", correo);
		List<Sesion> listado = query.getResultList();
		return listado;
	}
	

}
