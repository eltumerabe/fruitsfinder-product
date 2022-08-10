package com.sakanfinder.product.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class ProductDTO {
    private String publicId;
    private Set<ImageDTO> images = new HashSet<>();

}
