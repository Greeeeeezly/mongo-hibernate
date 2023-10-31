package mongodb.demo.mongodemo.controllers;

import mongodb.demo.mongodemo.models.Resident;
import mongodb.demo.mongodemo.services.ResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ResidentController {
    @Autowired
    private ResidentsService residentsService;

    @GetMapping("/residents")
    private List<Resident> getAll(){
        return residentsService.getAllResidents();
    }
    @GetMapping("/residents/{id}")
    private Optional<Resident> findOne(@RequestParam String id){
        return residentsService.getResident(id);
    }
    /*private String house;
    private String resident;

    public ResidentController(String house, String resident) {
        this.house = house;
        this.resident = resident;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }*/
}
