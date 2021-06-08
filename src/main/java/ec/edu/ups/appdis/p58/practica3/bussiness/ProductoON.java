package ec.edu.ups.appdis.p58.practica3.bussiness;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.p58.practica3.dao.ProductoDAO;
import ec.edu.ups.appdis.p58.practica3.dao.UsuarioDAO;
import ec.edu.ups.appdis.p58.practica3.entity.Producto;
import ec.edu.ups.appdis.p58.practica3.entity.Usuario;

@Stateless
public class ProductoON {
	@Inject
	ProductoDAO productodao;

	public void crearProducto(Producto u) throws Exception {
		Producto p = productodao.buscarProductoNombre(u.getNoombre());		
		if (p==null) {
			this.productodao.crearProducto(u);
		}
		else {
			productodao.actualizarProducto(u);
		}
	}
	
	
	public Producto buscarProducto(String nombre) {
		
		return this.productodao.buscarProductoNombre(nombre);
		
		
	}

}
