package org.cornell.mall.service;

import org.cornell.mall.form.CartAddForm;
import org.cornell.mall.form.CartUpdateForm;
import org.cornell.mall.pojo.Cart;
import org.cornell.mall.vo.CartVo;
import org.cornell.mall.vo.ResponseVo;

import java.util.List;

public interface ICartService {
    ResponseVo<CartVo> add(Integer uid, CartAddForm form);
    ResponseVo<CartVo> list(Integer uid);
    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);
    ResponseVo<CartVo> delete(Integer uid, Integer productId);
    ResponseVo<CartVo> selectAll(Integer uid);
    ResponseVo<CartVo> unSelectAll(Integer uid);
    ResponseVo<Integer> sum(Integer uid);
    List<Cart> listForCart(Integer uid);
}
