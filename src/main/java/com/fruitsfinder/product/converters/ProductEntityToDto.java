package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.ProductDTO;
import com.fruitsfinder.product.model.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductEntityToDto implements Function<Product, ProductDTO> {

    private final ImageEntityToDto imageEntityToDto;
    private final PriceEntityToDto priceEntityToDto;
    private final AddressEntityToDto addressEntityToDto;

    @Override
    public ProductDTO apply(final Product product) {
        return ProductDTO
                .builder()
                .publicId(product.getPublicId())
                .productName(product.getProductName())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .createdBy(product.getCreatedBy())
                .price(priceEntityToDto.apply(product.getPrice()))
                .address(addressEntityToDto.apply(product.getAddress()))
                .images(product
                        .getImages()
                        .stream()
                        .map(imageEntityToDto)
                        .collect(Collectors.toSet()))
                .build();
    }
}
