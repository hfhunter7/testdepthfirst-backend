package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.joblevel.CreateJobLevelBean;
import com.example.testdepthfirstapp.domain.JobLevel;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.JobLevelRepositoryService;
import com.example.testdepthfirstapp.service.json.JobLevelJson;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobLevelService extends JobLevelJson {

    @Autowired
    private JobLevelRepositoryService jobLevelRepositoryService;

    @Transactional
    public ObjectNode createJobLevel(CreateJobLevelBean body) {
        JobLevel jobLevel = new JobLevel();
        jobLevel.setJobTitle(body.getJob_title());
        try {
            jobLevel = jobLevelRepositoryService.save(jobLevel);
            return createJobLevelJson(jobLevel);
        } catch (DataFormatException e) {
            throw new DataFormatException("create job level fail.");
        }
    }

    @Transactional
    public ObjectNode getJobLevels() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<JobLevel> jobLevelArrayList = new ArrayList<>();
        try {
            jobLevelArrayList = jobLevelRepositoryService.findAll();

            for(JobLevel j : jobLevelArrayList){
                ObjectNode jobLevelNode = new ObjectNode(JsonNodeFactory.instance);
                jobLevelNode.put("id",j.getId());
                jobLevelNode.put("job_title",j.getJobTitle());
                arrayNode.add(jobLevelNode);
            }
            objectNode.set("job_level",arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get job level fail.");
        }
    }
}
