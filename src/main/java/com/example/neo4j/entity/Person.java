package com.example.neo4j.entity;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Data
@Node(value = "Person")
public class Person extends BaseEntity {

    // 姓名
    private String name;
    // 性别
    private String sex;
    // 身份证
    private String IDCard;
    // 工作单位
    private String company;
    // 工作岗位
    private String job;
    // 住址
    private String address;
    // 籍贯
    private String nativePlace;
    // 手机号码
    private String mobile;
}
