package mx.gob.imss.mscmovcatalogosriep.integration.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.contants.SQLConstants;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.MunicipioRepository;
import mx.gob.imss.mscmovcatalogosriep.model.Municipio;

@Repository
public class MunicipioRepositoryImpl implements MunicipioRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public Municipio consultaIdMunicipio(Long idMunicipio)
			throws BusinessException {
	    try{
	        return jdbcTemplate.queryForObject(
	                SQLConstants.QS_CONSULTA_ID_MUNICIPIO,
	                BeanPropertyRowMapper.newInstance(Municipio.class),idMunicipio);
	    } catch (Exception e) {
	        throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta catalogo de municipio por cvemunicipio " ,e.getMessage());
	    }
	}

	@Override
	public List<Municipio> consultaMunicipioIdEntidad(String idEntidadFederativa) throws BusinessException {
        try{
            return jdbcTemplate.query(
                    SQLConstants.QS_CONSULTA_MUNICIPIO_ID_ENTIDAD,
                    BeanPropertyRowMapper.newInstance(Municipio.class), idEntidadFederativa);
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta catalogo de municipio por idEntidadFederativa",e.getMessage());
        }
	}
	
	@Override
	public List<Municipio> consultaMunicipios() throws BusinessException {
        try{
            return jdbcTemplate.query(
                    SQLConstants.QS_CONSULTA_MUNICIPIOS,
                    BeanPropertyRowMapper.newInstance(Municipio.class));
        } catch (Exception e) {
            throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al consulta catalogo de municipios",e.getMessage());
        }
	}


}
