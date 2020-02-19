package epam.alsab.service;

import epam.alsab.dao.city.CityJdbcDAO;
import epam.alsab.model.City;

import java.util.List;

public class CityService {

    private final static CityJdbcDAO cityJdbcDao = new CityJdbcDAO();

    public static void createCity(City city) {
        cityJdbcDao.create(city);
    }

    public static City getCityById(Long cityId) {
        return cityJdbcDao.read(cityId);
    }

    public static List<City> getAllCities() {
        return cityJdbcDao.findAll();
    }

    public static void updateCity(City city) {
        cityJdbcDao.update(city);
    }

    public static void deleteCity(Long cityId) {
        cityJdbcDao.delete(cityId);
    }

    public static List<City> findByName(String name) {
        return cityJdbcDao.findByName(name);
    }

    public static boolean isExist(String name) {
        return cityJdbcDao.isExist(name);
    }
}
