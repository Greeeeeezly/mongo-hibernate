package mongodb.demo.mongodemo.models;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class ResidentsFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private static AtomicLong nextEpochDay = new AtomicLong(
            LocalDate.of(2000, 1, 1).toEpochDay());
    private final Faker faker = new Faker();
    public String firstName(){return  faker.name().firstName();}
    public String lastName(){return  faker.name().lastName();}
    public Integer house(){return faker.number().numberBetween(1,6);}
    public Apartment apartment(){return new Apartment(faker.number().numberBetween(1,500),
            faker.number().numberBetween(50,100), faker.number().numberBetween(2,3));}
    public String generateCountry(){
        int randomChoice = faker.random().nextInt(2);
        if (randomChoice == 0) {
            return "Russian Federation";
        } else {
            return "Ukraine";
        }
    }
    public Passport passport(){return new Passport(
            faker.number().numberBetween(1000_000000L, 9999_999999L),check_ined(),generateCountry());}

    public LocalDate check_ined() {
         return faker.date()
                 .past(20*365, TimeUnit.DAYS)
                 .toInstant()
                 .atOffset(ZoneOffset.UTC)
                 .toLocalDate();
    }

public Resident make(UnaryOperator<Resident>...residents) {
    final Resident result = new Resident(check_ined(),firstName(), lastName(),house(),apartment(),passport());
    Stream.of(residents).forEach(v->v.apply(result));
    return result;
}



    public static UnaryOperator<Resident> oneUpId = s->{
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public static UnaryOperator<Resident> nextDate = s->{
        LocalDate ld = LocalDate.ofEpochDay(nextEpochDay.getAndAdd(1L));
        s.setCheck_in(ld);
        return s;
    };

    public ResidentsFactory.ResidentsListDTOFactory listBuilder() { return new ResidentsFactory.ResidentsListDTOFactory(); }


  public class ResidentsListDTOFactory {
      public List<Resident> residents(int min, int max, UnaryOperator<Resident>...residents) {
          return IntStream.range(0, faker.number().numberBetween(min, max))
                  .mapToObj(i-> ResidentsFactory.this.make(residents))
                  .collect(Collectors.toList());
      }
  }
}
