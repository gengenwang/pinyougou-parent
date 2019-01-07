package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * <p>品牌列表</p>
 *
 * @author wanggengen
 * @version $ Id: BrandService.java, v 0.1 2019/1/6 22:10 wanggengen Exp $$
 **/
public interface BrandService {

    public List<TbBrand> findAll();

}
