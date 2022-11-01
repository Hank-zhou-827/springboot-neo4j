package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@Node(value = "Trade")
public class Trade extends BaseEntity {

    // 行业：餐饮、旅游、金融、工业、IT、软件工程等
    private String name;
}
