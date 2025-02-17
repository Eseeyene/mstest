package mx.gob.imss.mscmovcatalogosriep.integration.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.contants.SQLConstants;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.LocalidadRepository;
import mx.gob.imss.mscmovcatalogosriep.model.Localidad;

@Repository
public class LocalidadRepositoryImpl implements LocalidadRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public List<Localidad> consultaColonia(String refMunicipio, String refEntidad) throws BusinessException {

		try{
            return jdbcTemplate.query(
                    SQLConstants.QS_CONSULTA_LOCALIDAD_EST_MUN,
                    BeanPropertyRowMapper.newInstance(Localidad.class),refMunicipio,refEntidad);
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta catalogo de localidades",e.getMessage());
        }
		
		
	}

}
