package etable.application.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etable.domain.configuracion.model.Configuracion;
import etable.domain.configuracion.repository.ConfiguracionRepository;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService{

	@Autowired
	private ConfiguracionRepository repository;

	@Override
	public Configuracion getConfiguracion() {
		return this.repository.getConfiguracion();
	}
	
	
}
