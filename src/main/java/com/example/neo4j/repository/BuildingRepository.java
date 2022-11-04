package com.example.neo4j.repository;

import com.example.neo4j.entity.Building;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Repository
public interface BuildingRepository extends Neo4jRepository<Building, Long> {

    /**
     * 查询某建筑的所有关联关系和关联节点（*..25挖掘25个关系点）
     * @param name
     * @return
     */
    @Query("MATCH r=(Building{name: $name})-[*..25]-() RETURN r")
    List<Optional<Object>> findRelationship(String name);
}
