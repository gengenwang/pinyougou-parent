package com.pinyougou.mapper;

import com.pinyougou.pojo.TbSpecification;

import java.util.List;
import java.util.Map;

public interface TbSpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbSpecification record);

    int insertSelective(TbSpecification record);

    TbSpecification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSpecification record);

    int updateByPrimaryKey(TbSpecification record);

    List<TbSpecification> select4General(TbSpecification tbSpecification);

    List<Map> selectOptionList();
}