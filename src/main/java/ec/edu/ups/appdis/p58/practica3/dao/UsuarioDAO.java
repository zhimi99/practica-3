package ec.edu.ups.appdis.p58.practica3.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appdis.p58.practica3.entity.Usuario;


@Stateless
public class UsuarioDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void crearUsuario(Usuario u) {
		em.persist(u);
	}
	
	public Usuario buscarUsuarioCedulaP(String cedula) {
		Usuario cli = em.find(Usuario.class, cedula);
		System.out.println("en dao "+cli.getCedula());
		//return em.find(Usuario.class, cedula);
		return cli;
	}
	
	

	/*
	public Usuario buscarUsuarioCedula(String cedula) {
		Usuario cli = new Usuario();
		try {
			String jpql = "SELECT c FROM Usuario c where c.cedula = :cedula";
			Query query = em.createQuery(jpql, Usuario.class);
			query.setParameter("cedula", cedula);
			cli = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			cli = null;
		}

		return cli;
	}*//*
	
	public Usuario buscarUsuarioCuenta(int cuenta) {
		System.out.println("Numero de cuenta en dao "+cuenta);
		Usuario cli = new Usuario();
		try {
			String jpql = "SELECT c FROM Usuario c where c.cuenta = :cuenta";
			Query query = em.createQuery(jpql, Usuario.class);
			query.setParameter("cuenta", cuenta);
			cli = (Usuario) query.getSingleResult();
			System.out.println("en dao >>>>> "+cli.toString());
		} catch (Exception e) {
			cli = null;
		}

		return cli;
	}*/
	public void actualizarUsuario(Usuario Usuario ) {
		em.merge(Usuario);
	}

	public List<Usuario> mostrarUsuarios() {
		String jpql = "SELECT a FROM Usuario a";
		Query query = em.createQuery(jpql, Usuario.class);
		List<Usuario> transacciones = query.getResultList();
		return transacciones;
	}
}
