package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.Employee;
import com.example.testdepthfirstapp.domain.Manager;
import com.example.testdepthfirstapp.utils.Utility;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ManagerJson {
    public ObjectNode createManagerJson(Manager manager) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);

        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);

        if(manager.getEmployeeList() != null){
            for(Employee employee : manager.getEmployeeList()){
                ObjectNode empNode = new ObjectNode(JsonNodeFactory.instance);
                empNode.put("id", employee.getId());
                empNode.put("employee_code", employee.getEmployee_code());
                empNode.put("first_name", employee.getFirstName());
                empNode.put("surname", employee.getSurname());
                empNode.put("telephone", employee.getTelephone());
                empNode.put("status", employee.getStatusEmployee().getStatus());
                empNode.put("department_title", employee.getDepartment().getDepartmentTitle());
                empNode.put("job_level", employee.getJobLevel().getJobTitle());
                arrayNode.add(empNode);
            }
        }

        jsonNodes.put("id", manager.getId());
        jsonNodes.put("name", manager.getName());
        jsonNodes.set("employees", arrayNode);
        return jsonNodes;
    }
}
