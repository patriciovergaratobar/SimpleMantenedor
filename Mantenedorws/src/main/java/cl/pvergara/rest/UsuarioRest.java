package cl.pvergara.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mongodb.DBObject;

import cl.pvergara.dao.UsuarioDao;
import cl.pvergara.dto.UsuarioDto;

/**
 * Clase con los servicios rest de usuarios.
 *
 * @author pvergara
 *
 */
@Path("/usuario")
public class UsuarioRest {

	/**
	 * DAO del usuario.
	 */
	final UsuarioDao dao = new UsuarioDao();

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public List<DBObject> getAll() {

		return dao.getAll();
	}

	/**
	 * WS que crea un usuario.
	 * @param usuario modelo de usuario.
	 * @return
	 */
	@POST
	@Path("/crear")
	@Consumes("application/json")
	@Produces("text/plain")
	public Response crear(UsuarioDto usuario) {

		return Response.status(201).entity(dao.crear(usuario)).build();
	}

	/**
	 * WS para editar un usuario.
	 * @param usuario Modelo de usuario.
	 * @return
	 */
	@PUT
	@Path("/editar")
	@Consumes("application/json")
	@Produces("text/plain")
	public Response editar(UsuarioDto usuario) {

		return Response.status(201).entity(dao.update(usuario)).build();
	}

	/**
	 * WS para eliminar un usuario.
	 * @param id del usuario.
	 * @return
	 */
	@DELETE
	@Path("/eliminar/{usuarioid}")
	@Consumes("application/json")
	@Produces("text/plain")
	public Response eliminar(@PathParam("usuarioid") Long id) {

		UsuarioDto usuario = new UsuarioDto();
		usuario.setUsuarioId(id);
		return Response.status(201).entity(dao.eliminar(usuario)).build();
	}
}
