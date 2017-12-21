package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.model.Temperature;

import java.util.List;

public interface TemperatureDaoCustom {
    List<Temperature> findOverTemp();
}
