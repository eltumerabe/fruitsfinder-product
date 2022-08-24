package com.fruitsfinder.product.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDTO {
    private String publicId;
    @NotNull(message = "imageString should not be null")
    private String imageString;
    @NotNull(message = "imageExtension should not be null")
    private String imageExtension;


}
