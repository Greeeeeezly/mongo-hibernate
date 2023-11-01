package mongodb.demo.mongodemo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "houses")
public class Resident {
    @Id
    private String id;
    private LocalDate check_in;
    private String firstName;
    private String lastName;
    private Integer house;
    private List<Apartment> apartment;

    private Passport passport;


    public Resident() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCheck_in() {
        return check_in;
    }

    public void setCheck_in(LocalDate check_in) {
        this.check_in = check_in;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Resident(LocalDate check_in, String firstName, String lastName, Integer house, List<Apartment> apartment, Passport passport) {
        this.check_in = check_in;
        this.firstName = firstName;
        this.lastName = lastName;
        this.house = house;
        this.apartment = apartment;
        this.passport = passport;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public List<Apartment> getApartment() {
        return apartment;
    }

    public void setApartment(List<Apartment> apartment) {
        this.apartment = apartment;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id='" + id + '\'' +
                ", check_in=" + check_in +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }
}
