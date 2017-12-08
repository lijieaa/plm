package com.visizen.sys.lijie.dao;


import com.visizen.sys.lijie.po.SysUserPo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@RepositoryRestResource(collectionResourceRel = "sys_user", path = "sys_user")
public interface SysUserDao extends PagingAndSortingRepository<SysUserPo, Long> {

    /**
     * 批量删除,不能删除超级管理员
     * @param ids
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "delete from sys_user where user_id in (?1) and user_id>1")
    void batDel(Collection<Long> ids);


    /**
     *用户名查询用户
     * @param username 用户名
     * @return
     */
    SysUserPo findByUsername(@Param("username") String username);



    @PreAuthorize("#aLong > 1")
    @Override
    void delete(Long aLong);
}
