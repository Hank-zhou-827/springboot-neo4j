package com.example.neo4j.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.neo4j.driver.types.Entity;
import org.neo4j.driver.types.Path;

import java.util.*;

/**
 * @author zhoukeqin
 * @date 2022/11/1
 * @description
 */
public class Neo4jUtils {

    public static List<Object> iteratorToList(Iterable<? extends Entity> iterable) {
        List<Object> list = new ArrayList<>();
        iterable.forEach(i -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i.id());
            map.putAll(i.asMap());
            list.add(JSONObject.parseObject(JSON.toJSONString(map)));
        });
        return list;
    }

    public static List<Object> segmentsToList(Iterator<Path.Segment> segments) {
        List<Object> segmentList = new ArrayList<>();
        segments.forEachRemaining(s -> {
            JSONObject jsonObject = new JSONObject();
            Map<String, Object> startMap = new HashMap<>();
            startMap.put("id", s.start().id());
            startMap.putAll(s.start().asMap());
            jsonObject.put("start", JSONObject.parseObject(JSON.toJSONString(startMap)));
            Map<String, Object> endMap = new HashMap<>();
            endMap.put("id", s.end().id());
            endMap.putAll(s.end().asMap());
            jsonObject.put("end", JSONObject.parseObject(JSON.toJSONString(endMap)));
            Map<String, Object> relationshipMap = new HashMap<>();
            relationshipMap.put("id", s.relationship().id());
            relationshipMap.putAll(s.relationship().asMap());
            relationshipMap.put("startNodeId", s.relationship().startNodeId());
            relationshipMap.put("endNodeId", s.relationship().endNodeId());
            jsonObject.put("relationship", JSONObject.parseObject(JSON.toJSONString(relationshipMap)));
            segmentList.add(jsonObject);
        });
        return segmentList;
    }
}
