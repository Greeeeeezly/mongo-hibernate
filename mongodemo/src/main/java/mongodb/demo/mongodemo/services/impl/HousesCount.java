package mongodb.demo.mongodemo.services.impl;

public class HousesCount {
    private Integer count;
    private Integer house;

    public HousesCount(Integer count, Integer house) {
        this.count = count;
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
