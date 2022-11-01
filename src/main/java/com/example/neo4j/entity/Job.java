package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@Node(value = "Job")
public class Job extends BaseEntity {

    // 工作岗位：Java开发、UE开发、场景美术、UI设计、测试、产品经理、会计、出纳、前端开发、人事行政...
    private String name;
}
