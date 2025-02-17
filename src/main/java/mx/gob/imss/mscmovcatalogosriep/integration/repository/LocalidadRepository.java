package mx.gob.imss.mscmovcatalogosriep.integration.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Localidad;

@Repository
public interface LocalidadRepository {
	
	List<Localidad> consultaColonia(String refMunicipio, String refEntidad) throws BusinessException;

}
