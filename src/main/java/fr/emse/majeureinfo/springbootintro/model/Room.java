
package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;

@Entity

public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * The Temperature of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Temperature temperature;


    @SuppressWarnings("unused")
    public Room() {
    }

    public Room(String name,Temperature temperature) {
        this.temperature = temperature;
        this.name = name;

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
