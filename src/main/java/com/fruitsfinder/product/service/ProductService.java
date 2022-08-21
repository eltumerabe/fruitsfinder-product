package com.fruitsfinder.product.service;

import com.fruitsfinder.product.exception.ResourceNotFoundException;
import com.fruitsfinder.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(final ProductDTO productDTO);

    ProductDTO getByPublicId(final String publicId) throws ResourceNotFoundException;

    List<ProductDTO> getAll(final int page, final int size);

}
