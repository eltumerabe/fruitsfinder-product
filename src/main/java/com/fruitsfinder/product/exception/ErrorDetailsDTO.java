package com.fruitsfinder.product.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetailsDTO {
    private Integer httpStatusCode;
    private HttpStatus httpStatus;
    private String publicId;
    private LocalDateTime timestamp;
    private String uri;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ErrorDTO> errors;
}
