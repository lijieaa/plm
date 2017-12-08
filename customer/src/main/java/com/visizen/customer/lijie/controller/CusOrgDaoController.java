package com.visizen.customer.lijie.controller;

import com.visizen.customer.lijie.dao.CusOrgDao;
import com.visizen.customer.lijie.po.CusOrgPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RepositoryRestController
public class CusOrgDaoController {

    @Autowired
    CusOrgDao dao;

    @DeleteMapping("/cus_org/bat_del")
    public @ResponseBody ResponseEntity<?> batDel(@RequestBody List<Long> ids) {
        dao.batDel(ids);
        return ResponseEntity.ok(null);
    };


    @GetMapping("/cus_org/queryPage")
    @ResponseBody
    public ResponseEntity<?> queryPage(Pageable pageable, CusOrgPo cusOrgPo) {
        Page<CusOrgPo> page = dao.findAll(new Specification<CusOrgPo>() {
            @Override
            public Predicate toPredicate(Root<CusOrgPo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list=new ArrayList<Predicate>();
                if(cusOrgPo.getCusName()!=null&&cusOrgPo.getCusName().length()>0){
                    list.add(cb.like(root.get("cusName").as(String.class), "%"+cusOrgPo.getCusName()+"%"));
                }

                if (cusOrgPo.getCusCon()!=null&&cusOrgPo.getCusCon().length()>0){
                    list.add(cb.like(root.get("cusCon").as(String.class), "%" +cusOrgPo.getCusCon()+"%"));
                }

                if (cusOrgPo.getCusTel()!=null&&cusOrgPo.getCusTel().length()>0){
                    list.add(cb.like(root.get("cusTel").as(String.class), "%" +cusOrgPo.getCusTel()+"%"));
                }

                Predicate[] predicates=new Predicate[list.size()];
                return cb.and(list.toArray(predicates));
            }
        }, pageable);

        PagedResources pagedResources=new PagedResources(page.getContent(),new PagedResources.PageMetadata(page.getSize(),page.getNumber(),page.getTotalElements(),page.getTotalPages()));
        return ResponseEntity.ok(pagedResources);
    };
}
