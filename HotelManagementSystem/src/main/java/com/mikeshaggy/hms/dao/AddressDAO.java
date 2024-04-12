package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.address.Address;

public interface AddressDAO {
    void create(Address address);
    Address findById(long id);
}
