package com.pinyougou.mapper;

import com.pinyougou.pojo.TbSeller;

import java.util.List;

public interface TbSellerMapper {
    int deleteByPrimaryKey(String sellerId);

    int insert(TbSeller record);

    int insertSelective(TbSeller record);

    TbSeller selectByPrimaryKey(String sellerId);

    int updateByPrimaryKeySelective(TbSeller record);

    int updateByPrimaryKey(TbSeller record);

    List<TbSeller> select4General(TbSeller tbSeller);
}