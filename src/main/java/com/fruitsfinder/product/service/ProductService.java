package com.fruitsfinder.product.service;

import com.fruitsfinder.product.model.dto.ProductDTO;

public interface ProductService {
    ProductDTO createProduct(final ProductDTO productDTO);

    ProductDTO getByPublicId(final String publicId);

}
