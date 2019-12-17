package etable.application.reservacion;

import java.util.List;


import etable.domain.cliente.model.Cliente;
import etable.domain.mesa.model.EstadoMesa;
import etable.domain.mesa.model.PerfilMesa;
import etable.domain.reservacion.model.Reservacion;
import etable.domain.reservacion.model.ReservacionDTO;
import etable.domain.reservacion.model.ReservacionDTOCli;

public interface ReservacionService {

	Cliente obtenerClientebyUsuario(int cusuario);
	Reservacion crearReservacion(Reservacion reservacion);
	boolean anularReservacion(int id);
	List<Reservacion> listReservacionesbyId (int id);
	List<ReservacionDTO> listReservacionesbyIdDTO (int id);
	List<ReservacionDTOCli> listReservacionesDTO();
	Reservacion getReservacionById(int id);
}
