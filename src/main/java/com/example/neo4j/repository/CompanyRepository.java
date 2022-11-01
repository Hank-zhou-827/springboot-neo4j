package com.example.neo4j.repository;

import com.example.neo4j.entity.Company;
import com.example.neo4j.entity.CompanyRelBuilding;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Repository
public interface CompanyRepository extends Neo4jRepository<Company, Long> {

}
