package ec.edu.ups.appdis.p58.practica3.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.ups.appdis.p58.practica3.dao.UsuarioDAO;
import ec.edu.ups.appdis.p58.practica3.entity.Usuario;

@Stateless
public class UsuarioON {
	@Inject
	UsuarioDAO usuariodao;

	public void crearUsuario(Usuario u) throws Exception {
		Usuario cli = usuariodao.buscarUsuarioCedulaP(u.getCedula());		
		if (cli==null) {
			this.usuariodao.crearUsuario(u);
		}
		else {
			usuariodao.actualizarUsuario(u);
		}
	}
	
	
	public Usuario buscarUsuario(String cedula) {
		
		return this.usuariodao.buscarUsuarioCedulaP(cedula);
		
		//return null;
		
	}

}
