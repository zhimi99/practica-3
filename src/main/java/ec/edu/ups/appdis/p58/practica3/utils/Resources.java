package ec.edu.ups.appdis.p58.practica3.utils;

import java.util.logging.Logger;
import java.sql.Connection;
//import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
//import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
////import javax.sql.DataSource;

public class Resources {

	// String dsName = "java:comp/DefaultDataSource";
	/// String dsName = "java:comp/datasources/bancoDS";
	String dsName = "java:jboss/datasources/tiendaDS";

	/*
	 * @Produces private Connection createConnection() throws SQLException,
	 * NamingException { InitialContext ic = new InitialContext(); DataSource ds =
	 * (DataSource) ic.lookup(dsName); return ds.getConnection(); }
	 * 
	 * private void closeConnection(@Disposes Connection conn) throws SQLException {
	 * conn.close(); }
	 */

	@Produces
	@PersistenceContext(name = "practica3PersistenceUnit")
	private EntityManager em;

	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
