package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.ProductDTO;
import com.fruitsfinder.product.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductDtoToEntity implements Function<ProductDTO, Product> {

    private final ImageDtoToEntity imageDtoToEntity;
    private final PriceDtoToEntity priceDtoToEntity;
    private final AddressDtoToEntity addressDtoToEntity;

    @Override
    public Product apply(final ProductDTO productDTO) {
        return Product
                .builder()
                .publicId(UUID.randomUUID().toString())
                .productName(productDTO.getProductName())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .createdBy(productDTO.getCreatedBy())
                .price(priceDtoToEntity.apply(productDTO.getPrice()))
                .address(addressDtoToEntity.apply(productDTO.getAddress()))
                .images(productDTO
                        .getImages()
                        .stream()
                        .map(imageDtoToEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
