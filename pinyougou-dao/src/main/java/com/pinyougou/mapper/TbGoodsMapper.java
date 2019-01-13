package com.pinyougou.mapper;

import com.pinyougou.pojo.TbGoods;

import java.util.List;

public interface TbGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbGoods record);

    int insertSelective(TbGoods record);

    TbGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbGoods record);

    int updateByPrimaryKey(TbGoods record);

    List<TbGoods> select4General(TbGoods tbGoods);
}