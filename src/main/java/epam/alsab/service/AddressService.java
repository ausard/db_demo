package epam.alsab.service;

import epam.alsab.dao.address.AddressJdbcDAO;
import epam.alsab.model.Address;

import java.util.List;

public class AddressService {

    private static final AddressJdbcDAO addressJdbcDAO = new AddressJdbcDAO();

    public static void createAddress(Address address) {
        addressJdbcDAO.create(address);
    }

    public static Address getAddressById(Long addressId) {
        return addressJdbcDAO.read(addressId);
    }

    public static List<Address> getAllAddresses() {
        return addressJdbcDAO.findAll();
    }

    public static void updateAddress(Address address) {
        addressJdbcDAO.update(address);
    }

    public static void deleteAddressById(Long addressId) {
        addressJdbcDAO.delete(addressId);
    }

    public static List<Address> findAddressByAddress(String address) {
        return addressJdbcDAO.findByAddress(address);
    }

    public static boolean isExist(String address) {
        return addressJdbcDAO.isExist(address);
    }
}
