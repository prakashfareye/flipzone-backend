package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Address;
import com.fareye.flipzone.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address){
        Address address1 = addressService.create(address);
        return new ResponseEntity<>(address1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable long id){
        return addressService.getAddressById(id);
    }

    @GetMapping("/u/{id}")
    public List<Address> getAddressByUserId(@PathVariable long id){
        return addressService.getAddressByUserId(id);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable long id, @RequestBody Address updatedAddress){
        return addressService.updateAddress(id, updatedAddress);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        addressService.deleteAddress(id);
        return "Address Deleted";
    }

}
