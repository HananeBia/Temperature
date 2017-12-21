package fr.emse.majeureinfo.springbootintro.dao;



import fr.emse.majeureinfo.springbootintro.web.BuildingOverTempDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BuildingDaoImpl implements BuildingDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<BuildingOverTempDto> findBuildingOverTemp() {
        String jpql = "select new "+
                "   fr.emse.majeureinfo.springbootintro.web.BuildingOverTempDto(" +
                " bd.id , " +
                "count(distinct rooms.id) as nb, " +
                "from Building bd " +
                "inner join bd.room room " +
                "left outer join bd.room roomsWithOverTemp " +
                "left outer join roomsWithOverTemp.temperature temperature " +
                "where temperature.degree > :p " +
                "group by bd.id ";

        List<BuildingOverTempDto> dtos = em.createQuery(jpql, BuildingOverTempDto.class)
                .setParameter("p", 30)
                .getResultList();

        return dtos;
    }
}
