package com.mikeshaggy.hms.address.repository;

import com.mikeshaggy.hms.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends JpaRepository<Address, Long> {
}
