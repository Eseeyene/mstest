package mx.gob.imss.mscmovcatalogosriep.integration.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.contants.SQLConstants;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.EntidadFederativaRepository;
import mx.gob.imss.mscmovcatalogosriep.model.EntidadFederativa;


@Repository
public class EntidadFederativaRepositoryImpl implements EntidadFederativaRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EntidadFederativa> consultaEntidadFederativa() throws BusinessException {
        try{
            return jdbcTemplate.query(
                    SQLConstants.QS_CONSULTA_ENTIDAD_FEDERATIVA,
                    BeanPropertyRowMapper.newInstance(EntidadFederativa.class));
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta catalogo de entidad federativa",e.getMessage());
        }
	}

	@Override
	public EntidadFederativa consultaPorIdEntidadFederativa(Long idEntidadFederativa) throws BusinessException {
    try{
        return jdbcTemplate.queryForObject(
                SQLConstants.QS_CONSULTA_ID_ENTIDAD_FEDERATIVA,
                BeanPropertyRowMapper.newInstance(EntidadFederativa.class),idEntidadFederativa);
    } catch (Exception e) {
        throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta catalogo de entidad federativa por ID" ,e.getMessage());
    }
	}

}