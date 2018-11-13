package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.employee.CreateEmployeeBean;
import com.example.testdepthfirstapp.domain.*;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.*;
import com.example.testdepthfirstapp.service.json.EmployeeJson;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService extends EmployeeJson {

    @Autowired
    private DepartmentRepositoryService departmentRepositoryService;

    @Autowired
    private StatusEmployeeRepositoryService statusEmployeeRepositoryService;

    @Autowired
    private JobLevelRepositoryService jobLevelRepositoryService;

    @Autowired
    private EmployeeRepositoryService employeeRepositoryService;

    @Autowired
    private ManagerRepositoryService managerRepositoryService;

    @Transactional
    public ObjectNode createEmployee(CreateEmployeeBean body) {
        Department department = departmentRepositoryService.find(body.getDepartment_id());
        JobLevel jobLevel = jobLevelRepositoryService.find(body.getJob_level());
        StatusEmployee statusEmployee = statusEmployeeRepositoryService.find(body.getStatus_id());
        List<Employee> employeeList = employeeRepositoryService.findAll();
        Manager manager = managerRepositoryService.find(body.getManager_id());

        Employee employee = new Employee();
        employee.setEmployee_code("DF" + (employeeList.size() + 1));
        employee.setFirstName(body.getFirst_name());
        employee.setSurname(body.getSurname());
        employee.setTelephone(body.getTelephone());
        employee.setDepartment(department);
        employee.setJobLevel(jobLevel);
        employee.setStatusEmployee(statusEmployee);
        employee.setManager(manager);
        try {
            employee = employeeRepositoryService.save(employee);
            return createEmployeeJson(employee);
        } catch (DataFormatException e) {
            throw new DataFormatException("create employee fail.");
        }
    }

    @Transactional
    public ObjectNode getEmployees() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeRepositoryService.findAll();

            for (Employee employee : employeeList) {
                ObjectNode empNode = new ObjectNode(JsonNodeFactory.instance);
                ObjectNode mngNodes = new ObjectNode(JsonNodeFactory.instance);

                empNode.put("id", employee.getId());
                empNode.put("employee_code", employee.getEmployee_code());
                empNode.put("first_name", employee.getFirstName());
                empNode.put("surname", employee.getSurname());
                empNode.put("telephone", employee.getTelephone());
                empNode.put("status", employee.getStatusEmployee().getStatus());
                empNode.put("department_title", employee.getDepartment().getDepartmentTitle());
                empNode.put("job_level", employee.getJobLevel().getJobTitle());

                mngNodes.put("id",employee.getManager().getId());
                mngNodes.put("name",employee.getManager().getName());
                empNode.set("manager" , mngNodes);

                arrayNode.add(empNode);
            }
            objectNode.set("all_employees", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get employee fail.");
        }
    }

    @Transactional
    public ObjectNode getGeneralEmployees() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);

        Department department = departmentRepositoryService.find(Long.valueOf(2));

        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeRepositoryService.findByDepartment(department);

            for (Employee employee : employeeList) {
                ObjectNode empNode = new ObjectNode(JsonNodeFactory.instance);
                ObjectNode mngNodes = new ObjectNode(JsonNodeFactory.instance);

                empNode.put("id", employee.getId());
                empNode.put("employee_code", employee.getEmployee_code());
                empNode.put("first_name", employee.getFirstName());
                empNode.put("surname", employee.getSurname());
                empNode.put("telephone", employee.getTelephone());
                empNode.put("status", employee.getStatusEmployee().getStatus());
                empNode.put("department_title", employee.getDepartment().getDepartmentTitle());
                empNode.put("job_level", employee.getJobLevel().getJobTitle());

                mngNodes.put("id",employee.getManager().getId());
                mngNodes.put("name",employee.getManager().getName());
                empNode.set("manager" , mngNodes);

                arrayNode.add(empNode);
            }
            objectNode.set("general_employees", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get employee fail.");
        }
    }

    @Transactional
    public ObjectNode getFinanceEmployees() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);

        Department department = departmentRepositoryService.find(Long.valueOf(3));

        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeRepositoryService.findByDepartment(department);

            for (Employee employee : employeeList) {
                ObjectNode empNode = new ObjectNode(JsonNodeFactory.instance);
                ObjectNode mngNodes = new ObjectNode(JsonNodeFactory.instance);

                empNode.put("id", employee.getId());
                empNode.put("employee_code", employee.getEmployee_code());
                empNode.put("first_name", employee.getFirstName());
                empNode.put("surname", employee.getSurname());
                empNode.put("telephone", employee.getTelephone());
                empNode.put("status", employee.getStatusEmployee().getStatus());
                empNode.put("department_title", employee.getDepartment().getDepartmentTitle());
                empNode.put("job_level", employee.getJobLevel().getJobTitle());

                mngNodes.put("id",employee.getManager().getId());
                mngNodes.put("name",employee.getManager().getName());
                empNode.set("manager" , mngNodes);

                arrayNode.add(empNode);
            }
            objectNode.set("finance_employees", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get employee fail.");
        }
    }
}
