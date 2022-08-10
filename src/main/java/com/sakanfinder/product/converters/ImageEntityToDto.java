package com.sakanfinder.product.converters;

import com.sakanfinder.product.dto.ImageDTO;
import com.sakanfinder.product.entity.Image;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class ImageEntityToDto implements Function<Image,ImageDTO> {


    @Override
    public ImageDTO apply(Image image) {
        return ImageDTO
                .builder()
                .publicId(UUID.randomUUID().toString())
                .imageString(image.getImageString())
                .build();
    }
}
