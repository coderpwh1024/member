package com.coderpwh.member.domain.enums;

/**
 * @author coderpwh
 * @date 2022/8/23 13:36
 */
public enum CashierTypeEnum {


    CASHIER_NO_PAY(0, "0", "无"),

    CASHIER_BANCK_PAY(3, "3", "银行卡快捷支付"),

    CASHIER_WX_JSAPI_PAY(4, "4", "微信JS支付"),

    CASHIER_ALI_H5_PAY(5, "5", "支付宝H5支付"),

    CASHIER_WX_H5_PAY(6, "6", "微信H5支付"),

    CASHIER_WX_PROGRAM(7, "7", "微信小程序支付"),

    CASHIER_BAOFU_PROGRAM(15, "15", "宝付支付银行卡快捷支付"),

    CASHIER_EMA_WX_PROGRAM(26, "26", "易付宝微信小程序支付"),

    CASHIER_JD_CARD_PAY(30, "30", "京东快捷卡支付"),
    ;

    private Integer type;

    private String value;

    private String stringType;


    CashierTypeEnum(Integer type, String stringType, String value) {
        this.type = type;
        this.stringType = stringType;
        this.value = value;
    }

    public String getStringType() {
        return stringType;
    }

    public void setStringType(String stringType) {
        this.stringType = stringType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(Integer type) {
        for (CashierTypeEnum pay : CashierTypeEnum.values()) {
            if (pay.getType().equals(type)) {
                return pay.getValue();
            }
        }
        return null;
    }

    public static String getCashierType(String type) {

        Integer IntegerType = Integer.valueOf(type);
        switch (IntegerType) {
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 26:
                return "26";
            default:
                return "3";
        }

    }


    /**
     * 枚举注释
     *
     * @param stringType
     * @return
     */
    public static CashierTypeEnum getCashierTypeEnum(String stringType) {

        switch (stringType) {
            case "3":
                return CashierTypeEnum.CASHIER_BANCK_PAY;
            case "4":
                return CashierTypeEnum.CASHIER_WX_JSAPI_PAY;
            case "5":
                return CashierTypeEnum.CASHIER_ALI_H5_PAY;
            case "6":
                return CashierTypeEnum.CASHIER_WX_H5_PAY;
            case "7":
                return CashierTypeEnum.CASHIER_WX_PROGRAM;
            case "26":
                return CashierTypeEnum.CASHIER_EMA_WX_PROGRAM;
            case "30":
                return CashierTypeEnum.CASHIER_JD_CARD_PAY;
            default:
                return CashierTypeEnum.CASHIER_BANCK_PAY;

        }


    }


}
