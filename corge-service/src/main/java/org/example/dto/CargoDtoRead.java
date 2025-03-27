package org.example.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.entity.CargoStatus;
import org.example.entity.UnitOfWeight;

import java.util.Date;

public class CargoDtoRead extends CargoDtoCreate{
    @NotNull
    @NotEmpty
    @Size(min = 9, max = 9)
    private String registrationNumber;

    private CargoStatus cargoStatus;

    private Date timestampOfRegistration;

    public CargoDtoRead(){
        super();
    }

    public CargoDtoRead(String cargoName,
                        double weight,
                        UnitOfWeight unitOfWeight,
                        String pathIdentifier,
                        String registrationNumber,
                        CargoStatus cargoStatus,
                        Date timestampOfRegistration) {
        super(cargoName, weight, unitOfWeight, pathIdentifier);
        this.cargoStatus = cargoStatus;
        this.registrationNumber = registrationNumber;
        this.timestampOfRegistration = timestampOfRegistration;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public CargoStatus getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(CargoStatus cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public Date getTimestampOfRegistration() {
        return timestampOfRegistration;
    }

    public void setTimestampOfRegistration(Date timestampOfRegistration) {
        this.timestampOfRegistration = timestampOfRegistration;
    }
}
