package com.mikeshaggy.hms.repository;

import com.mikeshaggy.hms.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends JpaRepository<Address, Long> {
}
