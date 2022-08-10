package com.sakanfinder.product.converters;

import com.sakanfinder.product.dto.ImageDTO;
import com.sakanfinder.product.entity.Image;
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
                .build();
    }
}
