package cl.pvergara.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import cl.pvergara.dto.UsuarioDto;

/**
 * Metodo que permite acceder a los datos de la coleccion de usuarios.
 * @author TeiGps
 *
 */
public class UsuarioDao {

	private ConexionMongo conexion;

	public UsuarioDao() {

		conexion = ConexionMongo.getInstancia();
	}

	public UsuarioDto login(final String rut, final String clave) {

		final DBCollection tablaUsuario = conexion.getDb().getCollection("usuarios");
		List<UsuarioDto> lista = new ArrayList<>();

		final BasicDBObject searchQuery = new BasicDBObject().append("rut", rut).append("clave", clave);

		final DBCursor resultado = tablaUsuario.find(searchQuery).limit(1);

		if (resultado.toArray().isEmpty()) {
			return new UsuarioDto();
		} else {
			resultado.toArray().stream().forEach(object -> {

				System.out.println(object);
				final UsuarioDto usuario = new UsuarioDto();
				usuario.setUsuarioId((Long) object.get("usuarioId"));
				usuario.setRut((String) object.get("rut"));
				usuario.setNombre((String) object.get("nombre"));
				usuario.setCorreo((String) object.get("correo"));
				usuario.setClave((String) object.get("clave"));
				usuario.setFechaNacimiento(new Date((Long) object.get("fechaNacimiento")));
				lista.add(usuario);
			});
			return lista.get(0);
		}

	}

	public List<UsuarioDto> get() {

		final DBCollection tablaUsuario = conexion.getDb().getCollection("usuarios");
		final List<UsuarioDto> lista = new ArrayList<>();
		final DBCursor resultado = tablaUsuario.find();
		resultado.toArray().stream().forEach(object -> {

			final UsuarioDto usuario = new UsuarioDto();
			usuario.setUsuarioId((Long) object.get("usuarioId"));
			usuario.setRut((String) object.get("rut"));
			usuario.setNombre((String) object.get("nombre"));
			usuario.setCorreo((String) object.get("correo"));
			usuario.setClave((String) object.get("clave"));
			usuario.setFechaNacimiento((Date) object.get("fechaNacimiento"));
			lista.add(usuario);
		});
		return lista;

	}

	public List<DBObject> getAll() {

		final DBCollection tablaUsuario = conexion.getDb().getCollection("usuarios");
		List<UsuarioDto> lista = new ArrayList<>();

		DBCursor resultado = tablaUsuario.find();

		return resultado.toArray();

	}

	public Boolean crear(final UsuarioDto usuario) {

		final DBCollection tablaUsuario = conexion.getDb().getCollection("usuarios");

		final BasicDBObject documento = new BasicDBObject();
		final Date now = new Date();
		documento.put("usuarioId", now.getTime());
		documento.put("rut", usuario.getRut());
		documento.put("nombre", usuario.getNombre());
		documento.put("correo", usuario.getCorreo());
		documento.put("clave", usuario.getClave());
		documento.put("fechaNacimiento", usuario.getFechaNacimiento().getTime());

		tablaUsuario.insert(documento);

		return Boolean.TRUE;
	}

	public Boolean update(final UsuarioDto usuario) {

		final DBCollection tablaUsuario = conexion.getDb().getCollection("usuarios");
		final BasicDBObject documentoUpdate = new BasicDBObject();
		documentoUpdate.put("usuarioId", usuario.getUsuarioId());
		documentoUpdate.put("rut", usuario.getRut());
		documentoUpdate.put("nombre", usuario.getNombre());
		documentoUpdate.put("correo", usuario.getCorreo());
		documentoUpdate.put("clave", usuario.getClave());
		documentoUpdate.put("fechaNacimiento", usuario.getFechaNacimiento().getTime());
		final BasicDBObject searchQuery = new BasicDBObject().append("usuarioId", usuario.getUsuarioId());
		tablaUsuario.update(searchQuery, documentoUpdate);
		return Boolean.TRUE;
	}

	public Boolean eliminar(final UsuarioDto usuario) {

		final DBCollection tablaUsuario = conexion.getDb().getCollection("usuarios");
		final BasicDBObject document = new BasicDBObject();
		document.put("usuarioId", usuario.getUsuarioId());
		WriteResult result = tablaUsuario.remove(document);
		return Boolean.TRUE;
	}
}
