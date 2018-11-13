package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.Department;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DepartmentJson {
    public ObjectNode createDepartmentJson(Department department) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", department.getId());
        jsonNodes.put("department_title", department.getDepartmentTitle());
        return jsonNodes;
    }
}
