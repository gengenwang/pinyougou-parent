package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>注释</p>
 *
 * @author wanggengen
 * @version $ Id: BrandServiceImpl.java, v 0.1 2019/1/6 22:13 wanggengen Exp $$
 **/
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;

    @Override
    public List<TbBrand> findAll() {
        return brandMapper.select4General(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        //分页
        PageHelper.startPage(pageNum, pageSize);

        Page<TbBrand> page = (Page<TbBrand>) brandMapper.select4General(null);

        return new PageResult(page.getTotal(), page.getResult());
    }
}
