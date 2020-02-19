package epam.alsab.dao.address;

import java.util.List;

import epam.alsab.dao.CrudDao;
import epam.alsab.model.Address;

public interface AddressDAO extends CrudDao<Address, Long> {

    List<Address> findAll();

    List<Address> findByAddress(String address);

    boolean isExist(String address);
}
