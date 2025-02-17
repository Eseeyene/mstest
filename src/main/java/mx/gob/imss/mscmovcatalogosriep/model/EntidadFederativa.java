package mx.gob.imss.mscmovcatalogosriep.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadFederativa {
	
		  @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Identificadora de la Entidad Federativa")
		  private Long idEntidadFederativa;
		  
		  @Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Nombre de la Entidad Federativa")
		  private String nomEntidadFederativa;

}
