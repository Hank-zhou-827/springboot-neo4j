package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@Node(value = "Company")
public class Company extends BaseEntity {

    // 企业名称
    private String name;
    // 企业代码
    private String code;
    // 企业法人
    private String legalPerson;
    // 联系人
    private String liaisonPerson;
    // 联系电话
    private String tel;
    // 注册地址
    private String registerAddress;
    // 注册时间
    private String registerTime;
    // 公司所在省
    private String province;
    // 公司所在市
    private String city;
    // 公司所在行政区/县
    private String county;
    // 公司所在街道
    private String street;
    // 公司所在楼栋
    private String building;
}
