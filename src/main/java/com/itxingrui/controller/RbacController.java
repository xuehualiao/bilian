package com.itxingrui.controller;

import com.itxingrui.bean.SysRole;
import com.itxingrui.bean.SysUser;
import com.itxingrui.bean.dto.Result;
import com.itxingrui.service.RbacService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/rbac")
public class RbacController {

    @Autowired
    private RbacService rbacService;

    /**
     * 通过userId查询该用户所有的权限，并返回List<AccessDTO>
     * @param id
     * @return
     */
    @RequestMapping("/getUserAccById")
    @RequiresPermissions("/gett")
    public Result getUserAndAccess(@RequestParam("id") Integer id){
        try {
            Result success = Result.getSuccess();
            HashMap<String, Object> resultMap = new HashMap<>();
            resultMap.put("access", rbacService.getUserAndAccessByXml(id));
            resultMap.put("msg","宇哥不打游戏，我就卸载了，拉倒吧");
            success.setData(resultMap);
            return success;
        } catch (Exception e) {
            e.printStackTrace();
            Result faild = Result.getFaild();
            faild.setMsg("垃圾宇哥不打游戏，就是个弟弟");
            return faild;
        }
    }

    /**
     * 通过userId ， 和accessId的集合 对 sys_user_access（用户权限中间表）进行操作
     */
    @RequestMapping("/setAccess")
    public Result setUserAccess(@RequestBody HashMap<String,Object> param){
        try {
            Result success = Result.getSuccess();
            HashMap<String, Object> resultMap = new HashMap<>();
            Integer userId = (Integer)param.get("userId");
            ArrayList<Integer> access = (ArrayList<Integer>)param.get("access");
            rbacService.setUserAccess(userId,access);
            success.setMsg("成功啦");
            return success;
        }catch (Exception e){
            e.printStackTrace();
            Result faild = Result.getFaild();
            faild.setMsg("宇哥不争气");
            return faild;
        }
    }

}
