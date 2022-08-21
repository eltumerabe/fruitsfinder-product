package com.fruitsfinder.product.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fruitsfinder.product.enums.ProductName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private String publicId;
    private ProductName productName;
    private PriceDTO price;
    private AddressDTO address;
    private Set<ImageDTO> images = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;


}
