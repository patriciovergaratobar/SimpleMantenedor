package cl.pvergara.app;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import cl.pvergara.dao.ConexionMongo;
import cl.pvergara.rest.LoginRest;
import cl.pvergara.rest.UsuarioRest;

/***
 * Clase principal del mantenedor.
 * 
 * @author pvergara
 *
 */
public class MainApp  extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public MainApp() {

		super();
		ConexionMongo.getInstancia().conectar();
		singletons.add(new LoginRest());
		singletons.add(new UsuarioRest());
	}

	@Override
	public Set<Object> getSingletons() {

		return singletons;
	}

}
