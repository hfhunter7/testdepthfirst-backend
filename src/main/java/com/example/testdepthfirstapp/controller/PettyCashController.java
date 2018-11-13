package com.example.testdepthfirstapp.controller;

import com.example.testdepthfirstapp.bean.pettycash.CreatePettyCash;
import com.example.testdepthfirstapp.bean.pettycash.UpdateStatusPettyCash;
import com.example.testdepthfirstapp.bean.pettycash.UpdateStatusPettyCashApprove;
import com.example.testdepthfirstapp.exception.ResourceNotFoundException;
import com.example.testdepthfirstapp.service.PettyCashService;
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
@RequestMapping(value = "/v1/petty-cash")
@Api(value = "petty-cash", description = "Petty Cash API")
public class PettyCashController extends AbstractRestHandler implements Serializable {

    private static final long serialVersionUID = 6898730914074386209L;

    @Autowired
    private PettyCashService pettyCashService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create petty cash", notes = "create petty cash")
    public @ResponseBody
    ResponseEntity<?> createPettyCash(
            @RequestBody CreatePettyCash body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = pettyCashService.createPettyCash(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get petty cash", notes = "get petty cash")
    public @ResponseBody
    ResponseEntity<?> getPettyCash(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = pettyCashService.getPettyCash();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/approve", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get petty cash", notes = "get petty cash")
    public @ResponseBody
    ResponseEntity<?> getPettyCashApprove(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = pettyCashService.getPettyCashApprove();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/received", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get petty cash", notes = "get petty cash")
    public @ResponseBody
    ResponseEntity<?> getPettyCashReceived(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = pettyCashService.getPettyCashReceived();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/approve/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "update status petty cash approve", notes = "update status petty cash approve")
    public @ResponseBody
    ResponseEntity<?> updateStatusPettyCashApprove(
            @RequestBody UpdateStatusPettyCashApprove body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = pettyCashService.updateStatusPettyCashReceive(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get petty cash by employee", notes = "get petty cash by employee")
    public @ResponseBody
    ResponseEntity<?> getPettyCashByEmployee(
            @PathVariable Long employee_id,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = pettyCashService.getPettyCashByEmployee(employee_id);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/{petty_cash_id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update status petty cash", notes = "Update status petty cash")
    public @ResponseBody
    ResponseEntity<?> updateStatusPettyCash(
            @PathVariable Long petty_cash_id,
            @RequestBody UpdateStatusPettyCash body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {

            ObjectNode jsonNodes = pettyCashService.updateStatusPettyCash(petty_cash_id , body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
