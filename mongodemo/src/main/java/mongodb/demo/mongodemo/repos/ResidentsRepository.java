package mongodb.demo.mongodemo.repos;

import mongodb.demo.mongodemo.models.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResidentsRepository extends MongoRepository<Resident, String> {
    @Query("{'passport.country': 'Ukraine'}")
    List<Resident> findResidentsFromUkraine();
}
