package com.cloud.payment.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "PayDTO", description = "支付实体类")
public class PayDTO implements Serializable {

    @Schema(name = "id", description = "支付ID")
    private Integer id;

    @Schema(name = "payNo", description = "支付流水号")
    private String payNo;

    @Schema(name = "orderNo", description = "订单流水号")
    private String orderNo;

    @Schema(name = "userId", description = "用户账号ID")
    private Integer userId;

    @Schema(name = "amount", description = "交易金额")
    private BigDecimal amount;
}
