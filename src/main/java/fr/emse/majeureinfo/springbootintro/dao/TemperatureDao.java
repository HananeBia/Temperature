package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureDao extends JpaRepository <Temperature, Long> , TemperatureDaoCustom {
}


