package com.example.testdepthfirstapp.service;

import com.example.testdepthfirstapp.bean.pettycash.CreatePettyCash;
import com.example.testdepthfirstapp.bean.pettycash.UpdatePettyCashApprove;
import com.example.testdepthfirstapp.bean.pettycash.UpdateStatusPettyCash;
import com.example.testdepthfirstapp.bean.pettycash.UpdateStatusPettyCashApprove;
import com.example.testdepthfirstapp.domain.Employee;
import com.example.testdepthfirstapp.domain.PettyCash;
import com.example.testdepthfirstapp.domain.StatusPrettyCash;
import com.example.testdepthfirstapp.exception.DataFormatException;
import com.example.testdepthfirstapp.repository.impl.EmployeeRepositoryService;
import com.example.testdepthfirstapp.repository.impl.PettyCashRepositoryService;
import com.example.testdepthfirstapp.repository.impl.StatusPrettyCashRepositoryService;
import com.example.testdepthfirstapp.service.json.PettyCashJson;
import com.example.testdepthfirstapp.utils.DateUtil;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PettyCashService extends PettyCashJson {
    private static final Logger log = LoggerFactory.getLogger(PettyCashService.class);

    @Autowired
    private EmployeeRepositoryService employeeRepositoryService;

    @Autowired
    private PettyCashRepositoryService pettyCashRepositoryService;

    @Autowired
    private StatusPrettyCashRepositoryService statusPrettyCashRepositoryService;

    @Transactional
    public ObjectNode createPettyCash(CreatePettyCash body) {
        int year = LocalDate.now().getYear();
        List<PettyCash> pettyCashList = pettyCashRepositoryService.findAll();
        String s = String.format("%04d", (pettyCashList.size() + 1));

        Employee employee = employeeRepositoryService.find(body.getEmployee_id());

        StatusPrettyCash statusPrettyCash = statusPrettyCashRepositoryService.find(Long.valueOf(1));

        PettyCash pettyCash = new PettyCash();
        pettyCash.setCode("PC" + year + "" + s);
        pettyCash.setAmount(Double.parseDouble(body.getAmount()));
        pettyCash.setDescription(body.getDescription());
        pettyCash.setEmployee(employee);
        pettyCash.setStatusPrettyCash(statusPrettyCash);
        pettyCash.setCreateDate(DateUtil.getCurrentDateTime());
        pettyCash.setModifyDate(DateUtil.getCurrentDateTime());

        try {
            pettyCash = pettyCashRepositoryService.save(pettyCash);
            return createPettyCashJson(pettyCash);
        } catch (DataFormatException e) {
            throw new DataFormatException("create petty cash fail.");
        }
    }

    @Transactional
    public ObjectNode updateStatusPettyCashReceive(UpdateStatusPettyCashApprove body) {


        StatusPrettyCash statusPrettyCash = statusPrettyCashRepositoryService.find(Long.valueOf(6));



        try {

            for(UpdatePettyCashApprove update: body.getPettyCashApproveList()){
                PettyCash pettyCash = pettyCashRepositoryService.find(update.getPetty_cash_id());
                pettyCash.setStatusPrettyCash(statusPrettyCash);
                pettyCashRepositoryService.update(pettyCash);

            }

            return null;
        } catch (DataFormatException e) {
            throw new DataFormatException("create petty cash fail.");
        }
    }

    @Transactional
    public ObjectNode getPettyCash() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        List<PettyCash> pettyCashList = new ArrayList<>();
        try {
            pettyCashList = pettyCashRepositoryService.findAll();

            for (PettyCash pettyCash : pettyCashList) {
                ObjectNode pettyCashNode = new ObjectNode(JsonNodeFactory.instance);
                pettyCashNode.put("id", pettyCash.getId());
                pettyCashNode.put("code", pettyCash.getCode());
                pettyCashNode.put("employee_name", pettyCash.getEmployee().getFirstName());
                pettyCashNode.put("description", pettyCash.getDescription());
                pettyCashNode.put("amount", pettyCash.getAmount());
                pettyCashNode.put("status", pettyCash.getStatusPrettyCash().getStatus());
                pettyCashNode.put("create_date", pettyCash.getCreateDate().toString());
                pettyCashNode.put("modify_date", pettyCash.getModifyDate().toString());
                arrayNode.add(pettyCashNode);
            }
            objectNode.set("petty_cash", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get petty cash fail.");
        }
    }

    @Transactional
    public ObjectNode getPettyCashApprove() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);

        StatusPrettyCash statusPrettyCash = statusPrettyCashRepositoryService.find(Long.valueOf(2));

        List<PettyCash> pettyCashList = new ArrayList<>();
        try {
            pettyCashList = pettyCashRepositoryService.findByStatusPettyCash(statusPrettyCash);

            for (PettyCash pettyCash : pettyCashList) {
                ObjectNode pettyCashNode = new ObjectNode(JsonNodeFactory.instance);
                pettyCashNode.put("id", pettyCash.getId());
                pettyCashNode.put("code", pettyCash.getCode());
                pettyCashNode.put("employee_name", pettyCash.getEmployee().getFirstName());
                pettyCashNode.put("description", pettyCash.getDescription());
                pettyCashNode.put("amount", pettyCash.getAmount());
                pettyCashNode.put("status", pettyCash.getStatusPrettyCash().getStatus());
                pettyCashNode.put("create_date", pettyCash.getCreateDate().toString());
                pettyCashNode.put("modify_date", pettyCash.getModifyDate().toString());
                arrayNode.add(pettyCashNode);
            }
            objectNode.set("petty_cash_approve", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get petty cash approve fail.");
        }
    }

    @Transactional
    public ObjectNode getPettyCashReceived() {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);

        StatusPrettyCash statusPrettyCash = statusPrettyCashRepositoryService.find(Long.valueOf(7));

        List<PettyCash> pettyCashList = new ArrayList<>();
        try {
            pettyCashList = pettyCashRepositoryService.findByStatusPettyCash(statusPrettyCash);

            for (PettyCash pettyCash : pettyCashList) {
                ObjectNode pettyCashNode = new ObjectNode(JsonNodeFactory.instance);
                pettyCashNode.put("id", pettyCash.getId());
                pettyCashNode.put("code", pettyCash.getCode());
                pettyCashNode.put("employee_name", pettyCash.getEmployee().getFirstName());
                pettyCashNode.put("description", pettyCash.getDescription());
                pettyCashNode.put("amount", pettyCash.getAmount());
                pettyCashNode.put("status", pettyCash.getStatusPrettyCash().getStatus());
                pettyCashNode.put("create_date", pettyCash.getCreateDate().toString());
                pettyCashNode.put("modify_date", pettyCash.getModifyDate().toString());
                arrayNode.add(pettyCashNode);
            }
            objectNode.set("petty_cash_received", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get petty cash received fail.");
        }
    }

    @Transactional
    public ObjectNode getPettyCashByEmployee(Long employee_id) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);

        Employee employee = employeeRepositoryService.find(employee_id);

        try {
            List<PettyCash> pettyCashList = pettyCashRepositoryService.findByEmployee(employee);


            for (PettyCash pettyCash : pettyCashList) {
                ObjectNode pettyCashNode = new ObjectNode(JsonNodeFactory.instance);
                pettyCashNode.put("id", pettyCash.getId());
                pettyCashNode.put("code", pettyCash.getCode());
                pettyCashNode.put("employee_name", pettyCash.getEmployee().getFirstName());
                pettyCashNode.put("description", pettyCash.getDescription());
                pettyCashNode.put("amount", pettyCash.getAmount());
                pettyCashNode.put("status", pettyCash.getStatusPrettyCash().getStatus());
                pettyCashNode.put("create_date", pettyCash.getCreateDate().toString());
                pettyCashNode.put("modify_date", pettyCash.getModifyDate().toString());
                arrayNode.add(pettyCashNode);
            }
            objectNode.set("petty_cash", arrayNode);
            return objectNode;
        } catch (DataFormatException e) {
            throw new DataFormatException("get petty cash by employee fail.");
        }
    }

    @Transactional
    public ObjectNode updateStatusPettyCash(Long petty_cash_id, UpdateStatusPettyCash body) {

        StatusPrettyCash statusPrettyCash = statusPrettyCashRepositoryService.find(body.getStatus_id());

        PettyCash pettyCash = pettyCashRepositoryService.find(petty_cash_id);

        try {
            pettyCash.setStatusPrettyCash(statusPrettyCash);
            pettyCashRepositoryService.update(pettyCash);
            return createPettyCashJson(pettyCash);
        } catch (DataFormatException e) {
            throw new DataFormatException("update status petty cash fail.");
        }
    }
}
