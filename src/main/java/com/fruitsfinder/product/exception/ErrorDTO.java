package com.fruitsfinder.product.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fruitsfinder.product.enums.ErrorLocation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
    private String filed;
    private String errorDescription;
    private ErrorLocation errorLocation;
    private String stackTrace;
}
