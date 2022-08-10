package com.sakanfinder.product.converters;

import com.sakanfinder.product.dto.ProductDTO;
import com.sakanfinder.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductDtoToEntity implements Function<ProductDTO, Product> {

    private final ImageDtoToEntity imageDtoToEntity;
    @Override
    public Product apply(final ProductDTO productDTO) {
        return Product
                .builder()
                .publicId(UUID.randomUUID().toString())
                .images(productDTO
                        .getImages()
                        .stream()
                        .map(imageDtoToEntity)
                        .collect(Collectors.toSet()))
                .build();
    }
}
