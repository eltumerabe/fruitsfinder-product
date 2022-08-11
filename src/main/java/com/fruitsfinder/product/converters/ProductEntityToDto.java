package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.ProductDTO;
import com.fruitsfinder.product.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductEntityToDto implements Function<Product, ProductDTO> {

    private final ImageEntityToDto imageEntityToDto;
    private final PriceEntityToDto priceEntityToDto;

    @Override
    public ProductDTO apply(Product product) {
        return ProductDTO
                .builder()
                .publicId(product.getPublicId())
                .productName(product.getProductName())
                .price(priceEntityToDto.apply(product.getPrice()))
                .images(product
                        .getImages()
                        .stream()
                        .map(imageEntityToDto)
                        .collect(Collectors.toSet()))
                .build();
    }
}
