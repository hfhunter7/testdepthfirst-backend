package com.example.testdepthfirstapp.controller;

import com.example.testdepthfirstapp.bean.status_employee.CreateStatusEmployeeBean;
import com.example.testdepthfirstapp.bean.status_prettycash.CreateStatusPrettyCash;
import com.example.testdepthfirstapp.exception.ResourceNotFoundException;
import com.example.testdepthfirstapp.service.StatusService;
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
@RequestMapping(value = "/v1/status")
@Api(value = "status", description = "Status API")
public class StatusController extends AbstractRestHandler implements Serializable {

    private static final long serialVersionUID = 1989494354099769087L;

    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/employee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create status employee", notes = "create status employee")
    public @ResponseBody
    ResponseEntity<?> createStatusEmployee(
            @RequestBody CreateStatusEmployeeBean body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = statusService.createStatusEmployee(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get status employee", notes = "get status employee")
    public @ResponseBody
    ResponseEntity<?> getStatusEmployee(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = statusService.getStatusEmployees();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    /////////////////////////////// Status Pretty Cash //////////////////////////////////////

    @RequestMapping(value = "/pretty-cash", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create status pretty cash", notes = "create status pretty cash")
    public @ResponseBody
    ResponseEntity<?> createStatusPrettyCash(
            @RequestBody CreateStatusPrettyCash body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = statusService.createStatusPrettyCash(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/pretty-cash", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get status pretty cash", notes = "get status pretty cash")
    public @ResponseBody
    ResponseEntity<?> getStatusPrettyCash(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = statusService.getStatusPrettyCash();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
