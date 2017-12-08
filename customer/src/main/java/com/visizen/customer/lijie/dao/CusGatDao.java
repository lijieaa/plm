package com.visizen.customer.lijie.dao;


import com.visizen.customer.lijie.po.CusGatPo;
import com.visizen.customer.lijie.po.CusOrgPo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * 网关DAO
 */
@RepositoryRestResource(collectionResourceRel = "cus_gat", path = "cus_gat")
public interface CusGatDao extends PagingAndSortingRepository<CusGatPo, Long>,JpaSpecificationExecutor<CusGatPo> {


    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "delete from cus_gat where gat_id in (?1)")
    void batDel(Collection<Long> ids);

    CusOrgPo findByGatName(@Param("gatName") String gatName);

}
