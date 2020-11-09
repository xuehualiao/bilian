package com.itxingrui.dao;

import com.itxingrui.bean.SysRoleAccess;
import com.itxingrui.bean.SysRoleAccessExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRoleAccessMapper {
    long countByExample(SysRoleAccessExample example);

    int deleteByExample(SysRoleAccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleAccess record);

    int insertSelective(SysRoleAccess record);

    List<SysRoleAccess> selectByExample(SysRoleAccessExample example);

    SysRoleAccess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleAccess record, @Param("example") SysRoleAccessExample example);

    int updateByExample(@Param("record") SysRoleAccess record, @Param("example") SysRoleAccessExample example);

    int updateByPrimaryKeySelective(SysRoleAccess record);

    int updateByPrimaryKey(SysRoleAccess record);
}