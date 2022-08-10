package com.sakanfinder.product.service.impl;

import com.sakanfinder.product.converters.ProductDtoToEntity;
import com.sakanfinder.product.converters.ProductEntityToDto;
import com.sakanfinder.product.dto.ProductDTO;
import com.sakanfinder.product.repository.ProductRepository;
import com.sakanfinder.product.service.ProductService;
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
