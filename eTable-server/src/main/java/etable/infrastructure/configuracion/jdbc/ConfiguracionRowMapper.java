package etable.infrastructure.configuracion.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.stereotype.Component;

import etable.domain.configuracion.model.Configuracion;
import etable.web.constants.querys.Query;

@Component
public class ConfiguracionRowMapper implements RowMapper{

	public Configuracion mapRow(List<Map<String, Object>> rows){
		 Configuracion configuracion = null;
		for(Map<String, Object> row: rows) {
			int cconfiguracion = Integer.parseInt(row.get("CCONFIGURACION").toString());
			int cempresa = Integer.parseInt(row.get("CEMPRESA").toString());
			String empnombre = row.get("EMPNOMBRE").toString();
			String empdescripcion = row.get("EMPDESCRIPCION").toString();
			String empdireccion = row.get("EMPDIRECCION").toString();
			String empemail = row.get("EMPEMAIL").toString();
			int empcelular = Integer.parseInt(row.get("EMPCELULAR").toString());
			String emplogo = row.get("EMPLOGO").toString();
			
			boolean sist_reservacion_cliente = (Integer.parseInt(row.get("SIST_RESERVACION_CLIENTE").toString()) == 1 ? true: false);
			boolean sist_atencion_cliente = (Integer.parseInt(row.get("SIST_ATENCION_CLIENTE").toString()) == 1 ? true: false);
			boolean mesas_compuestas = (Integer.parseInt(row.get("MESAS_COMPUESTAS").toString()) == 1 ? true: false);
			boolean agregar_cliente_manual = (Integer.parseInt(row.get("AGREGAR_CLIENTE_MANUAL").toString()) == 1 ? true: false);
			boolean pagos_tarjeta_credito = (Integer.parseInt(row.get("PAGOS_TARJETA_CREDITO").toString()) == 1 ? true: false);
			boolean reservacion_pedidos = (Integer.parseInt(row.get("RESERVACION_PEDIDOS").toString()) == 1 ? true: false);
			boolean reservas_especiales = (Integer.parseInt(row.get("RESERVAS_ESPECIALES").toString()) == 1 ? true: false);
			boolean reservas_no_sesionadas = (Integer.parseInt(row.get("RESERVAS_NO_SESIONADAS").toString()) == 1 ? true: false);
			String date_configurado = row.get("DATE_CONFIGURADO").toString();
			
			configuracion = new Configuracion(cconfiguracion, cempresa, empnombre, empdescripcion, empdireccion, empemail, empcelular,
					emplogo, sist_reservacion_cliente, sist_atencion_cliente, mesas_compuestas, agregar_cliente_manual, 
					pagos_tarjeta_credito, reservacion_pedidos, reservas_especiales, reservas_no_sesionadas, date_configurado);
		}
		return configuracion;
	}
	
	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		return new int[0];
	}

}
