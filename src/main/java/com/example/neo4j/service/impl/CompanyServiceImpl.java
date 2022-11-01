package com.example.neo4j.service.impl;

import com.example.neo4j.entity.Building;
import com.example.neo4j.entity.Company;
import com.example.neo4j.entity.CompanyRelBuilding;
import com.example.neo4j.repository.BuildingRepository;
import com.example.neo4j.repository.CompanyRelBuildRepostory;
import com.example.neo4j.repository.CompanyRepository;
import com.example.neo4j.service.IBuildingService;
import com.example.neo4j.service.ICompanyRelBuildService;
import com.example.neo4j.service.ICompanyService;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.cypherdsl.core.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Slf4j
@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private IBuildingService buildingService;
    @Autowired
    private ICompanyRelBuildService companyRelBuildService;

    @Override
    public Company createNode(Company company) {
        Building building = new Building();
        building.setName(company.getBuilding());
        Building building1 = buildingService.findOne(building);

        Company company1 = companyRepository.save(company);
        CompanyRelBuilding companyRelBuilding = new CompanyRelBuilding();
        companyRelBuilding.setId(null);
        companyRelBuilding.setCompany(company1);
        companyRelBuilding.setBuilding(building1);
        companyRelBuilding.setRelation("公司办公地点");
        companyRelBuilding.setLabels("公司总部");
        //companyRelBuildService.createNode(companyRelBuilding);
        companyRelBuildService.createRel(companyRelBuilding);
        return company1;
    }

    @Override
    public List<Company> createNodes(List<Company> list) {
        return companyRepository.saveAll(list);
    }

    @Override
    public Company findOne(Company company) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIgnorePaths("focus");
        Example<Company> example = Example.of(company, matcher);
        Optional<Company> optional = companyRepository.findOne(example);
        return optional.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        companyRepository.deleteAll();
    }
}
