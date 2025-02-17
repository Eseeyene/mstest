package mx.gob.imss.mscmovcatalogosriep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.EscuelaRepository;
import mx.gob.imss.mscmovcatalogosriep.model.Escuela;
import mx.gob.imss.mscmovcatalogosriep.service.EscuelaService;

@Slf4j
@Service
public class EscuelaServiceImpl implements EscuelaService {

	@Autowired
	private EscuelaRepository escuelaRepository;	
	
	@Override
	public List<Escuela> consultaEscuelas(String idEntidadFederativa, String cveMunicipio, String cveLocalidad ) throws BusinessException {
		
		return escuelaRepository.consultaEscuelaPorFiltros(
				idEntidadFederativa, cveMunicipio, cveLocalidad);
	}

}
