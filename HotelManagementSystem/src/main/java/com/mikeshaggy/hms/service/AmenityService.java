package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.model.Amenity;
import com.mikeshaggy.hms.repository.AmenityRepository;
import com.mikeshaggy.hms.repository.base.BaseRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AmenityService extends BaseService<Amenity, Integer> {

    private final AmenityRepository amenityRepository;

    public AmenityService(AmenityRepository amenityRepository) {
        super(amenityRepository);
        this.amenityRepository = amenityRepository;
    }

    @Override
    protected Class<Amenity> getEntityClass() {
        return Amenity.class;
    }
}
