package com.fruitsfinder.product.service.impl;

import com.fruitsfinder.product.converters.ProductDtoToEntity;
import com.fruitsfinder.product.converters.ProductEntityToDto;
import com.fruitsfinder.product.model.dto.ProductDTO;
import com.fruitsfinder.product.repository.ProductRepository;
import com.fruitsfinder.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoToEntity productDtoToEntity;
    private final ProductEntityToDto productEntityToDto;

    @Override
    public ProductDTO createProduct(final ProductDTO productDTO) {
        return Optional.of(productRepository.save(productDtoToEntity.apply(productDTO)))
                .map(productEntityToDto)
                .orElse(null);
    }


    @Override
    public ProductDTO getByPublicId(String publicId) {
        return productRepository.findByPublicId(publicId)
                .map(productEntityToDto)
                .orElse(null);
    }
}
