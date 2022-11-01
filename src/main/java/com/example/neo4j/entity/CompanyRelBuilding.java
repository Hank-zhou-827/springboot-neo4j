package com.example.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@RelationshipEntity(type = "CompanyRelBuilding")
public class CompanyRelBuilding extends BaseEntity {

    @StartNode
    private Company company;
    @EndNode
    private Building building;
    @Property
    private String relation;
    @Labels
    private String labels;
}
