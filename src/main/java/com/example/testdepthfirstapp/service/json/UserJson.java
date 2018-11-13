package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.Users;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UserJson {
    public ObjectNode createUserJson(Users user) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", user.getId());
        jsonNodes.put("username", user.getUsername());
        jsonNodes.put("password", user.getPassword());
        return jsonNodes;
    }
}
