package com.example.testdepthfirstapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="statusEmployee")
public class StatusEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    @OneToMany(mappedBy = "statusEmployee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public StatusEmployee(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
