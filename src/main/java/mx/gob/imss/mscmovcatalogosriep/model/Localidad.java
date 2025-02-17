package mx.gob.imss.mscmovcatalogosriep.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Localidad {
	
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Identificador de la localidad")
	private long idLocalidad;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Nombre de la localidad")
    private String nomLocalidad;
    
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Clave del Codigo Postal")
    private String cveCodigoPostal;
	
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Clave de la entidad federativa")
	private String idEntidadFederativa;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Clave del municipio")
	private String cveMunicipio;

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Clave de la localidad")
	private String cveLocalidad;

}
