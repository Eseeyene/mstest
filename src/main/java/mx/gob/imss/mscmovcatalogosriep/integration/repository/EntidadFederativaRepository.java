package mx.gob.imss.mscmovcatalogosriep.integration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.EntidadFederativa;



@Repository
public interface EntidadFederativaRepository {

	List<EntidadFederativa> consultaEntidadFederativa() throws BusinessException;
	
	EntidadFederativa consultaPorIdEntidadFederativa(Long idEntidadFederativa) throws BusinessException;
}
