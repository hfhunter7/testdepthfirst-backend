package com.example.testdepthfirstapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="statusPrettyCash")
public class StatusPrettyCash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    @OneToMany(mappedBy = "statusPrettyCash", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PettyCash> pettyCashList;

    public StatusPrettyCash(){

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

    public List<PettyCash> getPettyCashList() {
        return pettyCashList;
    }

    public void setPettyCashList(List<PettyCash> pettyCashList) {
        this.pettyCashList = pettyCashList;
    }
}
