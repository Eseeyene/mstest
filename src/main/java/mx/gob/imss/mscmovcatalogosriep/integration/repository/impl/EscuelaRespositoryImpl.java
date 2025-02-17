package mx.gob.imss.mscmovcatalogosriep.integration.repository.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.contants.SQLConstants;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.EscuelaRepository;
import mx.gob.imss.mscmovcatalogosriep.model.Escuela;

	


@Repository	
public class EscuelaRespositoryImpl implements EscuelaRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(EscuelaRespositoryImpl.class);
	
	@Override
	public List<Escuela> consultaEscuelaPorFiltros(String idEntidadFederativa, String cveMunicipio, String cveLocalidad) throws BusinessException {

	        String sql = SQLConstants.QS_CONSULTA_ESCUELA_FILTROS;
	        logger.info
	        ("Executing query: {} with cveCodigoPostal: {} ", sql, idEntidadFederativa, cveMunicipio, cveLocalidad);
	        return jdbcTemplate.query(sql, new Object[]{idEntidadFederativa, cveMunicipio, cveLocalidad }, (rs, rowNum) -> 	{
	            Escuela escuela = new Escuela();
	            escuela.setCveEscuela(rs.getString("CVE_ESCUELA"));
	            escuela.setNomEscuela(rs.getString("NOM_ESCUELA"));
	            escuela.setNomCalle(rs.getString("NOM_CALLE"));
	            escuela.setRefNumeroInterior(rs.getString("REF_NUMERO_INTERIOR"));
	            escuela.setRefNumeroExterior(rs.getString("REF_NUMERO_EXTERIOR"));
	            escuela.setNomColonia(rs.getString("NOM_COLONIA"));
	            escuela.setRefEntidadFederativa(rs.getString("REF_ENTIDAD_FEDERATIVA"));
	            escuela.setRefMunicipio(rs.getString("REF_MUNICIPIO"));
	            escuela.setCveCodigoPostal(rs.getString("CVE_CODIGO_POSTAL"));
	            escuela.setRefTurno(rs.getString("REF_TURNO"));
	            escuela.setRefTelefono(rs.getString("REF_TELEFONO"));
	            return escuela;
	        });
	    }
	
}
