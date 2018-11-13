package com.example.testdepthfirstapp.bean.pettycash;

public class CreatePettyCash {
    private Long employee_id;
    private String description;
    private String amount;

    public CreatePettyCash(){

    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
