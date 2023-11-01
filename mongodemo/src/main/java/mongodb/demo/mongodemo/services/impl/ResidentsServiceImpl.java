package mongodb.demo.mongodemo.services.impl;

import mongodb.demo.mongodemo.models.HousesCount;
import mongodb.demo.mongodemo.models.Resident;
import mongodb.demo.mongodemo.repos.ResidentsRepository;
import mongodb.demo.mongodemo.services.ResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentsServiceImpl implements ResidentsService {
    @Autowired
    private ResidentsRepository residentsRepo;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<HousesCount> getHousesCount() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("house").count().as("count"),
                Aggregation.project("count").and("_id").as("house")
        );

        AggregationResults<HousesCount> results = mongoTemplate.aggregate(aggregation, "houses", HousesCount.class);
        return results.getMappedResults();
    }


    @Override
    public Resident createResident(Resident resident) {
        return residentsRepo.save(resident);
    }

    @Override
    public Optional<Resident> getResident(String id) {
        return residentsRepo.findById(id);
    }

    @Override
    public void deleteResident(String id) {
        residentsRepo.deleteById(id);
    }

    @Override
    public void deleteAllResidents() {
        residentsRepo.deleteAll();
    }

    @Override
    public void saveAllResidents(List<Resident> residents) {
        residentsRepo.saveAll(residents);
    }

    @Override
    public List<Resident> getAllResidents() {
        return residentsRepo.findAll();
    }

    @Override
    public List<Resident> findResidentsFromUkraine() {
        return residentsRepo.findResidentsFromUkraine();
    }



   /* @Override
    public Page<Resident> getResidents(Pageable pageable) {
        residentsRepo.
    }*/

   /* @Override
    public Page<Resident> getResidents(Pageable pageable) {
        return null;
    }

    @Override
    public List<Resident> getAllResidents() {
        return null;
    }

    @Override
    public Page<Resident> findCheck_inedAfter(LocalDate exclusive, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Resident> findResidentsMatchingAll(Resident probe, Pageable pageable) {
        return null;
    }*/
}
