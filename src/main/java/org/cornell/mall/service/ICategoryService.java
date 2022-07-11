package org.cornell.mall.service;

import org.cornell.mall.vo.CategoryVo;
import org.cornell.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

public interface ICategoryService {
    ResponseVo<List<CategoryVo>> selectAll();
    void findSubCategory(Integer id, Set<Integer> resultSet);
}
