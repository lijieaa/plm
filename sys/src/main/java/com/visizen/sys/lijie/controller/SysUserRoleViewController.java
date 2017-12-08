package com.visizen.sys.lijie.controller;

import com.visizen.sys.lijie.dao.SysUserRoleViewDao;
import com.visizen.sys.lijie.po.UserRoleViewPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
public class SysUserRoleViewController {


    @Autowired
    SysUserRoleViewDao dao;

    /**
     * 组合条件查询系统用户
     * @param pageable
     * @param userRoleViewPo
     * @return
     */
    @GetMapping("/sys_view/queryPage")
    @ResponseBody
    public ResponseEntity<?> queryPage(Pageable pageable, UserRoleViewPo userRoleViewPo) {
        Page<UserRoleViewPo> page = dao.findAll(new Specification<UserRoleViewPo>() {
            @Override
            public Predicate toPredicate(Root<UserRoleViewPo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list=new ArrayList<Predicate>();
                if(userRoleViewPo.getUsername()!=null&&userRoleViewPo.getUsername().length()>0){
                    list.add(cb.like(root.get("username").as(String.class), "%"+userRoleViewPo.getUsername()+"%"));
                }

                if (userRoleViewPo.getNickname()!=null&&userRoleViewPo.getNickname().length()>0){
                    list.add(cb.like(root.get("nickname").as(String.class), "%" +userRoleViewPo.getNickname()+"%"));
                }

                Predicate[] predicates=new Predicate[list.size()];
                return cb.and(list.toArray(predicates));
            }
        }, pageable);

        PagedResources pagedResources=new PagedResources(page.getContent(),new PagedResources.PageMetadata(page.getSize(),page.getNumber(),page.getTotalElements(),page.getTotalPages()));
        return ResponseEntity.ok(pagedResources);
    };

}
