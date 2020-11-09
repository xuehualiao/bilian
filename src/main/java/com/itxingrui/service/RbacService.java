package com.itxingrui.service;

import com.itxingrui.bean.*;
import com.itxingrui.bean.dto.AccessDTO;
import com.itxingrui.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RbacService {

    @Autowired
    private IRbacMapper rbacMapper;

    @Autowired
    private SysUserAccessMapper sysUserAccessMapper;

    /**
     * 通过userId查询该用户所有的权限，并返回List<AccessDTO>
     * @param id
     * @return
     */
    public List<AccessDTO> getUserAndAccessByXml(Integer id) {
        return rbacMapper.getUserAndAccess(id);
    }

    /**
     * 通过userId ， 和accessId的集合 对 sys_user_access（用户权限中间表）进行操作
     * @param userId 用户Id
     * @param access 权限Id集合
     * @return 成功：1，失败0
     */
    public int setUserAccess(Integer userId, ArrayList<Integer> access) {
        if (userId == null ){
            return 0;
        }
        int t = sysUserAccessMapper.deleteByUserId(userId);
        ArrayList<SysUserAccess> ysUApasram = new ArrayList<>();
        for (Integer integer : access) {
            SysUserAccess sysUserAccess = new SysUserAccess();
            sysUserAccess.setUserId(userId);
            sysUserAccess.setAccessId(integer);
            ysUApasram.add(sysUserAccess);
        }
        int i = sysUserAccessMapper.insertForeach(ysUApasram);
        return 1;
    }
}
