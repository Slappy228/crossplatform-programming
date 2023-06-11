package org.example.testing.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Mock
    private AddressService addressService;

    @Test
    public void addAddress_shouldSaveAddress() throws Exception {
        Address address = new Address();
        addressService.addAddress(address);
        verify(addressService, times(1)).addAddress(address);
    }

    @Test
    public void updateAddress_shouldUpdateAddress() throws Exception {
        Integer addressId = 1;
        Address address = new Address();
        addressService.updateAddress(addressId, address);
        verify(addressService, times(1)).updateAddress(addressId, address);
    }

    @Test
    public void deleteAddress_shouldDeleteAddress() throws Exception {
        Integer addressId = 1;
        addressService.deleteAddress(addressId);
        verify(addressService, times(1)).deleteAddress(addressId);
    }
}
