package mx.gob.imss.mscmovcatalogosriep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.integration.repository.MunicipioRepository;
import mx.gob.imss.mscmovcatalogosriep.model.Municipio;
import mx.gob.imss.mscmovcatalogosriep.service.MunicipioService;



@Service
public class MunicipioServiceImpl implements MunicipioService {
	@Autowired
	MunicipioRepository  municipioRepository;
	
	@Override
	public List<Municipio> consultaMunicipioIdEntidad(String idEntidadFederativa) throws BusinessException {
		 try {
		      return municipioRepository.consultaMunicipioIdEntidad(idEntidadFederativa);
       } catch(Exception e){
           throw new BusinessException(HttpStatus.NO_CONTENT,"Error en consultar Lista de municipios", e.getMessage());
       }
		
	}

	@Override
	public Municipio consultaMunicipioId(Long idMunicipio)
			throws BusinessException {
				try {
					return municipioRepository.consultaIdMunicipio(idMunicipio);
				} catch(Exception e){
					throw new BusinessException(HttpStatus.NO_CONTENT,"Error en consultar el municipio por id's", e.getMessage());
				}
	}
	
	@Override
	public List<Municipio> consultaMunicipios() throws BusinessException {
		 try {
		      return municipioRepository.consultaMunicipios();
      } catch(Exception e){
          throw new BusinessException(HttpStatus.NO_CONTENT,"Error en consultar Lista de municipios", e.getMessage());
      }
		
	}

}
