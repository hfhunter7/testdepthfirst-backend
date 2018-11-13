package com.example.testdepthfirstapp.controller;

import com.example.testdepthfirstapp.bean.manager.CreateManagerBean;
import com.example.testdepthfirstapp.exception.ResourceNotFoundException;
import com.example.testdepthfirstapp.service.ManagerService;
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
@RequestMapping(value = "/v1/manager")
@Api(value = "manager", description = "Manager API")
public class ManagerController extends AbstractRestHandler implements Serializable {

    private static final long serialVersionUID = 3245628770281888691L;

    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create manager", notes = "create manager")
    public @ResponseBody
    ResponseEntity<?> createManager(
            @RequestBody CreateManagerBean body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = managerService.createManager(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get manager", notes = "get manager")
    public @ResponseBody
    ResponseEntity<?> getManager(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = managerService.getManagers();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/employee/{manager_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get employee by manager", notes = "get employee by manager")
    public @ResponseBody
    ResponseEntity<?> getEmployeeByManager(
            @PathVariable Long manager_id,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = managerService.getEmployeeByManager(manager_id);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
