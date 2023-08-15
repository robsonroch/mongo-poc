package br.com.robson.apipocmongo.interactors.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.robson.apipocmongo.transportlayers.openapi.model.GeneralError;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<GeneralError> handleAllExceptions(
			Exception ex, WebRequest request) {
		
		GeneralError generalError = new GeneralError();
		generalError.code(500).message(ex.getMessage()).timestamp(new Date());
		
		
		
		return new ResponseEntity<>(generalError, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<GeneralError> handleNotFoundExceptions(
			Exception ex, WebRequest request) {
		
		GeneralError generalError = new GeneralError();
		generalError.code(404).message(ex.getMessage()).timestamp(new Date());
		
		return new ResponseEntity<>(generalError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RequiredObjectIsNullException.class)
	public final ResponseEntity<GeneralError> handleBadRequestExceptions(
			Exception ex, WebRequest request) {
		
		GeneralError generalError = new GeneralError();
		generalError.code(400).message(ex.getMessage()).timestamp(new Date());
		
		return new ResponseEntity<>(generalError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ErroNegocioException.class)
	public final ResponseEntity<GeneralError> handleBadRequestNegocioExceptions(
			Exception ex, WebRequest request) {
		
		GeneralError generalError = new GeneralError();
		generalError.code(400).message(ex.getMessage()).timestamp(new Date());
		
		return new ResponseEntity<>(generalError, HttpStatus.BAD_REQUEST);
	}

}
