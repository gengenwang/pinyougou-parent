package com.pinyougou.mapper;

import com.pinyougou.pojo.TbSpecificationOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSpecificationOptionMapper {
    int deleteByPrimaryKey(Long id);

    int deleteBySpecId(@Param("specId") Long specId);

    int insert(TbSpecificationOption record);

    int insertSelective(TbSpecificationOption record);

    TbSpecificationOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbSpecificationOption record);

    int updateByPrimaryKey(TbSpecificationOption record);

    List<TbSpecificationOption> select4General(TbSpecificationOption tbSpecification);
}