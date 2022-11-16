package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Address;
import com.fareye.flipzone.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {
    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    AddressServiceImpl addressService;

    private Address address;

    @BeforeEach
    public void setup(){
        long id=2;
        address = Address.builder()
                .address_id(id)
                .pinCode("201313")
                .description("gautam buddha nagar")
                .userId(1)
                .build();
    }

    @DisplayName("JUnit Test for Create Address")
    @Test
    public void createAddressTest() {
        when(addressRepository.save(address)).thenReturn(address);
        assertEquals(address, addressService.create(address));
    }
    @DisplayName("JUnit Test for getting Address using Id")
    @Test
    public void getAddressByIdTest() {
        long id = 2;
        when(addressRepository.findById(id)).thenReturn(Optional.ofNullable(address));
        assertEquals(address,addressService.getAddressById(id));
    }

    @DisplayName("JUnit Test for getting Address using Id Exception case")
    @Test
    public void getAddressByIdTestException() {
        long id = 2;
        assertThrows(RuntimeException.class,()->{addressService.getAddressById(id);});
    }

    @DisplayName("JUnit Test for getting Address using user id")
    @Test
    public void getAddressByUserIdTest() {
        long id=5;
        when(addressRepository.findByUserId(id)).thenReturn(address);
        assertEquals(address,addressService.getAddressByUserId(id));
    }

    @DisplayName("JUnit Test for Updating address using Id and newAddress object")
    @Test
    public void updateAddressTest(){
        long id = 2;
        when(addressRepository.findById(id)).thenReturn(Optional.ofNullable(address));

        address.setPinCode("200101");
        when(addressRepository.save(address)).thenReturn(address);
        assertEquals(address , addressService.updateAddress(id,address));
    }

    @DisplayName("JUnit Test for Updating Address using Id and newAddress object Exception")
    @Test
    public void updateAddressExceptionTest(){
        long id = 2;
        assertThrows(RuntimeException.class,()->{addressService.updateAddress(id,address);});
    }

    @DisplayName("JUnit Test for Deleting Address using Id")
    @Test
    public void deleteAddressTest(){
        long id = 1;
        when(addressRepository.findById(id)).thenReturn(Optional.ofNullable(address));

        addressService.deleteAddress(id);
        verify(addressRepository, times(1)).deleteById(id);}


    @DisplayName("JUnit Test for Deleting Address using Id Exception case")
    @Test
    public void deleteAddressTest_Exception(){
        long id = 2;
        assertThrows(RuntimeException.class,()->{addressService.deleteAddress(id);});
    }

}