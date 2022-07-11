package org.cornell.mall.service.impl;

import org.cornell.mall.dao.ProductMapper;
import org.cornell.mall.form.CartAddForm;
import org.cornell.mall.service.ICartService;
import org.cornell.mall.vo.CartVo;
import org.cornell.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public ResponseVo<CartVo> add(CartAddForm form) {
        // 判断商品是否已经在购物车饿了

        // 判断商品是否正常在售

        // 判断库存是否充足
        return null;
    }
}
