package com.mikeshaggy.hms.service.entity;

import com.mikeshaggy.hms.model.Address;
import com.mikeshaggy.hms.repository.AddressRepository;
import com.mikeshaggy.hms.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseService<Address, Long> {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
        this.addressRepository = addressRepository;
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
