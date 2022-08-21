package com.fruitsfinder.product.service.impl;

import com.fruitsfinder.product.converters.ProductDtoToEntity;
import com.fruitsfinder.product.converters.ProductEntityToDto;
import com.fruitsfinder.product.enums.ErrorLocation;
import com.fruitsfinder.product.enums.ErrorMessage;
import com.fruitsfinder.product.exception.ResourceNotFoundException;
import com.fruitsfinder.product.model.dto.ProductDTO;
import com.fruitsfinder.product.repository.ProductRepository;
import com.fruitsfinder.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public ProductDTO getByPublicId(final String publicId) throws ResourceNotFoundException {
        return productRepository.findByPublicId(publicId)
                .map(productEntityToDto)
                .orElseThrow(()-> ResourceNotFoundException
                        .builder()
                        .location(ErrorLocation.SERVICE)
                        .message(ErrorMessage.RESOURCE_NOT_FOUND.toString())
                        .publicId(publicId)
                        .build());
    }


    @Override
    public List<ProductDTO> getAll(final int page, final int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("createdAt").ascending());
        return productRepository.findAll(pageRequest)
                .stream()
                .map(productEntityToDto)
                .collect(Collectors.toList());
    }
}
