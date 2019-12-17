package etable.domain.mesa.factory.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import etable.domain.mesa.model.Mesa;
import etable.domain.mesa.model.PerfilMesa;
import etable.domain.mesa.repository.PerfilMesaRepository;

@Component
public class FabricaImpl extends IFabrica{

	@Autowired
	private PerfilMesaRepository repositoryPerfilMesa;
	
	@Override
	public Mesa fabricarMesa(Mesa mesa) {
		IProducto factory;
		PerfilMesa perfilMesa = this.repositoryPerfilMesa.getPerfilMesaById(mesa.getCperfilmesa());
		if (perfilMesa == null) {
			System.out.println("No se ha podido fabricar la mesa");
			return null;
		}
		factory = new MesaFactory(mesa);
		System.out.println("Fabricando mesa con " + perfilMesa.getPmcapacidad() + " de capacidad total de personas.");
		return factory.getMesa();
	}

}
