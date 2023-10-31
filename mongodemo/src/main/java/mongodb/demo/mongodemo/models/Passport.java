package mongodb.demo.mongodemo.models;

import java.time.LocalDate;
import java.util.Date;

public class Passport {
    private Long serial_number;
    private LocalDate date_of_receipt;
    private String country;

    public Passport(Long serial_number, LocalDate date_of_receipt, String country) {
        this.serial_number = serial_number;
        this.date_of_receipt = date_of_receipt;
        this.country = country;
    }

    public Long getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(Long serial_number) {
        this.serial_number = serial_number;
    }

    public LocalDate getDate_of_receipt() {
        return date_of_receipt;
    }

    public void setDate_of_receipt(LocalDate date_of_receipt) {
        this.date_of_receipt = date_of_receipt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
