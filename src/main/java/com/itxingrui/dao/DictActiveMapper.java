package com.itxingrui.dao;

import com.itxingrui.bean.DictActive;
import com.itxingrui.bean.DictActiveExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DictActiveMapper {
    long countByExample(DictActiveExample example);

    int deleteByExample(DictActiveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictActive record);

    int insertSelective(DictActive record);

    List<DictActive> selectByExample(DictActiveExample example);

    DictActive selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictActive record, @Param("example") DictActiveExample example);

    int updateByExample(@Param("record") DictActive record, @Param("example") DictActiveExample example);

    int updateByPrimaryKeySelective(DictActive record);

    int updateByPrimaryKey(DictActive record);
}