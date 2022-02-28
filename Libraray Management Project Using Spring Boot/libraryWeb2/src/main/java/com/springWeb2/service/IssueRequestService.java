package com.springWeb2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb2.entity.IssueRequest;
import com.springWeb2.repository.IssueRequestRepository;

@Service
public class IssueRequestService implements IssueRequestServiceInerface {
    
    @Autowired
    private IssueRequestRepository issuerequestrepo;
    
    @Override
    public void saveRequest(IssueRequest issuerequest) {
        this.issuerequestrepo.save(issuerequest);
        
    }
    
    @Override
    public List<IssueRequest> findAllRequests() {
        return (List<IssueRequest>) issuerequestrepo.findAll();
    }
    
    @Override
    public void deleteRequest(int id) {
        this.issuerequestrepo.deleteById(id);
        
    }
    
    public IssueRequest getReuqestById(int id) {
        return issuerequestrepo.findById(id).get();
        
    }
}
