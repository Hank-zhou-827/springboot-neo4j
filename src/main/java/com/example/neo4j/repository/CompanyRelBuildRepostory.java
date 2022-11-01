package com.example.neo4j.repository;

import com.example.neo4j.entity.CompanyRelBuilding;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhoukeqin
 * @date 2022/10/31
 * @description
 */
@Repository
public interface CompanyRelBuildRepostory extends Neo4jRepository<CompanyRelBuilding, Long> {

    @Query("MATCH (a:Company{name:$from})" +
            "MATCH (b:Building{name:$to}) " +
            "CREATE (a) - [r:公司地址{relation:$relation}] -> (b)")
    void createCompanyRelBuild(String from, String to, String relation);
}
