package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Light;
import fr.emse.majeureinfo.springbootintro.model.Noise;
import fr.emse.majeureinfo.springbootintro.model.Room;

public class RoomDto {
    private final Long id;
    private final fr.emse.majeureinfo.springbootintro.model.Light Light;
    private final fr.emse.majeureinfo.springbootintro.model.Noise Noise;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.Light = room.getLevel();
        this.Noise = room.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Light getLevel() {
        return Light;
    }

    public Noise getStatus() {
        return Noise;
    }



}

