package mx.gob.imss.mscmovcatalogosriep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
import mx.gob.imss.mscmovcatalogosriep.model.EntidadFederativa;
import mx.gob.imss.mscmovcatalogosriep.model.RespuestaError;
import mx.gob.imss.mscmovcatalogosriep.service.EntidadFederativaService;


@Slf4j
@RestController
@RequestMapping("mscmov-catalogos/v1")
public class EntidadFederativaController {
	
	@Autowired	
	EntidadFederativaService entidadFederativaService;
	
	private ResponseEntity<?> responseEntity;
	HttpStatus status;
	
	public EntidadFederativaController( EntidadFederativaService entidadFederativaService) {
		this.entidadFederativaService = entidadFederativaService;
		this.responseEntity = null;
		this.status = HttpStatus.OK;
		
	}
	
	@Operation(summary = "Obtener el listado del Entidades Federativas",tags = { "EntidadesFederativas" })
    @ApiResponses(value = { 
      @ApiResponse(responseCode = "200", description = "Ok",content = { 
    		  @Content(mediaType = "application/json", schema = @Schema(implementation = EntidadFederativa.class))}),
      @ApiResponse(responseCode = "204", description = "Not_content"),
      @ApiResponse(responseCode = "409", description = "Conflict",content = {
    		  @Content(mediaType = "application/json",schema = @Schema(implementation = RespuestaError.class))}) })
    @GetMapping(value = "/entidadesFederativas", produces = { "application/json" })
	public ResponseEntity<?> consultaEntidadesFederativas() {
    	try {
			List<EntidadFederativa> entidadFederativa = entidadFederativaService.consultaEntidadFederativa();
			if (entidadFederativa.isEmpty()) {
				status = HttpStatus.NO_CONTENT;
			}
			responseEntity = new ResponseEntity<>(entidadFederativa, status);
		} catch (BusinessException be) {
			log.error("Error al consultar: {}", be.getMessage());
			int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
			RespuestaError respuestaError = be.getRespuestaError();
			responseEntity = new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
		} catch (Exception e) {
			log.error("Exception al consultar el catalogo de Entidad Federativa", e);
		}
    	return responseEntity;
		
		
	}
	/*
    @Operation(summary = "Obtención de Entidad Federativa por ID", description = "Obtiene la  Entidad Federativa por Id.", tags = { "EntidadesFederativas" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = EntidadFederativa.class))
        }),
        @ApiResponse(responseCode = "204", description = "Sin coincidencias"),
        @ApiResponse(responseCode = "500", description = "Error interno", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaError.class))
        })
    })
    @GetMapping(value = "/entidadesFederativas/{idEntidadFederativa}", produces = {"application/json"})
    public ResponseEntity<?> consultaEntidadesFederativasPorId(
    		 @Parameter(in = ParameterIn.DEFAULT, description = "ID Entidad Federativa", schema = @Schema()) @PathVariable Long idEntidadFederativa
    		) {
    	 ResponseEntity<?> responseEntity = null;
    	try {
    		 return new ResponseEntity<>(entidadFederativaService.consultaEntidadFederativaId(idEntidadFederativa), HttpStatus.OK);
		} catch (BusinessException be) {
			log.error("Error al consultar: {}", be.getMessage());
			int numberHTTPDesired = Integer.parseInt(be.getRespuestaError().getCode());
			RespuestaError respuestaError = be.getRespuestaError();
			responseEntity = new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHTTPDesired));
		} catch (Exception e) {
			log.error("Exception al consultar el catalogo de Entidad Federativa", e);
		}
    	return responseEntity;
		
		
	}*/
	

}
