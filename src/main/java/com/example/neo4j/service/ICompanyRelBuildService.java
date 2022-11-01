package com.example.neo4j.service;

import com.example.neo4j.entity.CompanyRelBuilding;

/**
 * @author zhoukeqin
 * @date 2022/10/31
 * @description
 */
public interface ICompanyRelBuildService extends INeo4jService<CompanyRelBuilding> {

    boolean createRel(CompanyRelBuilding companyRelBuilding);
}
