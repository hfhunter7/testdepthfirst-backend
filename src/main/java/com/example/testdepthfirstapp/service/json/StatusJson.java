package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.StatusEmployee;
import com.example.testdepthfirstapp.domain.StatusPrettyCash;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StatusJson {
    public ObjectNode createStatusEmployeeJson(StatusEmployee statusEmployee) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", statusEmployee.getId());
        jsonNodes.put("status", statusEmployee.getStatus());
        return jsonNodes;
    }

    public ObjectNode createStatusPrettyCashJson(StatusPrettyCash statusPrettyCash) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", statusPrettyCash.getId());
        jsonNodes.put("status", statusPrettyCash.getStatus());
        return jsonNodes;
    }
}
