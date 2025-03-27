package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cargo_id_gen")
    @SequenceGenerator(name = "cargo_id_gen", sequenceName = "cargo_id_seq")
    private Long id;

    @Column(name = "cargo_name")
    private String cargoName;  //0

    @Column(name = "reg_number", unique = true)
    private String registrationNumber; //1

    @Column(name = "weight")
    private double weight; //2

    @Column(name = "unit_of_weight")
    private String unitOfWeight; //3

    @Column(name = "status")
    private CargoStatus cargoStatus;

    @Column(name = "path")
    private String pathIdentifier; //4

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampOfRegistration;

    @OneToMany(mappedBy = "cargo", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Cargo(){}

    public Cargo(String cargoName, String registrationNumber, double weight, String unitOfWeight, String pathIdentifier) {
        this.cargoName = cargoName;
        this.registrationNumber = registrationNumber;
        this.weight = weight;
        this.unitOfWeight = unitOfWeight;
        this.pathIdentifier = pathIdentifier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getUnitOfWeight() {
        return unitOfWeight;
    }

    public void setUnitOfWeight(String unitOfWeight) {
        this.unitOfWeight = unitOfWeight;
    }

    public CargoStatus getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(CargoStatus cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public String getPathIdentifier() {
        return pathIdentifier;
    }

    public void setPathIdentifier(String pathIdentifier) {
        this.pathIdentifier = pathIdentifier;
    }

    public Date getTimestampOfRegistration() {
        return timestampOfRegistration;
    }

    public void setTimestampOfRegistration(Date timestampOfRegistration) {
        this.timestampOfRegistration = timestampOfRegistration;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
