package fr.emse.majeureinfo.springbootintro.web;


import fr.emse.majeureinfo.springbootintro.dao.BuildingDao;
import fr.emse.majeureinfo.springbootintro.dao.RoomDao;
import fr.emse.majeureinfo.springbootintro.model.Building;
import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/buildings")
@Transactional
public class BuildingController {

    private final BuildingDao buildingDao;
    private final RoomDao roomDao;

    public BuildingController(BuildingDao buildingDao, RoomDao roomDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
    }

    @GetMapping(value = {"/{buildingId}", "/{buildingId}/context"})
    public BuildingDto get(@PathVariable Long buildingId) {
        Building building = buildingDao.getOne(buildingId);
        return new BuildingDto(building);

    }

    @GetMapping(value = "/{buildingId}/rooms")
    public List<RoomDto> listRooms(@PathVariable Long buildingId) {
        Building building = buildingDao.getOne(buildingId);
        return building.getRoom().stream().map(RoomDto::new).collect(Collectors.toList());
    }
}