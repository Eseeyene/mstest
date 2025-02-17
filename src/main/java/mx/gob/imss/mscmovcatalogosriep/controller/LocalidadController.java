package mx.gob.imss.mscmovcatalogosriep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Escuela;
import mx.gob.imss.mscmovcatalogosriep.model.Localidad;
import mx.gob.imss.mscmovcatalogosriep.model.RespuestaError;
import mx.gob.imss.mscmovcatalogosriep.service.LocalidadService;

@Slf4j
@RestController
@RequestMapping("mscmov-catalogos/v1")
public class LocalidadController {
	
	@Autowired
	LocalidadService localidadService;
	
	
	@Operation(summary = "Obtener Colonia/Localidad por Entidad y Municipio", tags = { "Localidades" } )
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Ok",content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Localidad.class))}),
      @ApiResponse(responseCode = "204", description = "No Content"),
      @ApiResponse(responseCode = "409", description = "Conflict",content = { @Content(mediaType = "application/json",schema = @Schema(implementation = RespuestaError.class))}) })
    @GetMapping(value = "/localidades", produces = { "application/json" })
    public ResponseEntity<?> consultaLocalidadMunicipioEntidad( 
            @RequestParam(required = true) String refEntidadFederativa,
            @RequestParam(required = true) String refMunicipio

) {
   				ResponseEntity<?> responseEntity = null;
   				HttpStatus status = null;
   				try {
   					
 				    List<Localidad> localidades = localidadService.consultaColoniaMunEntidad(refMunicipio, refEntidadFederativa);     
					if (localidades.isEmpty()) {
   			            status = HttpStatus.NO_CONTENT;
   			        } else {
   			            status = HttpStatus.OK;
   			        }
					
   			        responseEntity = new ResponseEntity<>(localidades, status);
   			    } catch (BusinessException be) {
   			        log.error("Error al consultar: {}", be.getMessage());
   			        int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
   			        RespuestaError respuestaError = be.getRespuestaError();
   			        responseEntity = new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
   			    } catch (Exception e) {
   			        log.error("Exception al consultar el catalogo de escuelas", e);
   			    }
   			    return responseEntity;
   			}

}
