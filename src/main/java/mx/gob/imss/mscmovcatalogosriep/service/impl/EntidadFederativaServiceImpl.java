package mx.gob.imss.mscmovcatalogosriep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.EntidadFederativaRepository;
import mx.gob.imss.mscmovcatalogosriep.model.EntidadFederativa;
import mx.gob.imss.mscmovcatalogosriep.service.EntidadFederativaService;



@Service
public class EntidadFederativaServiceImpl implements EntidadFederativaService {

	 @Autowired
	 EntidadFederativaRepository entidadFederativaRepository;
	@Override
	public List<EntidadFederativa> consultaEntidadFederativa() throws BusinessException {
		 try {
			      return entidadFederativaRepository.consultaEntidadFederativa();
	        } catch(Exception e){
	            throw new BusinessException(HttpStatus.NO_CONTENT,"Error en consultar Lista entidad federativa", e.getMessage());
	        }
		
		
	}

	@Override
	public EntidadFederativa consultaEntidadFederativaId(Long idEntidadFederativa) throws BusinessException {
		 try {
		      return entidadFederativaRepository.consultaPorIdEntidadFederativa(idEntidadFederativa);
       } catch(Exception e){
           throw new BusinessException(HttpStatus.NO_CONTENT,"Error en consultar Entidad Federativa por Id", e.getMessage());
       }
	}

}