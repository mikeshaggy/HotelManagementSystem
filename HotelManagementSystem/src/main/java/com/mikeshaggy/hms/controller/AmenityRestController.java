package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Amenity;
import com.mikeshaggy.hms.service.entity.AmenityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amenities")
public class AmenityRestController extends BaseRestController<Amenity, Integer> {

    private final AmenityService amenityService;

    public AmenityRestController(AmenityService amenityService) {
        super(amenityService);
        this.amenityService = amenityService;
    }
}
