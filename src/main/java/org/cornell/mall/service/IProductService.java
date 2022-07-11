package org.cornell.mall.service;

import com.github.pagehelper.PageInfo;
import org.cornell.mall.vo.ProductDetailVo;
import org.cornell.mall.vo.ResponseVo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
