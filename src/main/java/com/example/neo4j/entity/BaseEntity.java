package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
public class BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
}
