package etable.application.configuracion;

import etable.domain.configuracion.model.Configuracion;

public interface ConfiguracionService {

	Configuracion getConfiguracion();
	Configuracion actualizarConfiguracion(Configuracion configuracion);
	Configuracion getParametros();
}
