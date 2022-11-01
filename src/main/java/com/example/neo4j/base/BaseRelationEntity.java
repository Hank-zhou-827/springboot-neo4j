package com.example.neo4j.base;

import lombok.Data;

import java.util.List;

/**
 * @author zhoukeqin
 * @date 2022/10/31
 * @description
 */
@Data
public class BaseRelationEntity {

    private List<Object> nodes;
    private List<Object> relationships;
    private List<Object> segments;
}
