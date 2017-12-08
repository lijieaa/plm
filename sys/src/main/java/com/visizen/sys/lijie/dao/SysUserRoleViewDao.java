package com.visizen.sys.lijie.dao;

import com.visizen.sys.lijie.po.UserRoleViewPo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "sys_view", path = "sys_view")
public interface SysUserRoleViewDao extends PagingAndSortingRepository<UserRoleViewPo, Long>,JpaSpecificationExecutor<UserRoleViewPo> {

}
