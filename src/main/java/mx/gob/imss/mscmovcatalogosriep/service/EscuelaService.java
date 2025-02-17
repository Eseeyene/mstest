package mx.gob.imss.mscmovcatalogosriep.service;

import java.util.List;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Escuela;

public interface EscuelaService {
	 List<Escuela> consultaEscuelas(String idEntidadFederativa, String cveMunicipio, String cveLocalidad  )  throws BusinessException ;
}
