package com.example.neo4j.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.neo4j.entity.Building;
import com.example.neo4j.repository.BuildingRepository;
import com.example.neo4j.service.IBuildingService;
import com.example.neo4j.util.Neo4jUtils;
import lombok.extern.slf4j.Slf4j;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Path;
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
public class BuildingServiceImpl implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public Building createNode(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public List<Building> createNodes(List<Building> list) {
        return buildingRepository.saveAll(list);
    }

    @Override
    public Building findOne(Building building) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIgnorePaths("focus");
        Example<Building> example = Example.of(building, matcher);
        Optional<Building> optional = buildingRepository.findOne(example);
        return optional.orElse(null);
    }

    @Override
    public Object findRelationship(String name) {
        Optional<Object> optional = buildingRepository.findRelationship(name);
        PathValue pathValue = (PathValue) optional.orElse(null);
        Path path = pathValue.asPath();
        List<Object> nodeList = Neo4jUtils.iteratorToList(path.nodes());
        List<Object> relationshipList = Neo4jUtils.iteratorToList(path.relationships());
        List<Object> segmentList = Neo4jUtils.segmentsToList(path.iterator());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nodes", nodeList);
        jsonObject.put("relationships", relationshipList);
        jsonObject.put("segments", segmentList);
        return jsonObject;
    }

    @Override
    public void deleteById(Long id) {
        buildingRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        buildingRepository.deleteAll();
    }


}
