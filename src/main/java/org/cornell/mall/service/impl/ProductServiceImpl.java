package org.cornell.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.dao.ProductMapper;
import org.cornell.mall.enums.ProductStatusEnum;
import org.cornell.mall.enums.ResponseEnum;
import org.cornell.mall.pojo.Product;
import org.cornell.mall.service.ICategoryService;
import org.cornell.mall.service.IProductService;
import org.cornell.mall.vo.ProductDetailVo;
import org.cornell.mall.vo.ProductVo;
import org.cornell.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null) {
            categoryService.findSubCategory(categoryId, categoryIdSet);
            categoryIdSet.add(categoryId);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = productList.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                })
                .collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product.getStatus().equals(ProductStatusEnum.OFF_SALE.getCode())
                || product.getStatus().equals(ProductStatusEnum.DELETE.getCode())){
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        return ResponseVo.success(productDetailVo);
    }
}
