package mx.gob.imss.mscmovcatalogosriep.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import mx.gob.imss.mscmovcatalogosriep.model.RespuestaError;


@Setter
@Getter
public class BusinessException extends Exception {
	private static final long serialVersionUID = 2044610281664856520L;
	private transient RespuestaError respuestaError;

	public BusinessException(
			HttpStatus status,
			String businessMessage,
			String reasonPhrase) {
		super(reasonPhrase);

        respuestaError = new RespuestaError(status, businessMessage, reasonPhrase);
	}

	public BusinessException(RespuestaError respuestaError) {
		this.respuestaError = respuestaError;
	}

}