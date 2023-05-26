package com.coderpwh.member.domain.enums;

/**
 * @author coderpwh
 * @date 2023/5/26 14:24
 */
public enum MemberSettlementRuleEnum {


    AMOUNT_RULE(1, "协议价"),

    ORDER_AMOUNT_RULE(2, "订单实际成交金额"),

    PACKAGE_RULE(3, "根据套餐匹配"),


    ;
    private int v;
    private String desc;

    MemberSettlementRuleEnum(int v, String desc) {
        this.v = v;
        this.desc = desc;
    }

    public int val() {
        return v;
    }

    public String desc() {
        return desc;
    }

    public static MemberSettlementRuleEnum getOrderType(int v) {
        for (MemberSettlementRuleEnum c : values()) {
            if (v == c.val()) {
                return c;
            }
        }
        throw new RuntimeException("没有找到OrderTypeEnum " + v);
    }

    public static String getValue(int v) {
        for (MemberSettlementRuleEnum c : MemberSettlementRuleEnum.values()) {
            if (c.val() == v) {
                return c.desc;
            }
        }
        return null;
    }

}
