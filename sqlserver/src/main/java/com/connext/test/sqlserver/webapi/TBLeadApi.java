package com.connext.test.sqlserver.webapi;

import com.connext.test.sqlserver.entity.TBLead;
import com.connext.test.sqlserver.service.TBLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Sqlserver")
public class TBLeadApi {
    @Autowired
    private TBLeadService tbLeadService;

    @GetMapping("/findAll")
    public Page<TBLead> findTBLead(Pageable pageable){
        Page<TBLead>page= tbLeadService.findTBLead(pageable);
        return page;
    }
}
