package epam.alsab.dao.city;

import java.util.List;

import epam.alsab.dao.CrudDao;
import epam.alsab.model.City;

public interface CityDAO extends CrudDao<City, Long> {

    List<City> findAll();
    List<City> findByName(String name);
    boolean isExist(String name);
    
}
