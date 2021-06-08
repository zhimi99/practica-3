package ec.edu.ups.appdis.p58.practica3.view;


import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.ups.appdis.p58.practica3.bussiness.UsuarioON;
import ec.edu.ups.appdis.p58.practica3.entity.Usuario;

/**
 * Session Bean implementation class UsuarioBean
 */
@Named
@ViewScoped
public class UsuarioBean {
	
@Inject
UsuarioON usuarioON;

private Usuario usuario;

private List<Usuario> usuarios;

 
    /**
     * Default constructor. 
     */
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
	public void init() {
		//this.usuarioLogin=recuperarUsuarioLogin(); 
		this.usuario = new Usuario();
		//listarUsuarios();
	}
    
    public String agregarUsuario() throws Exception {
		
		this.usuarioON.crearUsuario(usuario);
		
		return null;
	}
    
    public void BuscarUsuarios() {
		this.usuario = this.usuarioON.buscarUsuario(this.usuario.getCedula());
	}
    

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
