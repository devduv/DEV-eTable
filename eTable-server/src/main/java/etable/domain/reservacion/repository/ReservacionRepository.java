package etable.domain.reservacion.repository;

import java.util.List;

import etable.domain.cliente.model.Cliente;
import etable.domain.reservacion.model.Reservacion;

public interface ReservacionRepository {
	Cliente obtenerClientebyUsuario(int cusuario);
	Reservacion crearReservacion(Reservacion reservacion);
	boolean anularReservacion(int id);
	List<Reservacion> listReservacionesbyId(int id);
	Reservacion getReservacionById(int id);
}
