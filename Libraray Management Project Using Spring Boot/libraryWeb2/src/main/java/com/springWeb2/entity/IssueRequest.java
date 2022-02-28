package com.springWeb2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issue_request")
public class IssueRequest {
    
    @Id
    @Column(name = "Book_id")
    private int id;
    
    @Column(name = "Issued_for")
    private String issued_for;

    public IssueRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public IssueRequest(int id, String issued_for) {
        super();
        this.id = id;
        this.issued_for = issued_for;
    }

    public int getId() {
        return id;
    }

    public String getIssued_for() {
        return issued_for;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIssued_for(String issued_for) {
        this.issued_for = issued_for;
    }

    @Override
    public String toString() {
        return "IssueRequest [id=" + id + ", issued_for=" + issued_for + "]";
    }
    
}
