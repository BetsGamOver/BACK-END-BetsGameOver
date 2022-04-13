package edu.eci.ieti.betsGameOver.exception;

import edu.eci.ieti.betsGameOver.error.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends RuntimeException {

	private static final long serialVersionUID = -5632608256392096224L;
	
	private final ServerErrorResponseDto serverErrorResponseDto;
    private final HttpStatus httpStatus;

    public InternalServerErrorException( ServerErrorResponseDto serverErrorResponseDto, HttpStatus httpStatus ) {
        this.serverErrorResponseDto = serverErrorResponseDto;
        this.httpStatus = httpStatus;
    }
}