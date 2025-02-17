package mx.gob.imss.mscmovcatalogosriep.integration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Municipio;


@Repository
public interface MunicipioRepository {

	
	Municipio consultaIdMunicipio(Long idMunicipio) throws BusinessException;
	List<Municipio> consultaMunicipioIdEntidad(String idEntidadFederativa) throws BusinessException;
	List<Municipio> consultaMunicipios() throws BusinessException;
}
