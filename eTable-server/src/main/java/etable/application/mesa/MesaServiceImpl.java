package etable.application.mesa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etable.domain.mesa.model.Mesa;
import etable.domain.mesa.model.MesaDTO;
import etable.domain.mesa.repository.MesaRepository;

@Service
public class MesaServiceImpl implements MesaService{

	@Autowired
	private MesaRepository repository;

	@Override
	public List<MesaDTO> getMesas() {
		// TODO Auto-generated method stub
		return this.repository.getMesas();
	}

	@Override
	public Mesa actualizarMesaById(Mesa mesa, int id) {
		// TODO Auto-generated method stub
		return this.repository.actualizarMesaById(mesa, id);
	}

	@Override
	public boolean eliminarMesaById(int id) {
		// TODO Auto-generated method stub
		return this.repository.eliminarMesaById(id);	}

	@Override
	public Mesa crearMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		return this.repository.crearMesa(mesa);
	}

	@Override
	public Mesa getMesaById(int id) {
		// TODO Auto-generated method stub
		return this.repository.getMesaById(id);
	}
	


	
}
