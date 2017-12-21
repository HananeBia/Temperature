package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Room;
import fr.emse.majeureinfo.springbootintro.model.Temperature;

public class RoomDto {
    private final Long id;
    private final String name;
    private final TemperatureDto temperature;


    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.temperature = room.getTemperature() == null ? null: new TemperatureDto(room.getTemperature());

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TemperatureDto getTemperature() {
        return temperature;
    }
}
