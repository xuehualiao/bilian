package com.itxingrui.dao;

import com.itxingrui.bean.SysUserAccess;
import com.itxingrui.bean.SysUserAccessExample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysUserAccessMapper {
    long countByExample(SysUserAccessExample example);

    int deleteByExample(SysUserAccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserAccess record);

    int insertSelective(SysUserAccess record);

    List<SysUserAccess> selectByExample(SysUserAccessExample example);

    SysUserAccess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserAccess record, @Param("example") SysUserAccessExample example);

    int updateByExample(@Param("record") SysUserAccess record, @Param("example") SysUserAccessExample example);

    int updateByPrimaryKeySelective(SysUserAccess record);

    int updateByPrimaryKey(SysUserAccess record);

    /**
     * 通过传入的list删除指定信息
     * @param id
     * @return
     */
    int deleteByAccessList(ArrayList<Integer> list);

    int deleteByUserId(int id);

    int insertForeach(ArrayList<SysUserAccess> list);
}