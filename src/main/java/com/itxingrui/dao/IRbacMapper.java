package com.itxingrui.dao;

import com.itxingrui.bean.dto.AccessDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IRbacMapper {

    //TODO 修改返回值
    List<AccessDTO> getUserAndAccess(Integer id);
}
