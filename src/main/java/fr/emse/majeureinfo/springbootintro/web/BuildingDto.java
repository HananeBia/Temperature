package fr.emse.majeureinfo.springbootintro.web;

import fr.emse.majeureinfo.springbootintro.model.Building;

import java.util.List;
import java.util.stream.Collectors;

public class BuildingDto {
    private final Long id;
    private final List<RoomDto> room;

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.room = building.getRoom() == null ? null: building.getRoom().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public List<RoomDto> getRoom() {
        return room;
    }
}
