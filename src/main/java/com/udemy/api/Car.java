package com.udemy.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "people")
@NamedQueries(
        {
                @NamedQuery(
                        name = "com.example.helloworld.core.Person.findAll",
                        query = "SELECT p FROM Person p"
                )
        })
public class Car {

   // @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private long id;

    @Column(name = "carId", nullable = false)
    private long carId;

    @Column(name = "licensePlate", nullable = false)
    private String licensePlate;

    public Car(){
    }

    public Car( long carId, String licensePlate ){
        super();
        this.carId = carId;
        this.licensePlate=licensePlate;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
