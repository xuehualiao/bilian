//package com.itxingrui.service;
//
//import com.itxingrui.bean.SysAccess;
//import com.itxingrui.bean.SysRole;
//import com.itxingrui.bean.SysUser;
//import com.itxingrui.bean.SysUserExample;
//import com.itxingrui.dao.SysUserMapper;
//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class LoginService {
//
//    @Autowired
//    private SysUserMapper sysUserMapper;
//
//    public SysUser getSysUserByName(String getMapByName) {
//        return getMapByName(getMapByName);
//    }
//
//    /**
//     * 模拟数据库查询
//     *
//     * @param userName 用户名
//     * @return SysUser
//     */
//    private SysUser getMapByName(String userName) {
//
//        SysUserExample example = new SysUserExample();
//        example.createCriteria().andUsernameEqualTo(userName);
//        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
//
//        return sysUsers.get(0);
//    }
//}
