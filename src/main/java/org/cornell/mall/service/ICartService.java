package org.cornell.mall.service;

import org.cornell.mall.form.CartAddForm;
import org.cornell.mall.vo.CartVo;
import org.cornell.mall.vo.ResponseVo;

public interface ICartService {
    ResponseVo<CartVo> add(CartAddForm form);
}
