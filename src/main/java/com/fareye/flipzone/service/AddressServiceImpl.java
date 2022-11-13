package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Address;
import com.fareye.flipzone.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getAddressById(long id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address Not Found")
        );
    }

    @Override
    public Address getAddressByUserId(long id) {
        Address address = addressRepository.findByUserId(id);
        return address != null ? address : null;
    }

    @Override
    public Address updateAddress(long id, Address newAddress) {
        Address oldAddress = addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Address Not Found"));

        oldAddress.setPinCode(newAddress.getPinCode());
        oldAddress.setDescription(newAddress.getDescription());
        return addressRepository.save(oldAddress);
    }

    @Override
    public void deleteAddress(long id) {
        addressRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product Not Found"));
        addressRepository.deleteById(id);

    }
}
