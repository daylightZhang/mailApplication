package org.cornell.mall.vo;

import lombok.Data;
import org.cornell.mall.pojo.Shipping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderVo {
    private Long OrderNo;
    private BigDecimal payment;
    private Integer paymentType;
    private Integer postage;
    private Integer status;
    private Date paymentTime;
    private Date sendTime;
    private Date endTime;
    private Date closeTime;
    private Date createTime;
    private List<OrderItemVo> orderItemVoList;
    private Integer shippingId;
    private Shipping shippingVo;
}
