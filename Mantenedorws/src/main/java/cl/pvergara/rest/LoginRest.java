package cl.pvergara.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import cl.pvergara.dao.UsuarioDao;
import cl.pvergara.dto.UsuarioDto;

/*
 * 
 *  
 *  ESTA CLASE ES SOLO UN EJEMPLO, PERO EN EL FUTURO LA DEJARE FUNCIONAL
 *  
 *  
 *  
 *  
 *  
 *  */

//http://localhost:8080/Mantenedorws/rest/login/hello%20world
@Path("/login")
public class LoginRest {

	//http://localhost:8080/Mantenedorws/rest/login?rut=19&clave=1111
	@GET
	@Path("/")
	@Produces("application/json")
	public UsuarioDto login(@QueryParam("rut") String rut, @QueryParam("clave") String clave) {

		UsuarioDao dao = new UsuarioDao();
		
		
		return dao.login(rut, clave);
		//return Response.status(200).entity(usuario).build();
	}

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
}
