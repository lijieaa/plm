package com.visizen.customer.lijie.dao;


import com.visizen.customer.lijie.po.CusOrgPo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@RepositoryRestResource(collectionResourceRel = "cus_org", path = "cus_org")
public interface CusOrgDao extends PagingAndSortingRepository<CusOrgPo, Long>,JpaSpecificationExecutor<CusOrgPo> {


    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "delete from cus_org where cus_id in (?1)")
    void batDel(Collection<Long> ids);

    CusOrgPo findByCusName(@Param("cusName")String cusName);

}
