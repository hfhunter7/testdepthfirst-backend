package com.example.testdepthfirstapp.bean.pettycash;

import java.util.List;

public class UpdateStatusPettyCashApprove {
    private List<UpdatePettyCashApprove> pettyCashApproveList;

    public UpdateStatusPettyCashApprove(){

    }

    public List<UpdatePettyCashApprove> getPettyCashApproveList() {
        return pettyCashApproveList;
    }

    public void setPettyCashApproveList(List<UpdatePettyCashApprove> pettyCashApproveList) {
        this.pettyCashApproveList = pettyCashApproveList;
    }
}
