package com.example.testdepthfirstapp.service.json;

import com.example.testdepthfirstapp.domain.JobLevel;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JobLevelJson {
    public ObjectNode createJobLevelJson(JobLevel jobLevel) {
        ObjectNode jsonNodes = new ObjectNode(JsonNodeFactory.instance);
        jsonNodes.put("id", jobLevel.getId());
        jsonNodes.put("job_title", jobLevel.getJobTitle());
        return jsonNodes;
    }
}
