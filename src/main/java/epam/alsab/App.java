package epam.alsab;

import epam.alsab.model.Address;
import epam.alsab.model.City;
import epam.alsab.service.AddressService;
import epam.alsab.service.CityService;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {

        if (!CityService.isExist("Vitebsk")) {
            CityService.createCity(new City((long) 0, "Vitebsk"));
        }

        //System.out.println(Arrays.toString(CityService.getAllCities().toArray()));
        List<Address> addresses = AddressService.getAllAddresses();

        for (Address address : addresses) {
            System.out.println(address.toString());
        }

    }

}
