package cl.pvergara.dao;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * Clase que permite mantener la conexion.
 * @author pvergara
 *
 */
public class ConexionMongo {

	private static ConexionMongo instancia;

	private MongoClient mongoClient;

	private DB db;

	private final static String MONGO_IP = "192.168.99.100";
	private final static int MONGO_PORT = 27017;
	private final static String NOMBRE_DB = "mantenedor";

	/**
	 * Metodo que entrega instancia de la clase.
	 * @return
	 */
	public static ConexionMongo getInstancia() {

		if (instancia == null) {

			instancia = new ConexionMongo();
		}
		return instancia;
	}

	/**
	 * Metodo que inicia la conexion.
	 */
	@SuppressWarnings("deprecation")
	public void conectar() {

		mongoClient = new MongoClient(MONGO_IP, MONGO_PORT);
		mongoClient.getDatabaseNames().forEach(System.out::println);
		db = mongoClient.getDB(NOMBRE_DB);
	}

	/**
	 * Metodo que permite acceder a la base de datos.
	 * @return
	 */
	public DB getDb() {

		return db;
	}
}
