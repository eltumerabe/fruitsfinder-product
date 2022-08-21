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
public class ResourceNotFoundException extends RuntimeException{

    private ErrorLocation location;
    private String message;
    private String publicId;

}
