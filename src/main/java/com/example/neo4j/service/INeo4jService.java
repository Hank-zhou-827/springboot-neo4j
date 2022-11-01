package com.example.neo4j.service;

import java.util.List;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
public interface INeo4jService<T> {

    T createNode(T t);

    List<T> createNodes(List<T> list);

    T findOne(T t);

    void deleteById(Long id);

    void deleteAll();
}
