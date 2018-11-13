package com.example.testdepthfirstapp.controller;

import com.example.testdepthfirstapp.bean.employee.CreateEmployeeBean;
import com.example.testdepthfirstapp.exception.ResourceNotFoundException;
import com.example.testdepthfirstapp.service.EmployeeService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

@RestController
@RequestMapping(value = "/v1/employee")
@Api(value = "employee", description = "Employee API")
public class EmployeeController extends AbstractRestHandler implements Serializable {

    private static final long serialVersionUID = -266297739488816116L;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create employee", notes = "create employee")
    public @ResponseBody
    ResponseEntity<?> createEmployee(
            @RequestBody CreateEmployeeBean body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = employeeService.createEmployee(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get employees", notes = "get employees")
    public @ResponseBody
    ResponseEntity<?> getEmployees(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = employeeService.getEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/general", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get employees", notes = "get employees")
    public @ResponseBody
    ResponseEntity<?> getGeneralEmployees(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = employeeService.getGeneralEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/finance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get employees", notes = "get employees")
    public @ResponseBody
    ResponseEntity<?> getFinanceEmployees(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = employeeService.getFinanceEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
