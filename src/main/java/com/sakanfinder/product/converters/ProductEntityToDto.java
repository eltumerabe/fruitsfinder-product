package com.sakanfinder.product.converters;

import com.sakanfinder.product.dto.ProductDTO;
import com.sakanfinder.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductEntityToDto implements Function<Product,ProductDTO> {

    private final ImageEntityToDto imageEntityToDto;

    @Override
    public ProductDTO apply(Product product) {
        return ProductDTO
                .builder()
                .publicId(product.getPublicId())
                .images(product
                        .getImages()
                        .stream()
                        .map(imageEntityToDto)
                        .collect(Collectors.toSet()))
                .build();
    }
}
