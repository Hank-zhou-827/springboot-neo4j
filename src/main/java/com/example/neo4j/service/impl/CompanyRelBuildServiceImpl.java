package com.example.neo4j.service.impl;

import com.example.neo4j.entity.Building;
import com.example.neo4j.entity.Company;
import com.example.neo4j.entity.CompanyRelBuilding;
import com.example.neo4j.repository.CompanyRelBuildRepostory;
import com.example.neo4j.service.IBuildingService;
import com.example.neo4j.service.ICompanyRelBuildService;
import com.example.neo4j.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhoukeqin
 * @date 2022/10/31
 * @description
 */
@Service
public class CompanyRelBuildServiceImpl implements ICompanyRelBuildService {

    @Autowired
    private CompanyRelBuildRepostory companyRelBuildRepostory;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IBuildingService buildingService;

    @Override
    public CompanyRelBuilding createNode(CompanyRelBuilding companyRelBuilding) {
        return companyRelBuildRepostory.save(companyRelBuilding);
    }

    @Override
    public List<CompanyRelBuilding> createNodes(List<CompanyRelBuilding> list) {
        return companyRelBuildRepostory.saveAll(list);
    }

    @Override
    public CompanyRelBuilding findOne(CompanyRelBuilding companyRelBuilding) {
        return null;
    }

    @Override
    public boolean createRel(CompanyRelBuilding companyRelBuilding) {
        //所有节点都是新建
        /*Company company = new Company();
        company.setName(companyRelBuilding.getCompany().getName());
        Building building = new Building();
        building.setName(companyRelBuilding.getBuilding().getName());
        companyRelBuilding.setCompany(company);
        companyRelBuilding.setBuilding(building);
        createNode(companyRelBuilding);*/
        // 给已建立的节点建立关系
        companyRelBuildRepostory.createCompanyRelBuild(companyRelBuilding.getCompany().getName(),
                companyRelBuilding.getBuilding().getName(),
                companyRelBuilding.getRelation());
        return true;
    }

    @Override
    public void deleteAll() {
        companyRelBuildRepostory.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        companyRelBuildRepostory.deleteById(id);
    }
}
