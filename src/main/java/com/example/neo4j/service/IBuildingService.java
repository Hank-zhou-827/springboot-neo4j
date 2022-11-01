package com.example.neo4j.service;

import com.example.neo4j.entity.Building;

import java.util.Optional;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
public interface IBuildingService extends INeo4jService<Building> {

    Object findRelationship(String name);
}
