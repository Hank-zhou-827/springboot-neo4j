package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@Node(value = "JobType")
public class JobType extends BaseEntity {

    // 岗位类型：人力资源、开发、测试、设计、财务、产品、运维、运营...
    private String name;
}
