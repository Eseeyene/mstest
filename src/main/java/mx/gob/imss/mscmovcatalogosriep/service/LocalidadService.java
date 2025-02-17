package mx.gob.imss.mscmovcatalogosriep.service;

import java.util.List;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Localidad;

public interface LocalidadService {
	
	List<Localidad> consultaColoniaMunEntidad(String refMunicipio, String redEntidad) throws BusinessException ;

}
