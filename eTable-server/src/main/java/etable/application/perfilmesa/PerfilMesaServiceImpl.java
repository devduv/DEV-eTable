package etable.application.perfilmesa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etable.domain.perfilmesa.model.PerfilMesa;
import etable.domain.perfilmesa.repository.PerfilMesaRepository;

@Service
public class PerfilMesaServiceImpl implements PerfilMesaService{

	@Autowired
	private PerfilMesaRepository repository;
	
	@Override
	public List<PerfilMesa> getPerfilesMesa() {
		return this.repository.getPerfilesMesa();
	}

}
