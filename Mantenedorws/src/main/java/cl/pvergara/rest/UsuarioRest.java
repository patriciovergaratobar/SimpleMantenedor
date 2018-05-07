package cl.pvergara.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.mongodb.DBObject;

import cl.pvergara.dao.UsuarioDao;
import cl.pvergara.dto.UsuarioDto;

@Path("/usuario")
public class UsuarioRest {

	@GET
	@Path("/lista")
	@Produces("application/json")
	public List<UsuarioDto> lista() {

		UsuarioDao dao = new UsuarioDao();
		return dao.get();
	}

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public List<DBObject> getAll() {

		UsuarioDao dao = new UsuarioDao();
		return dao.getAll();
	}
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public UsuarioDto getUsuario(@QueryParam("id") Long id) {

		UsuarioDto usuario = new UsuarioDto();
		usuario.setRut("");
		usuario.setClave("");
		usuario.setNombre("LU");
		usuario.setCorreo("klk@gmail.cl");
		usuario.setUsuarioId(id);
		usuario.setFechaNacimiento(new Date());
		return usuario;
	}

	@POST
	@Path("/crear")
	@Consumes("application/json")
	public Response crear(UsuarioDto usuario) {

		UsuarioDao dao = new UsuarioDao();
		
		return Response.status(201).entity(dao.crear(usuario)).build();
		
	}

	@PUT
	@Path("/editar")
	@Consumes("application/json")
	public Response editar(UsuarioDto usuario) {

		UsuarioDao dao = new UsuarioDao();
		return Response.status(201).entity(dao.update(usuario)).build();
		
	}

	@DELETE
	@Path("/eliminar")
	@Consumes("application/json")
	public Response eliminar(UsuarioDto usuario) {

		UsuarioDao dao = new UsuarioDao();
		
		return Response.status(201).entity(dao.eliminar(usuario)).build();
		
	}
}
