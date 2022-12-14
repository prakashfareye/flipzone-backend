package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Address;

import java.util.List;

public interface AddressService {

    Address create(Address address);

    Address getAddressById(long id);

    List<Address> getAddressByUserId(long id);

    Address updateAddress(long id, Address newAddress);

    void deleteAddress(long id);
}
