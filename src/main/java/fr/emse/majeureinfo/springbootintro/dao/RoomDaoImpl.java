package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoomDaoImpl implements RoomDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Room> findRoomsWithOverTemp() {
        String jpql = "select r from Room r where r.temperature.degree  > :p";
        TypedQuery<Room> query = em.createQuery(jpql, Room.class);
        return query.setParameter("p", 30).getResultList();
    }
}

