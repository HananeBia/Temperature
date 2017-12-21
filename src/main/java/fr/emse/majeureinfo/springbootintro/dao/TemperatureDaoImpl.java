package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Temperature;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class TemperatureDaoImpl implements TemperatureDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Temperature> findOverTemp() {
        String jpql = "select tp from Temperature tp where tp.degree  > :p";
        TypedQuery<Temperature> query = em.createQuery(jpql, Temperature.class);
        return query.setParameter("p", 30).getResultList();
    }
}
