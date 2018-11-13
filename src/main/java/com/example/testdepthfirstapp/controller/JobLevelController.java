package com.example.testdepthfirstapp.controller;

import com.example.testdepthfirstapp.bean.joblevel.CreateJobLevelBean;
import com.example.testdepthfirstapp.domain.JobLevel;
import com.example.testdepthfirstapp.exception.ResourceNotFoundException;
import com.example.testdepthfirstapp.service.JobLevelService;
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
@RequestMapping(value = "/v1/job-level")
@Api(value = "job level", description = "Job Level API")
public class JobLevelController extends AbstractRestHandler implements Serializable {
    private static final long serialVersionUID = 8247453107144692364L;

    @Autowired
    private JobLevelService jobLevelService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create job level", notes = "create job level")
    public @ResponseBody
    ResponseEntity<?> createStatusPrettyCash(
            @RequestBody CreateJobLevelBean body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = jobLevelService.createJobLevel(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "get job level", notes = "get job level")
    public @ResponseBody
    ResponseEntity<?> getStatusPrettyCash(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {
            ObjectNode jsonNodes = jobLevelService.getJobLevels();
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
