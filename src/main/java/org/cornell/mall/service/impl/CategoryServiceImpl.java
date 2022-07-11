package org.cornell.mall.service.impl;

import org.cornell.mall.dao.CategoryMapper;
import org.cornell.mall.pojo.Category;
import org.cornell.mall.service.ICategoryService;
import org.cornell.mall.vo.CategoryVo;
import org.cornell.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.cornell.mall.consts.MallConst.ROOT_PARENT_ID;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<Category> categories = categoryMapper.selectAll();
        //for (Category category : categories) {
        //    if (category.getParentId().equals(ROOT_PARENT_ID)) {
        //        CategoryVo categoryVo = new CategoryVo();
        //        BeanUtils.copyProperties(category, categoryVo);
        //        categoryVoList.add(categoryVo);
        //    }
        //}
        List<CategoryVo> categoryVoList = categories.stream()
                .filter(category -> category.getParentId().equals(ROOT_PARENT_ID))
                .map(this::category2CategoryVo)
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());
        //查询子目录
        findSubCategory(categoryVoList, categories);
        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategory(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategory(id, resultSet, categories);
    }

    private void findSubCategory(Integer id, Set<Integer> resultSet, List<Category> categories){
        for (Category category : categories) {
            if (category.getParentId().equals(id)){
                resultSet.add(category.getId());
                findSubCategory(category.getId(), resultSet, categories);
            }
        }
    }

    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories){
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();
            for (Category category : categories) {
                if (categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    subCategoryVoList.add(subCategoryVo);
                }
                findSubCategory(subCategoryVoList, categories);
            }
            subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
            categoryVo.setSubCategories(subCategoryVoList);
        }
    }

    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
}
