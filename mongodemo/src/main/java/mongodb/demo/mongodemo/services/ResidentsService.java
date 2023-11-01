package mongodb.demo.mongodemo.services;

import mongodb.demo.mongodemo.models.Resident;
import mongodb.demo.mongodemo.models.HousesCount;

import java.util.List;
import java.util.Optional;

public interface ResidentsService {
    List<HousesCount> getHousesCount();
    Resident createResident(Resident resident);
    Optional<Resident> getResident(String id);
    void deleteResident(String id);
    void deleteAllResidents();
    void saveAllResidents(List<Resident> residents);
    //Page<Resident> getResidents(Pageable pageable);/*
    List<Resident> getAllResidents();
    public List<Resident> findResidentsFromUkraine();
   // Page<Resident> findCheck_inedAfter(LocalDate exclusive, Pageable pageable);
   // Page<Resident> findResidentsMatchingAll(Resident probe, Pageable pageable);*/
}
