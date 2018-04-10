package com.connext.test.sqlserver.entity;



import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBLead")
@Data
public class TBLead {
    @Id
    private String ID;
    @Column
    private String LeadUserName;
    @Column
    private String LeadUserMobile;
}
