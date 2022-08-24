package com.fruitsfinder.product.exception;

import com.fruitsfinder.product.enums.ErrorLocation;
import com.fruitsfinder.product.enums.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDetailsDTO handleResourceNotFoundException(final ResourceNotFoundException ex, final WebRequest webRequest) {
        ErrorDetailsDTO errorDetailsDTO = ErrorDetailsDTO
                .builder()
                .httpStatusCode(HttpStatus.NOT_FOUND.value())
                .httpStatus(HttpStatus.NOT_FOUND)
                .publicId(ex.getPublicId())
                .timestamp(LocalDateTime.now())
                .uri(((ServletWebRequest) webRequest).getRequest().getRequestURI())
                .message(ex.getMessage())
                .errors(List.of(ErrorDTO
                        .builder()
                        .filed("publicId")
                        .errorDescription(ex.getMessage())
                        .errorLocation(ex.getLocation())
                        .build()))
                .build();
        log.error("Resource with publicId {} not found, object details {}, stackTrace", errorDetailsDTO.getPublicId(), errorDetailsDTO, ex);
        return errorDetailsDTO;
    }



     @Override
    protected @Nonnull ResponseEntity<Object> handleMethodArgumentNotValid(@Nonnull MethodArgumentNotValidException ex, @Nonnull HttpHeaders headers, @Nonnull HttpStatus status, @Nonnull WebRequest request) {
        ErrorDetailsDTO errorDetailsDTO = ErrorDetailsDTO
                .builder()
                .httpStatusCode(status.value())
                .httpStatus(status)
                .timestamp(LocalDateTime.now())
                .uri(((ServletWebRequest) request).getRequest().getRequestURI())
                .message(ErrorMessage.VALIDATION_ERROR.name())
                .errors(
                        ex.getBindingResult()
                                .getAllErrors()
                                .stream()
                                .map(objectError -> ErrorDTO
                                        .builder()
                                        .filed(((FieldError) objectError).getField())
                                        .errorDescription(objectError.getDefaultMessage())
                                        .errorLocation(ErrorLocation.SERVICE)
                                        .build())
                                .collect(Collectors.toList())
                )
                .build();
        log.error("Validation failed, details {} , stackTrace", errorDetailsDTO, ex);
        return new ResponseEntity<>(errorDetailsDTO, HttpStatus.BAD_REQUEST);
    }
}
