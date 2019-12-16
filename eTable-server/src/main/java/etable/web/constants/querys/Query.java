package etable.web.constants.querys;

public class Query {

	public static final String table_configuracion = "TBCONFIGURACIONSISTEMA";
	public static final String table_mesa = "TBMESA";
	public static final String table_perfilmesa = "TBPERFILMESA";
	public static final String table_estadomesa = "TBESTADOMESA";
	public static final String table_reservacion = "TBRESERVACION";
	public static final String table_permisos = "TBPERMISOS";
	public static final String table_menuitems = "TBMENUITEMS";
	public static final String table_menusubitems = "TBMENUSUBITEMS";
	public static final String table_tipousuario = "TBTIPOUSUARIO";
	public static final String table_usuarios = "TBUSUARIOS";
	public static final String table_tipouspermiso = "TBTIPOUSUARIOPERMISO";
	public static final String table_clientes = "TBCLIENTES";
	
	public static final String insert_tipousuario = 
			"INSERT INTO " + table_tipousuario + "( TIPONOMBRE, TIPODESCRIPCION) VALUES (?,?)";
	
	public static final String insert_usuario =
			"INSERT INTO " + table_usuarios + "(NICKNAME, PASSWORD, CTIPOUSUARIO, USNOMBRE, USAPELLIDOS, ESTADO) VALUES (?, ?, ?, ? ,? ,?)";
	
	public static final String insert_cliente = 
			"INSERT INTO " + table_clientes + "(DNI, CUSUARIO, EMAIL, PHONE, DATE) VALUES (?, ?, ?, ?, ?)";
	
	public static String update_configuracion =  
			"UPDATE " + Query.table_configuracion + 
			" SET  CEMPRESA = ? , EMPNOMBRE = ? , EMPDIRECCION = ? ,EMPDESCRIPCION = ? , EMPEMAIL = ? , EMPCELULAR = ? , EMPLOGO = ? , "
			+ "SIST_RESERVACION_CLIENTE = ? , SIST_ATENCION_CLIENTE = ? , MESAS_COMPUESTAS = ? , AGREGAR_CLIENTE_MANUAL = ? , "
			+ "PAGOS_TARJETA_CREDITO = ? , RESERVACION_PEDIDOS = ? , RESERVAS_ESPECIALES = ? , RESERVAS_NO_SESIONADAS = ? , DATE_CONFIGURADO = ? "
			+ "WHERE CCONFIGURACION = ?";
	
	public static String update_parametros =
			"UPDATE " + Query.table_configuracion +
			" SET CANT_MAX_MESAS = ? , CANT_MAX_US_REGISTRADOS = ?, HORARIO_INI_ATENCION = ? , HORARIO_FIN_ATENCION = ? , DIAS_ATENCION = ? , MAX_US_TRAB_CONECTADOS = ?";

	public static String selectFrom(String table) {
		return "SELECT * FROM " + table;
	}
	
	public static String selectFromWhere(String table, String field, int id) {
		return "SELECT * FROM " + table + " WHERE " + field + " = " + id;
	}
	
	public static String selectFromWhere(String table, String field, String val) {
		return "SELECT * FROM " + table + " WHERE " + field + " = '" + val + "'";
	}
}
