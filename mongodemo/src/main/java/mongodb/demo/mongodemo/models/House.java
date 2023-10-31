package mongodb.demo.mongodemo.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class House {
    @Id
    private Integer number;
    private Integer flours;
    private List<Resident> residents;
}
