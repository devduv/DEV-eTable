package etable.domain.reservacion.repository;

import java.util.List;

import etable.domain.cliente.model.Cliente;
import etable.domain.reservacion.model.Reservacion;
import etable.domain.reservacion.model.ReservacionDTO;

public interface ReservacionRepository {
	Cliente obtenerClientebyUsuario(int cusuario);
	Reservacion crearReservacion(Reservacion reservacion);
	boolean anularReservacion(int id);
	List<Reservacion> listReservacionesbyId (int id);
	List<ReservacionDTO> listReservacionesbyIdDTO (int id);
	Reservacion getReservacionById(int id);
}
