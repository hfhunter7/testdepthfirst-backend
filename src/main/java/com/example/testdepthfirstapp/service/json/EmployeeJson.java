package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.Employee;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EmployeeJson {
    public ObjectNode createEmployeeJson(Employee employee) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        ObjectNode mngNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", employee.getId());
        jsonNodes.put("employee_code", employee.getEmployee_code());
        jsonNodes.put("first_name", employee.getFirstName());
        jsonNodes.put("surname", employee.getSurname());
        jsonNodes.put("telephone", employee.getTelephone());
        jsonNodes.put("status", employee.getStatusEmployee().getStatus());
        jsonNodes.put("department_title", employee.getDepartment().getDepartmentTitle());
        jsonNodes.put("job_level", employee.getJobLevel().getJobTitle());

        mngNodes.put("id",employee.getManager().getId());
        mngNodes.put("name",employee.getManager().getName());

        jsonNodes.set("manager", mngNodes);
        return jsonNodes;
    }
}
