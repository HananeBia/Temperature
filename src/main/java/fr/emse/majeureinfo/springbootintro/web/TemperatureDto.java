package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Temperature;

public class TemperatureDto {
    private final Long id;
    private final Integer degree;


    public TemperatureDto(Temperature temperature) {
        this.id = temperature.getId();
        this.degree = temperature.getDegree();
    }

    public Long getId() {
        return id;
    }

    public Integer getDegree() {
        return degree;
    }

}
