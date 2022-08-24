package com.fruitsfinder.product.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fruitsfinder.product.enums.ProductName;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "productName should not be null")
    private ProductName productName;
    @NotNull(message = "price should not be null")
    private @Valid PriceDTO price;
    @NotNull(message = "address should not be null")
    private @Valid AddressDTO address;
    @NotNull(message = "images should not be null")
    @NotEmpty(message = "images should not be empty")
    private Set<  @Valid ImageDTO> images = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String createdBy;


}
