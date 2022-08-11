package com.fruitsfinder.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class ImageDTO {
    private String publicId;
    private String imageString;
    private String imageExtension;


}
