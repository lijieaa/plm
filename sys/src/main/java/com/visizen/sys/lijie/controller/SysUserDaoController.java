package com.visizen.sys.lijie.controller;

import com.visizen.sys.lijie.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RepositoryRestController
public class SysUserDaoController {

    @Autowired
    SysUserDao sysUserDao;

    @DeleteMapping("/sys_user/bat_del")
    public @ResponseBody ResponseEntity<?> batDel(@RequestBody List<Long> ids) {
        sysUserDao.batDel(ids);
        return ResponseEntity.ok(null);
    };
}
