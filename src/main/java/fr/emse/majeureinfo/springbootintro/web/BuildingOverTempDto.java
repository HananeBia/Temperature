package fr.emse.majeureinfo.springbootintro.web;

public class BuildingOverTempDto {

    private final Long id;
    private final int nb_room;


    public BuildingOverTempDto(Long id, Long nb_room) {
        this.id = id;
        this.nb_room = nb_room.intValue();
    }

    public Long getId() {
        return id;
    }
    public int getNbRoom() {
        return nb_room;
    }


}
