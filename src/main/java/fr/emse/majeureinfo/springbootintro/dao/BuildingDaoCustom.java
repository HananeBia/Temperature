package fr.emse.majeureinfo.springbootintro.dao;

import fr.emse.majeureinfo.springbootintro.web.BuildingOverTempDto;

import java.util.List;

public interface BuildingDaoCustom {

    List<BuildingOverTempDto> findBuildingOverTemp();

}