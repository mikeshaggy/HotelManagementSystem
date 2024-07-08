package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.controller.base.BaseRestController;
import com.mikeshaggy.hms.model.Address;
import com.mikeshaggy.hms.service.AddressService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/addresses")
public class AddressRestController extends BaseRestController<Address, Long> {

    private final AddressService addressService;

    public AddressRestController(AddressService addressService) {
        super(addressService);
        this.addressService = addressService;
    }
}
