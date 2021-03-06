package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * <p>品牌列表</p>
 *
 * @author wanggengen
 * @version $ Id: BrandService.java, v 0.1 2019/1/6 22:10 wanggengen Exp $$
 **/
public interface BrandService {

    List<TbBrand> findAll();

    /**
     * 品牌分页
     *
     * @param pageNum  当前页面
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    void add(TbBrand brand);

    TbBrand findOne(Long id);

    void update(TbBrand brand);

    void delete(Long[] ids);

    PageResult findPage(TbBrand brand, int pageNum, int pageSize);

}
