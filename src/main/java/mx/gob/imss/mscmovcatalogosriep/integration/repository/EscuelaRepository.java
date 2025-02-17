package mx.gob.imss.mscmovcatalogosriep.integration.repository;

import java.util.List;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Escuela;

public interface EscuelaRepository {
	List<Escuela> consultaEscuelaPorFiltros(String idEntidadFederativa, String idMunicipio, String idLocalidad) throws BusinessException;
}
