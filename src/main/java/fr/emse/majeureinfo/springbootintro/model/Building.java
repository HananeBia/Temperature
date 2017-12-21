
package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;
import java.util.List;

@Entity

public class Building {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The Rooms of a Building
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> room;


    @SuppressWarnings("unused")
    public Building() {
    }

    public Building(List<Room> room) {
        this.room = room ;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRoom() { return room;}

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}

