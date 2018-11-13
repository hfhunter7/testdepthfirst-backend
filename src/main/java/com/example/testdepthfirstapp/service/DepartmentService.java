package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.department.CreateDepartmentBean;
import com.example.testdepthfirstapp.domain.Department;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.DepartmentRepositoryService;
import com.example.testdepthfirstapp.service.json.DepartmentJson;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService extends DepartmentJson {
    @Autowired
    private DepartmentRepositoryService departmentRepositoryService;

    @Transactional
    public ObjectNode createDepartment(CreateDepartmentBean body) {
        Department department = new Department();
        department.setDepartmentTitle(body.getDepartment_title());
        try {
            department = departmentRepositoryService.save(department);
            return createDepartmentJson(department);
        } catch (DataFormatException e) {
            throw new DataFormatException("create department fail.");
        }
    }

    @Transactional
    public ObjectNode getDepartments() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<Department> departmentList = new ArrayList<>();
        try {
            departmentList = departmentRepositoryService.findAll();

            for(Department d : departmentList){
                ObjectNode departmentNode = new ObjectNode(JsonNodeFactory.instance);
                departmentNode.put("id",d.getId());
                departmentNode.put("department_title",d.getDepartmentTitle());
                arrayNode.add(departmentNode);
            }
            objectNode.set("departments",arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get department fail.");
        }
    }
}
