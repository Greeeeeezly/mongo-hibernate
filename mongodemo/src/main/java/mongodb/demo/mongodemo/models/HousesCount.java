package mongodb.demo.mongodemo.models;

import org.springframework.stereotype.Component;


public class HousesCount {
    private Integer count;
    private Integer house;

    public HousesCount(Integer count, Integer house) {
        this.count = count;
        this.house = house;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "HousesCount{" +
                "count=" + count +
                ", house=" + house +
                '}';
    }
}
