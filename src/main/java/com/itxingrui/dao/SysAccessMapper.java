package com.itxingrui.dao;

import com.itxingrui.bean.SysAccess;
import com.itxingrui.bean.SysAccessExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysAccessMapper {
    long countByExample(SysAccessExample example);

    int deleteByExample(SysAccessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAccess record);

    int insertSelective(SysAccess record);

    List<SysAccess> selectByExample(SysAccessExample example);

    SysAccess selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAccess record, @Param("example") SysAccessExample example);

    int updateByExample(@Param("record") SysAccess record, @Param("example") SysAccessExample example);

    int updateByPrimaryKeySelective(SysAccess record);

    int updateByPrimaryKey(SysAccess record);
}