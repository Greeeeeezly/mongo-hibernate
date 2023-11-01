package mongodb.demo.mongodemo.controllers;

import mongodb.demo.mongodemo.models.Resident;
import mongodb.demo.mongodemo.services.ResidentsService;
import mongodb.demo.mongodemo.models.HousesCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ResidentController {
    @Autowired
    private ResidentsService residentsService;

    @GetMapping("/residents")
    private List<Resident> getAll() {
        return residentsService.getAllResidents();
    }

    @GetMapping("/residents/{id}")
    private Optional<Resident> findOne(@RequestParam String id) {
        return residentsService.getResident(id);
    }

    @GetMapping("/residents/from_ukraine")
    private List<Resident> findResidentsFromUkraine() {
        return residentsService.findResidentsFromUkraine();
    }

    @GetMapping("/residents/count_by_houses")
    private List<HousesCount> findCountResidentsByHouse() {
        return residentsService.getHousesCount();
    }

    @PostMapping("/delete")
    private void deleteAllResidents() {
        residentsService.deleteAllResidents();
    }

    @PostMapping("/delete/{id}")
    private void deleteById(@RequestParam String id) {
        residentsService.deleteResident(id);
    }
}
