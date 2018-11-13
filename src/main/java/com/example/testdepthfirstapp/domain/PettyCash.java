package com.example.testdepthfirstapp.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="prettyCash")
public class PettyCash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    private String description;
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private StatusPrettyCash statusPrettyCash;

    private Timestamp createDate;
    private Timestamp modifyDate;

    public PettyCash(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public StatusPrettyCash getStatusPrettyCash() {
        return statusPrettyCash;
    }

    public void setStatusPrettyCash(StatusPrettyCash statusPrettyCash) {
        this.statusPrettyCash = statusPrettyCash;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }
}
