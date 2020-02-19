package epam.alsab.dao.address;

import epam.alsab.dao.JdbcDaoSupport;
import epam.alsab.model.Address;
import epam.alsab.service.CityService;

import java.util.List;


public class AddressJdbcDAO extends JdbcDaoSupport implements AddressDAO {

    static final String CREATE_SQL = "INSERT INTO aleksei.address(address, address2, district, city_id, postal_code, phone) VALUES (?, ?, ?, ?, ?, ?)";
    static final String READ_SQL = "SELECT address_id, address, address2, district, city_id, postal_code, phone FROM aleksei.address WHERE address_id= ?";
    static final String UPDATE_SQL = "UPDATE aleksei.address SET address= ?, address2= ?, district= ?, city_id= ?, postal_code= ?, phone= ? WHERE address_id= ?";
    static final String DELETE_SQL = "DELETE FROM aleksei.address WHERE address_id= ?";
    static final String FIND_ALL_SQL = "SELECT address_id, address, address2, district, city_id, postal_code, phone FROM aleksei.address";
    static final String FIND_BY_ADDRESS_SQL = "SELECT address_id, address, address2, district, city_id, postal_code, phone FROM aleksei.address where address= ?";


    private JdbcDaoSupport.Mapper<Address> mapper = rs -> {
        Address address = new Address(
                rs.getLong("address_id"),
                rs.getString("address"),
                rs.getString("address2"),
                rs.getString("district"),
                CityService.getCityById(rs.getLong("city_id")),
                rs.getString("postal_code"),
                rs.getString("phone")
        );
        return address;
    };

    @Override
    public void create(Address address) {
        update(CREATE_SQL, address.getAddressId());
    }

    @Override
    public Address read(Long id) {
        return select(READ_SQL, mapper, id);
    }

    @Override
    public void update(Address address) {
        update(UPDATE_SQL, address.getAddress(), address.getAddress2(), address.getDistrict(), address.getCity().getCityId(), address.getPostalCode(), address.getAddressId());
    }

    @Override
    public void delete(Long id) {
        update(DELETE_SQL, id);
    }

    @Override
    public List<Address> findAll() {
        return selectList(FIND_ALL_SQL, mapper);
    }

    @Override
    public List<Address> findByAddress(String address) {
        return selectList(FIND_BY_ADDRESS_SQL, mapper, address);
    }

    @Override
    public boolean isExist(String address) {
        return !(findByAddress(address).isEmpty());
    }

}
