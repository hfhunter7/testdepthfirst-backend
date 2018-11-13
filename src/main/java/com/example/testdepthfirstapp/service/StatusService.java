package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.status_employee.CreateStatusEmployeeBean;
import com.example.testdepthfirstapp.bean.status_prettycash.CreateStatusPrettyCash;
import com.example.testdepthfirstapp.domain.StatusEmployee;
import com.example.testdepthfirstapp.domain.StatusPrettyCash;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.StatusEmployeeRepositoryService;
import com.example.testdepthfirstapp.repository.impl.StatusPrettyCashRepositoryService;
import com.example.testdepthfirstapp.service.json.StatusJson;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService extends StatusJson {
    @Autowired
    private StatusEmployeeRepositoryService statusEmployeeRepositoryService;

    @Autowired
    private StatusPrettyCashRepositoryService statusPrettyCashRepositoryService;

    @Transactional
    public ObjectNode createStatusEmployee(CreateStatusEmployeeBean body) {
        StatusEmployee statusEmployee = new StatusEmployee();
        statusEmployee.setStatus(body.getStatus());
        try {
            statusEmployee = statusEmployeeRepositoryService.save(statusEmployee);
            return createStatusEmployeeJson(statusEmployee);
        } catch (DataFormatException e) {
            throw new DataFormatException("create status employee fail.");
        }
    }

    @Transactional
    public ObjectNode getStatusEmployees() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<StatusEmployee> statusEmployeeList = new ArrayList<>();
        try {
            statusEmployeeList = statusEmployeeRepositoryService.findAll();

            for(StatusEmployee s : statusEmployeeList){
                ObjectNode statusEmpNode = new ObjectNode(JsonNodeFactory.instance);
                statusEmpNode.put("id",s.getId());
                statusEmpNode.put("status",s.getStatus());
                arrayNode.add(statusEmpNode);
            }
            objectNode.set("statusEmp",arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get status employee fail.");
        }
    }

    /////////////////////////////// Status Pretty Cash //////////////////////////////////////

    @Transactional
    public ObjectNode createStatusPrettyCash(CreateStatusPrettyCash body) {
        StatusPrettyCash statusPrettyCash = new StatusPrettyCash();
        statusPrettyCash.setStatus(body.getStatus());
        try {
            statusPrettyCash = statusPrettyCashRepositoryService.save(statusPrettyCash);
            return createStatusPrettyCashJson(statusPrettyCash);
        } catch (DataFormatException e) {
            throw new DataFormatException("create status pretty cash fail.");
        }
    }

    @Transactional
    public ObjectNode getStatusPrettyCash() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<StatusPrettyCash> statusPrettyCashList = new ArrayList<>();
        try {
            statusPrettyCashList = statusPrettyCashRepositoryService.findAll();

            for(StatusPrettyCash s : statusPrettyCashList){
                ObjectNode statusEmpNode = new ObjectNode(JsonNodeFactory.instance);
                statusEmpNode.put("id",s.getId());
                statusEmpNode.put("status",s.getStatus());
                arrayNode.add(statusEmpNode);
            }
            objectNode.set("statusPrettyCash",arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get status pretty cash fail.");
        }
    }
}
