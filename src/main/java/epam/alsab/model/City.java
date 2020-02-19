package epam.alsab.model;

public class City {
    private Long cityId;
    private String name;

    public City(Long cityId, String name) {
        this.cityId = cityId;
        this.name = name;        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    @Override
    public String toString() {
        return "City [cityId=" + cityId + ", name=" + name + "]";
    }
}
