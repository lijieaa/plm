package com.visizen.sys.lijie.dao;

import com.visizen.sys.lijie.po.SysRolePo;
import com.visizen.sys.lijie.po.SysUserPo;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sys_role", path = "sys_role")
public interface SysRoleDao extends CrudRepository<SysRolePo, Long> {
}
