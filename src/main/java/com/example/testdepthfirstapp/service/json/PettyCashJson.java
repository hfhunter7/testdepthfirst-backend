package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.PettyCash;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PettyCashJson {
    public ObjectNode createPettyCashJson(PettyCash pettyCash) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", pettyCash.getId());
        jsonNodes.put("code", pettyCash.getCode());
        jsonNodes.put("employee_name",pettyCash.getEmployee().getFirstName());
        jsonNodes.put("description", pettyCash.getDescription());
        jsonNodes.put("amount", pettyCash.getAmount());
        jsonNodes.put("status", pettyCash.getStatusPrettyCash().getStatus());
        jsonNodes.put("create_date", pettyCash.getCreateDate().toString());
        jsonNodes.put("modify_date", pettyCash.getModifyDate().toString());
        return jsonNodes;
    }
}
