package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.ImageDTO;
import com.fruitsfinder.product.model.entity.Image;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class ImageEntityToDto implements Function<Image, ImageDTO> {


    @Override
    public ImageDTO apply(final Image image) {
        return ImageDTO
                .builder()
                .publicId(UUID.randomUUID().toString())
                .imageString(image.getImageString())
                .imageExtension(image.getImageExtension())
                .build();
    }
}
