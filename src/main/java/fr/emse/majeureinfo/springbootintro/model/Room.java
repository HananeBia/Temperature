package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;

@Entity
public class Room {

   @Id
   @GeneratedValue
   private Long id;
    /**
     * The Light of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Light light;

    /**
     * The Noise of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Noise noise;

    public Room(Light light, Noise noise) {
        this.light=light;
        this.noise=noise;



    }


    public long getId() { return this.id; }
    public void setId(Long id) {
        this.id = id;
    }


    public Light getLevel() {
        return light;
    }
    public void setLight(Light light) {
        this.light = light;
    }


    public Noise getStatus() {
        return noise;
    }
    public void setNoise(Noise noise) {
        this.noise = noise;
    }
}
