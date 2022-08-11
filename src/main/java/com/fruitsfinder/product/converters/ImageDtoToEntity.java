package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.ImageDTO;
import com.fruitsfinder.product.model.entity.Image;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class ImageDtoToEntity implements Function<ImageDTO, Image> {

    @Override
    public Image apply(final ImageDTO imageDTO) {
        return Image
                .builder()
                .publicId(UUID.randomUUID().toString())
                .imageString(imageDTO.getImageString())
                .imageExtension(imageDTO.getImageExtension())
                .build();
    }
}
