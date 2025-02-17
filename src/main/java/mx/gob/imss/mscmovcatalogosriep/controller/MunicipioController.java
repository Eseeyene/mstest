package mx.gob.imss.mscmovcatalogosriep.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import mx.gob.imss.mscmovcatalogosriep.exception.BusinessException;
import mx.gob.imss.mscmovcatalogosriep.model.Municipio;
import mx.gob.imss.mscmovcatalogosriep.model.RespuestaError;
import mx.gob.imss.mscmovcatalogosriep.service.MunicipioService;


@Slf4j
@RestController
@RequestMapping("mscmov-catalogos/v1")
public class MunicipioController {
	

	private final MunicipioService municipioService;
	private ResponseEntity<?> responseEntity;
	HttpStatus status;
	
	public  MunicipioController(MunicipioService municipioService) {
		this.municipioService = municipioService;
		this.responseEntity = null;
		this.status = HttpStatus.OK;
	}
	
	/*
	@Operation(summary = "Obtener el  Municipio por  su Id", tags = { "Municipios" } )
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Ok",content = { 
    		  @Content(mediaType = "application/json", schema = @Schema(implementation = Municipio.class))}),
      @ApiResponse(responseCode = "204", description = "Not_content"),
      @ApiResponse(responseCode = "409", description = "Conflict",content = {
    		  @Content(mediaType = "application/json",schema = @Schema(implementation = RespuestaError.class))}) })
    @GetMapping(value = "/municipios/{idMunicipio}", produces = { "application/json" })
    public ResponseEntity<?> consultaMunicipioId(
   		 @Parameter(in = ParameterIn.DEFAULT, description = "ID municipio", schema = @Schema()) @PathVariable Long idMunicipio
   		) {
    	try {
   		 return new ResponseEntity<>(municipioService.consultaMunicipioId(idMunicipio), HttpStatus.OK);
		} catch (BusinessException be) {
			log.error("Error al consultar: {}", be.getMessage());
			int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
			RespuestaError respuestaError = be.getRespuestaError();
			responseEntity = new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
		} catch (Exception e) {
			log.error("Exception al consultar el catalogo de municipio por Id", e);
		}
    	return responseEntity;
		
	}*/
	
	@Operation(summary = "Obtener el listado del Municipios por el nombre de la Entidad Federativa ", tags = { "Municipios" })
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Ok",content = { 
    		  @Content(mediaType = "application/json", schema = @Schema(implementation = Municipio.class))}),
      @ApiResponse(responseCode = "204", description = "Not_content"),
      @ApiResponse(responseCode = "409", description = "Conflict",content = {
    		  @Content(mediaType = "application/json",schema = @Schema(implementation = RespuestaError.class))}) })
    @GetMapping(value = "/municipios", produces = { "application/json" })
	public ResponseEntity<?> consultaMunicipioIdEntidadFederativa(
	   		@RequestParam(required = true) String idEntidadFederativa
	   		) {
		 ResponseEntity<?> responseEntity = null;
	    	try {

	 			List<Municipio> municipiosIdEntidadFed = municipioService.consultaMunicipioIdEntidad(idEntidadFederativa);
				if (municipiosIdEntidadFed.isEmpty()) {
					status = HttpStatus.NO_CONTENT;
				}
				responseEntity = new ResponseEntity<>(municipiosIdEntidadFed, status);
	    	
	    	} catch (BusinessException be) {
				log.error("Error al consultar: {}", be.getMessage());
				int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
				RespuestaError respuestaError = be.getRespuestaError();
				responseEntity = new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
			} catch (Exception e) {
				log.error("Exception al consultar el catalogo de Municipio por nombre  de la Entidad Federativa", e);
			}
	    	return responseEntity;
			
			
		}
	
//	@Operation(summary = "Obtener el listado del Municipios", tags = { "Municipios" })
//    @ApiResponses(value = { 
//      @ApiResponse(responseCode = "200", description = "Ok",content = { 
//    		  @Content(mediaType = "application/json", schema = @Schema(implementation = Municipio.class))}),
//      @ApiResponse(responseCode = "204", description = "Not_content"),
//      @ApiResponse(responseCode = "409", description = "Conflict",content = {
//    		  @Content(mediaType = "application/json",schema = @Schema(implementation = RespuestaError.class))}) })
//    @GetMapping(value = "/municipios", produces = { "application/json" })
//	public ResponseEntity<?> consultaMunicipios(
//	   		) {
//		 ResponseEntity<?> responseEntity = null;
//	    	try {
//
//	 			List<Municipio> municipios = municipioService.consultaMunicipios();
//				if (municipios.isEmpty()) {
//					status = HttpStatus.NO_CONTENT;
//				}
//				responseEntity = new ResponseEntity<>(municipios, status);
//	    	
//	    	} catch (BusinessException be) {
//				log.error("Error al consultar: {}", be.getMessage());
//				int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
//				RespuestaError respuestaError = be.getRespuestaError();
//				responseEntity = new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
//			} catch (Exception e) {
//				log.error("Exception al consultar el catalogo de Municipios", e);
//			}
//	    	return responseEntity;	
//		}

}
