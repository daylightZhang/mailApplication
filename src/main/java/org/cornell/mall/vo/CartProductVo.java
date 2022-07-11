package org.cornell.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductVo {

    private Integer productId;
    private Integer quantity;  //购买的数量
    private String productName;
    private String productSubtitle;
    private String productMainImage;
    private BigDecimal productPrice;
    private Integer productStatus;
    private BigDecimal productTotalPrice;
    private Integer productStock;
    private Boolean productSelected; // 商品是否选中

}
