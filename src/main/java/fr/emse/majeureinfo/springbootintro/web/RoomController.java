package fr.emse.majeureinfo.springbootintro.web;


import fr.emse.majeureinfo.springbootintro.dao.RoomDao;
import fr.emse.majeureinfo.springbootintro.model.Room;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/rooms")
@Transactional
public class RoomController {

    private final RoomDao roomDao;

    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @GetMapping
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @GetMapping(value = {"/{roomId}", "/{roomId}/context"})
    public RoomDto get(@PathVariable Long roomId) {
        Room room = roomDao.getOne(roomId);
        return new RoomDto(room);

    }

    @PostMapping(value = "/{id}/delete")
    public void delete(@PathVariable("id") Long id){
        roomDao.delete(id);
    }

    @PostMapping(value = "/new")
    public RoomDto newRoom(@RequestBody Room room){
        roomDao.save(room);
        return new RoomDto(room);
    }
}