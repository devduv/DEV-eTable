package etable.web.constants.querys;

public class Query {

	public static String table_configuracion = "TBCONFIGURACIONSISTEMA";
	
	public static String update_configuracion =  
			"UPDATE " + Query.table_configuracion + 
			" SET  CEMPRESA = ? , EMPNOMBRE = ? , EMPDESCRIPCION = ? , EMPEMAIL = ? , EMPCELULAR = ? , EMPLOGO = ? , "
			+ "SIST_RESERVACION_CLIENTE = ? , SIST_ATENCION_CLIENTE = ? , MESAS_COMPUESTAS = ? , AGREGAR_CLIENTE_MANUAL = ? , "
			+ "PAGOS_TARJETA_CREDITO = ? , RESERVACION_PEDIDOS = ? , RESERVAS_ESPECIALES = ? , RESERVAS_NO_SESIONADAS = ? , DATE_CONFIGURADO = ? "
			+ "WHERE CCONFIGURACION = ?";
}
