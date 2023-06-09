package com.coderpwh.member.domain.enums;

/**
 * @author coderpwh
 * @date 2023/6/9 15:25
 */
public enum RefundStatusEnum {


    PENDING("pending", "处理中"),

    REFUNDING("refunding", "退款中"),

    REFUND("refund", "已退款"),

    FAILED("failed", "退款失败"),

    CLOSED("closed", "退款关闭"),
    ;
    private String status;
    private String statusDesc;

    RefundStatusEnum(String status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }


    public static RefundStatusEnum getOrderType(String status) {
        for (RefundStatusEnum c : values()) {
            if (status.equals(c.status)) {
                return c;
            }
        }
        return null;
    }

    public static String getStatusDesc(String status) {
        for (RefundStatusEnum c : RefundStatusEnum.values()) {
            if (c.status.equals(status)) {
                return c.statusDesc;
            }
        }
        return null;
    }
}
