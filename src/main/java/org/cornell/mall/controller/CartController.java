package org.cornell.mall.controller;

import org.cornell.mall.form.CartAddForm;
import org.cornell.mall.vo.CartVo;
import org.cornell.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CartController {
    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm) {
        return null;
    }
}
