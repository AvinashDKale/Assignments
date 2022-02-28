package com.springWeb2.service;

import java.util.List;

import com.springWeb2.entity.IssueRequest;

public interface IssueRequestServiceInerface {
    
    void saveRequest(IssueRequest issuerequest);
    
    void deleteRequest(int id);
    
    List<IssueRequest> findAllRequests();
    
    IssueRequest getReuqestById(int id);
    
}
