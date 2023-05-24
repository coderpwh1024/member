package com.coderpwh.member.domain.enums;

/**
 * @author coderpwh
 * @date 2023/5/24 17:48
 */
public enum OrderTypeEnum {

    API(1, "api"),

    CASHIER(2, "收银台"),

    CODE(3, "兑换码"),

    ;
    private int v;
    private String desc;

    OrderTypeEnum(int v, String desc) {
        this.v = v;
        this.desc = desc;
    }

    public int val() {
        return v;
    }

    public String desc() {
        return desc;
    }

    public static OrderTypeEnum getOrderType(int v) {
        for (OrderTypeEnum c : values()) {
            if (v == c.val()) {
                return c;
            }
        }
        throw new RuntimeException("没有找到OrderTypeEnum " + v);
    }

    public static String getValue(int v) {
        for (OrderTypeEnum c : OrderTypeEnum.values()) {
            if (c.val() == v) {
                return c.desc;
            }
        }
        return null;
    }
}
