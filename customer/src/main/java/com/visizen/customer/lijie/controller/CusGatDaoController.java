package com.visizen.customer.lijie.controller;

import com.visizen.customer.lijie.dao.CusGatDao;
import com.visizen.customer.lijie.dao.CusOrgDao;
import com.visizen.customer.lijie.po.CusGatPo;
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

/**
 * 网关Controller
 */
@RepositoryRestController
public class CusGatDaoController {

    @Autowired
    CusGatDao dao;

    @DeleteMapping("/cus_gat/bat_del")
    public @ResponseBody ResponseEntity<?> batDel(@RequestBody List<Long> ids) {
        dao.batDel(ids);
        return ResponseEntity.ok(null);
    };


    @GetMapping("/cus_gat/queryPage")
    @ResponseBody
    public ResponseEntity<?> queryPage(Pageable pageable, CusGatPo cusGatPo) {
        Page<CusGatPo> page = dao.findAll(new Specification<CusGatPo>() {
            @Override
            public Predicate toPredicate(Root<CusGatPo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list=new ArrayList<Predicate>();
                if(cusGatPo.getGatName()!=null&&cusGatPo.getGatName().length()>0){
                    list.add(cb.like(root.get("gatName").as(String.class), "%"+cusGatPo.getGatName()+"%"));
                }

                if (cusGatPo.getGatImsi()!=null&&cusGatPo.getGatImsi().length()>0){
                    list.add(cb.like(root.get("gatImsi").as(String.class), "%" +cusGatPo.getGatImsi()+"%"));
                }

                if (cusGatPo.getGatStatus()!=null){
                    list.add(cb.equal(root.get("gatStatus").as(Byte.class), cusGatPo.getGatStatus()));
                }

                Predicate[] predicates=new Predicate[list.size()];
                return cb.and(list.toArray(predicates));
            }
        }, pageable);

        PagedResources pagedResources=new PagedResources(page.getContent(),new PagedResources.PageMetadata(page.getSize(),page.getNumber(),page.getTotalElements(),page.getTotalPages()));
        return ResponseEntity.ok(pagedResources);
    };
}
