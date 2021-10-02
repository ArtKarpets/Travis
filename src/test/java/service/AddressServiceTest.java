package service;

import entity.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressServiceTest {
    private AddressService addressService = new AddressService();
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String HOME = "1";
    private Address address = new Address(CITY, STREET, HOME);

    @Test
    public void getAll() {
        assertFalse(addressService.getAll().isEmpty());
    }

    @Test
    public void save() {
        addressService.save(address);
        assertEquals(address, addressService.getByHome(HOME));

    }

    @Test
    public void update() {
        addressService.update(address);
        assertEquals(address, addressService.getByHome(HOME));
    }

    @Test
    public void delete() {
        addressService.save(address);
        addressService.delete(address);
        assertTrue(addressService.getByHome(HOME) == null);
    }

    @Test
    public void getByHome() {
        addressService.save(address);
        assertEquals(address, addressService.getByHome(HOME));
    }

    @Test
    public void createNewAddress() {
        addressService.save(address);
        assertFalse(addressService.getByHome(HOME).isEmpty());
    }
}