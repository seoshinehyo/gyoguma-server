package com.gyoguma.service.location;

import com.gyoguma.domain.Location;
import com.gyoguma.repository.location.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationQueryServiceImpl implements LocationQueryService {

    private final LocationRepository locationRepository;

    @Override
    public Location getLocation(Long locationId) {
        return locationRepository.findById(locationId).get();
    }
}
