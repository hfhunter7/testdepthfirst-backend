package com.example.testdepthfirstapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jobLevel")
public class JobLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobTitle;

    @OneToMany(mappedBy = "jobLevel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public JobLevel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
