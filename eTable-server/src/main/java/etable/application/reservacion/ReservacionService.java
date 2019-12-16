package etable.application.reservacion;

import java.util.List;


import etable.domain.cliente.model.Cliente;
import etable.domain.mesa.model.EstadoMesa;
import etable.domain.mesa.model.PerfilMesa;
import etable.domain.reservacion.model.Reservacion;
import etable.domain.reservacion.model.ReservacionDTO;

public interface ReservacionService {

	Reservacion crearReservacion(Reservacion reservacion);
	boolean anularReservacion(int id);
	Cliente obtenerClientebyUsuario(int cusuario);
	List<Reservacion> listReservacionesbyId(int id);
	Reservacion getReservacionById(int id);
	List<ReservacionDTO> listReservacionesbyIdDTO (int id);
}
