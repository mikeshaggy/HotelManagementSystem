package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends JpaRepository<Address, Long> {
}
