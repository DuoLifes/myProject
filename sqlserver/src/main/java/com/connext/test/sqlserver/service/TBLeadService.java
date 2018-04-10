package com.connext.test.sqlserver.service;

import com.connext.test.sqlserver.entity.TBLead;
import com.connext.test.sqlserver.repository.TBLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TBLeadService {
    @Autowired
    private TBLeadRepository tbLeadRepository;

    public Page<TBLead> findTBLead(Pageable pageable){
         Page<TBLead>page=tbLeadRepository.findAll(pageable);
         return page;
    }
}
