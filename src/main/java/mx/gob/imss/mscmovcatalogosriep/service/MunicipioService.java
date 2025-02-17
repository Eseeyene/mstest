package mx.gob.imss.mscmovcatalogosriep.service;

import java.util.List;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Municipio;



public interface MunicipioService {
	
	Municipio consultaMunicipioId(Long IdMunicipio) throws BusinessException;
	List<Municipio> consultaMunicipioIdEntidad (String idEntidadFederativa ) throws BusinessException;
	List<Municipio> consultaMunicipios () throws BusinessException;

}
