package com.fruitsfinder.product.converters;

import com.fruitsfinder.product.model.dto.LocationDTO;
import com.fruitsfinder.product.model.entity.Location;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class LocationEntityToDto implements Function<Location, LocationDTO> {
    @Override
    public LocationDTO apply(final Location location) {
        return LocationDTO
                .builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .build();
    }
}
