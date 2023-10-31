package mongodb.demo.mongodemo.models;

public class Apartment {
    private Integer number;
    private Integer area;

    private Integer bedroom_count;

    public Apartment(Integer number, Integer area, Integer bedroom_count) {
        this.number = number;
        this.area = area;
        this.bedroom_count = bedroom_count;
    }

    public Integer getBedroom_count() {
        return bedroom_count;
    }

    public void setBedroom_count(Integer bedroom_count) {
        this.bedroom_count = bedroom_count;
    }

    public Apartment() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}