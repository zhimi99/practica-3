package ec.edu.ups.appdis.p58.practica3.view;


import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import ec.edu.ups.appdis.p58.practica3.bussiness.ProductoON;
import ec.edu.ups.appdis.p58.practica3.entity.Producto;


/**
 * Session Bean implementation class UsuarioBean
 */
@Named
@ViewScoped
public class ProductoBean {
	
@Inject
private ProductoON productoON;
private Producto producto;
private List<Producto> productos;

 
    /**
     * Default constructor. 
     */
    public ProductoBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
	public void init() {
		//this.usuarioLogin=recuperarUsuarioLogin(); 
		this.producto = new Producto();
		//listarUsuarios();
	}
    
    public String agregarProducto() throws Exception {
		
		this.productoON.crearProducto(producto);
		
		return null;
	}
    
    public void BuscarProductos() {
		this.producto = this.productoON.buscarProducto(this.producto.getNoombre());
	}
    

	public Producto getUsuario() {
		return producto;
	}

	public void setUsuario(Producto usuario) {
		this.producto = usuario;
	}

}
