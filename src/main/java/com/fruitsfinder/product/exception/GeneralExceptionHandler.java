package com.fruitsfinder.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetailsDTO handleResourceNotFoundException(final ResourceNotFoundException ex,final WebRequest webRequest){
        ErrorDetailsDTO errorDetailsDTO = ErrorDetailsDTO
                .builder()
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .httpStatus(HttpStatus.NOT_FOUND)
                .publicId(ex.getPublicId())
                .timestamp(LocalDateTime.now())
                .uri(((ServletWebRequest)webRequest).getRequest().getRequestURI())
                .message(ex.getMessage())
                .errors(List.of(ErrorDTO
                        .builder()
                                .filed("publicId")
                                .errorDescription(ex.getMessage())
                                .errorLocation(ex.getLocation())
                        .build()))
                .build();
        log.error("Resource with publicId {} not found, object details {}, stackTrace",errorDetailsDTO.getPublicId(),errorDetailsDTO,ex);
        return errorDetailsDTO;
    }
}
