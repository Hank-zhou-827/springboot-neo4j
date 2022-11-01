package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@Node(value = "Building")
public class Building extends BaseEntity {

    // 楼栋名称
    private String name;
    // 所在省
    private String province;
    // 所在市
    private String city;
    // 所在行政区/县
    private String county;
    // 所在街道
    private String street;
    // 详细地址
    private String address;
    // 修建时间
    private String buildTime;
    // 楼栋性质：民用、商用
    private String nature;
}
