package com.connext.test.sqlserver.repository;

import com.connext.test.sqlserver.entity.TBLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TBLeadRepository extends JpaRepository<TBLead, String>, JpaSpecificationExecutor<TBLead> {

}
