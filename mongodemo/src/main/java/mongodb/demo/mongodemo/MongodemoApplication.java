package mongodb.demo.mongodemo;

import mongodb.demo.mongodemo.models.Resident;
import mongodb.demo.mongodemo.models.ResidentsFactory;
import mongodb.demo.mongodemo.repos.ResidentsRepository;
import mongodb.demo.mongodemo.services.ResidentsService;
import mongodb.demo.mongodemo.models.HousesCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {ResidentsRepository.class}, repositoryImplementationPostfix = "Impl")
public class MongodemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MongodemoApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "mongodb"));
        app.run(args);
    }

    @Component
    public class Init implements CommandLineRunner {
        @Autowired
        ResidentsService residentsService;

        @Autowired
        private ResidentsFactory residentsFactory;

        @Override
        public void run(String... args) throws Exception {
            List<Resident> residents = residentsFactory.listBuilder().residents(100,100);
            residentsService.saveAllResidents(residents);
        }
    }

    @Component
    public class CustomCode implements CommandLineRunner {
        @Autowired
        private ResidentsService residentsService;

        @Override
        public void run(String... args) throws Exception {

            List<HousesCount> housesCountList = residentsService.getHousesCount();
            for (HousesCount housesCount:housesCountList
                 ) {
                System.out.println(housesCount);
            }

        }
    }
}
