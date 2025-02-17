package mx.gob.imss.mscmovcatalogosriep.service;

import java.util.List;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.EntidadFederativa;


public interface EntidadFederativaService {

	List<EntidadFederativa> consultaEntidadFederativa () throws BusinessException;
	EntidadFederativa consultaEntidadFederativaId(Long idEntidadFederativa) throws BusinessException;
}
