package etable.domain.mesa.repository;

import java.util.List;

import etable.domain.mesa.model.Mesa;

public interface MesaRepository {

	List<Mesa> getMesas();
	Mesa actualizarMesaById(Mesa mesa, int id);
	boolean eliminarMesaById(int id);
	Mesa crearMesa(Mesa mesa);
}
