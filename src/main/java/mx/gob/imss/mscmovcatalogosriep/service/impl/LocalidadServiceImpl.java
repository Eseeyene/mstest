package mx.gob.imss.mscmovcatalogosriep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.LocalidadRepository;
import mx.gob.imss.mscmovcatalogosriep.model.Localidad;
import mx.gob.imss.mscmovcatalogosriep.service.LocalidadService;

@Slf4j
@Service
public class LocalidadServiceImpl implements LocalidadService {
	@Autowired
	private LocalidadRepository localidadRepository;
	

	@Override
	public List<Localidad> consultaColoniaMunEntidad(String refMunicipio, String redEntidad) throws BusinessException {
		
		 try {
		      return localidadRepository.consultaColonia(refMunicipio, redEntidad);
       } catch(Exception e){
           throw new BusinessException(HttpStatus.NO_CONTENT,"Error en consultar Lista de localidades", e.getMessage());
       }
	}

}
