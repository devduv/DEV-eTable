package etable.domain.configuracion.repository;

import etable.domain.configuracion.model.Configuracion;

public interface ConfiguracionRepository{

	Configuracion getConfiguracion();
	Configuracion actualizarById(Configuracion configuracion);
	Configuracion getParametrosGenerales();
	Configuracion actualizarParametrosById(Configuracion configuracion);
}
