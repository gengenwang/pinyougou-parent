package com.pinyougou.mapper;

import com.pinyougou.pojo.TbTypeTemplate;

import java.util.List;

public interface TbTypeTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbTypeTemplate record);

    int insertSelective(TbTypeTemplate record);

    TbTypeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbTypeTemplate record);

    int updateByPrimaryKey(TbTypeTemplate record);

    List<TbTypeTemplate> select4General(TbTypeTemplate tbTypeTemplate);
}