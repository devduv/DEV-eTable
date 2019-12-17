package etable.application.reservacion;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etable.domain.cliente.model.Cliente;
import etable.domain.reservacion.model.Reservacion;
import etable.domain.reservacion.model.ReservacionDTO;
import etable.domain.reservacion.model.ReservacionDTOCli;
import etable.domain.reservacion.repository.ReservacionRepository;

@Service
public class ReservacionServiceImpl implements ReservacionService{

	@Autowired
	private ReservacionRepository repository;

	@Override
	public Reservacion crearReservacion(Reservacion reservacion) {
		// TODO Auto-generated method stub
		return this.repository.crearReservacion(reservacion);
	}


	@Override
	public boolean anularReservacion(int id) {
		// TODO Auto-generated method stub
		return this.repository.anularReservacion(id);
	}

	

	@Override
	public Cliente obtenerClientebyUsuario(int cusuario) {
		// TODO Auto-generated method stub
		return this.repository.obtenerClientebyUsuario(cusuario);
	}


	@Override
	public List<Reservacion> listReservacionesbyId(int id) {
		return this.repository.listReservacionesbyId(id);
	
	}


	@Override
	public Reservacion getReservacionById(int id) {
		// TODO Auto-generated method stub
		return this.repository.getReservacionById(id);
	}


	@Override
	public List<ReservacionDTO> listReservacionesbyIdDTO(int id) {
		// TODO Auto-generated method stub
		return this.repository.listReservacionesbyIdDTO(id);
	}


	@Override
	public List<ReservacionDTOCli> listReservacionesDTO() {
		// TODO Auto-generated method stub
		return this.repository.listReservacionesDTO();
	}



	

	
}
