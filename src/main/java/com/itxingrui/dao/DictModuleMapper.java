package com.itxingrui.dao;

import com.itxingrui.bean.DictModule;
import com.itxingrui.bean.DictModuleExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DictModuleMapper {
    long countByExample(DictModuleExample example);

    int deleteByExample(DictModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictModule record);

    int insertSelective(DictModule record);

    List<DictModule> selectByExample(DictModuleExample example);

    DictModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictModule record, @Param("example") DictModuleExample example);

    int updateByExample(@Param("record") DictModule record, @Param("example") DictModuleExample example);

    int updateByPrimaryKeySelective(DictModule record);

    int updateByPrimaryKey(DictModule record);
}