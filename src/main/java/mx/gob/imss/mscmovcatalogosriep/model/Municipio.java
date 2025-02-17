package mx.gob.imss.mscmovcatalogosriep.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Municipio {

  	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Identificador del municipio")
  	private Long IdMunicipio;	  

	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Clave del municipio")
	private Long cveMunicipio;
	  
	@Schema(requiredMode = Schema.RequiredMode.REQUIRED, description = "Nombre del municipio")
	private String nomMunicipio;
}
