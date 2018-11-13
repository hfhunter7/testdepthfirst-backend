package com.example.testdepthfirstapp.controller;

import com.example.testdepthfirstapp.bean.CreateUserBean;
import com.example.testdepthfirstapp.exception.ResourceNotFoundException;
import com.example.testdepthfirstapp.service.UserService;
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
@RequestMapping(value = "/v1/users")
@Api(value = "users", description = "Users API")
public class UsersController extends AbstractRestHandler implements Serializable {
    private static final long serialVersionUID = -183784205305070314L;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "create user for test", notes = "create user for test")
    public @ResponseBody
    ResponseEntity<?> createUser(
            @RequestBody CreateUserBean body,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        try {


            ObjectNode jsonNodes = userService.createUser(body);
            return ResponseEntity.status(HttpStatus.OK).body(jsonNodes);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}
