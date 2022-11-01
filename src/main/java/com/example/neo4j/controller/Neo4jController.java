package com.example.neo4j.controller;

import com.example.neo4j.entity.Building;
import com.example.neo4j.entity.Company;
import com.example.neo4j.entity.CompanyRelBuilding;
import com.example.neo4j.service.IBuildingService;
import com.example.neo4j.service.ICompanyRelBuildService;
import com.example.neo4j.service.ICompanyService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhoukeqin
 * @date 2022/10/29
 * @description
 */
@Api(tags = "Neo4j样例")
@RestController
@RequestMapping("/demo")
public class Neo4jController {

    @Autowired
    private IBuildingService buildingService;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private ICompanyRelBuildService companyRelBuildService;

    @ApiOperation(value = "新建楼栋")
    @PostMapping("/create/building")
    @ApiOperationSupport(order = 1)
    public Object createBuilding(@Validated @RequestBody Building building) {
        return buildingService.createNode(building);
    }

    @GetMapping("/get/{name}")
    @ApiOperation(value = "根据名称查询楼栋")
    @ApiOperationSupport(order = 2)
    public Object findBuilding(@PathVariable String name) {
        Building building = new Building();
        building.setName(name);
        return buildingService.findOne(building);
    }

    @ApiOperation(value = "查询建筑关联节点与关联关系")
    @ApiOperationSupport(order = 3)
    @GetMapping("/building/{name}/getRelationship")
    public Object getBuildRelationship(@PathVariable String name) {
        return buildingService.findRelationship(name);
    }

    @ApiOperation(value = "新建企业")
    @PostMapping("/create/company")
    @ApiOperationSupport(order = 4)
    public Object createCompany(@Validated @RequestBody Company company) {
        return companyService.createNode(company);
    }

    @ApiOperation(value = "新建楼栋与企业关联关系")
    @PostMapping("/create")
    @ApiOperationSupport(order = 5)
    public Object create(@Validated @RequestBody CompanyRelBuilding companyRelBuilding) {
        return companyRelBuildService.createRel(companyRelBuilding);
    }

    @DeleteMapping("/company/deleteAll")
    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "删除企业数据")
    public Boolean deleteAllCompany() {
        companyService.deleteAll();
        return true;
    }

    @DeleteMapping("/building/deleteAll")
    @ApiOperationSupport(order = 7)
    @ApiOperation(value = "删除楼栋数据")
    public Boolean deleteAllBuilding() {
        buildingService.deleteAll();
        return true;
    }

    @DeleteMapping("/companyRelBuild/deleteAll")
    @ApiOperationSupport(order = 8)
    @ApiOperation(value = "删除企业与楼栋关联数据")
    public Boolean deleteAllRel() {
        companyRelBuildService.deleteAll();
        return true;
    }

}
