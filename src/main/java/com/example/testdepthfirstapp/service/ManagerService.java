package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.manager.CreateManagerBean;
import com.example.testdepthfirstapp.domain.Employee;
import com.example.testdepthfirstapp.domain.Manager;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.EmployeeRepositoryService;
import com.example.testdepthfirstapp.repository.impl.ManagerRepositoryService;
import com.example.testdepthfirstapp.service.json.ManagerJson;
import com.example.testdepthfirstapp.utils.DateUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService extends ManagerJson {

    @Autowired
    private ManagerRepositoryService managerRepositoryService;

    @Autowired
    private EmployeeRepositoryService employeeRepositoryService;

    @Transactional
    public ObjectNode createManager(CreateManagerBean body) {

        Manager manager = new Manager();
        manager.setName(body.getName());

        try {
            manager = managerRepositoryService.save(manager);
            return createManagerJson(manager);
        } catch (DataFormatException e) {
            throw new DataFormatException("create manager fail.");
        }
    }

    @Transactional
    public ObjectNode getManagers() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<Manager> managerList = new ArrayList<>();
        try {
            managerList = managerRepositoryService.findAll();

            for (Manager manager : managerList) {
                ObjectNode managerNode = new ObjectNode(JsonNodeFactory.instance);

                ArrayNode arrNode = new ArrayNode(JsonNodeFactory.instance);

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
                        arrNode.add(empNode);
                    }
                }
                managerNode.put("id", manager.getId());
                managerNode.put("name", manager.getName());
                managerNode.set("employees", arrNode);

                arrayNode.add(managerNode);
            }
            objectNode.set("manager", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get manager fail.");
        }
    }

    @Transactional
    public ObjectNode getEmployeeByManager(Long manager_id) {

        Manager manager = managerRepositoryService.find(manager_id);
        List<Employee> employeeList = employeeRepositoryService.findEmployeeByManager(manager);

        try {
            ObjectNode managerNode = new ObjectNode(JsonNodeFactory.instance);

            ArrayNode arrNode = new ArrayNode(JsonNodeFactory.instance);

            if(employeeList != null){
                for(Employee employee : employeeList){
                    ObjectNode empNode = new ObjectNode(JsonNodeFactory.instance);
                    empNode.put("id", employee.getId());
                    empNode.put("employee_code", employee.getEmployee_code());
                    empNode.put("first_name", employee.getFirstName());
                    empNode.put("surname", employee.getSurname());
                    empNode.put("telephone", employee.getTelephone());
                    empNode.put("status", employee.getStatusEmployee().getStatus());
                    empNode.put("department_title", employee.getDepartment().getDepartmentTitle());
                    empNode.put("job_level", employee.getJobLevel().getJobTitle());
                    arrNode.add(empNode);
                }
            }
            managerNode.put("id", manager.getId());
            managerNode.put("name", manager.getName());
            managerNode.set("employees", arrNode);

            return managerNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get employee by manager fail.");
        }
    }
}
