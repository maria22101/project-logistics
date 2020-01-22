package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findAddressesById(Long id);
    Optional<Address> findAddressesByStreetAndHouseAndApartment(String street, String house, String apartment);
}
