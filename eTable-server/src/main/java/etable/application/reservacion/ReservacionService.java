package etable.application.reservacion;

import java.util.List;

import etable.domain.cliente.model.Cliente;
import etable.domain.mesa.model.EstadoMesa;
import etable.domain.reservacion.model.Reservacion;

public interface ReservacionService {

	Reservacion crearReservacion(Reservacion reservacion);
	boolean anularReservacion(int id);
	Cliente obtenerClientebyUsuario(int cusuario);
	
}
