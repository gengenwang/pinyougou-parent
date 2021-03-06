package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojogroup.Specification;
import com.pinyougou.sellergoods.service.SpecificationService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    /**
     * 查询全部
     */
    @Override
    public List<TbSpecification> findAll() {
        return specificationMapper.select4General(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.select4General(null);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(Specification specification) {
        //获取规格实体
        TbSpecification tbspecification = specification.getSpecification();
        specificationMapper.insert(tbspecification);

        //获取规格选项集合
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (TbSpecificationOption option : specificationOptionList) {
            option.setSpecId(tbspecification.getId());//设置规格ID
            specificationOptionMapper.insert(option);//新增规格
        }
    }


    /**
     * 修改
     */
    @Override
    public void update(Specification specification) {

        //获取规格实体
        TbSpecification tbspecification = specification.getSpecification();
        specificationMapper.updateByPrimaryKeySelective(tbspecification);

        //删除原来规格对应的规格选项
        specificationOptionMapper.deleteBySpecId(tbspecification.getId());

        //获取规格选项集合
        List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
        for (TbSpecificationOption option : specificationOptionList) {
            option.setSpecId(tbspecification.getId());//设置规格ID
            specificationOptionMapper.insert(option);//新增规格
        }

    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public Specification findOne(Long id) {

        Specification specification = new Specification();
        //获取规格实体
        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        specification.setSpecification(tbSpecification);

        //获取规格选项列表
        TbSpecificationOption specificationOptionSelect = new TbSpecificationOption();
        specificationOptionSelect.setSpecId(id);
        List<TbSpecificationOption> specificationOptionList = specificationOptionMapper.select4General(specificationOptionSelect);
        specification.setSpecificationOptionList(specificationOptionList);

        return specification;//组合实体类
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            //删除规格表数据
            specificationMapper.deleteByPrimaryKey(id);

            //删除规格选项表数据
            specificationOptionMapper.deleteBySpecId(id);
        }
    }


    @Override
    public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        Page<TbSpecification> page = (Page<TbSpecification>) specificationMapper.select4General(specification);
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        // TODO Auto-generated method stub
        return specificationMapper.selectOptionList();
    }

}
