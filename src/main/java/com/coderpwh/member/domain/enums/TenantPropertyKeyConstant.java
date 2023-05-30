package com.coderpwh.member.domain.enums;

/**
 * @Author Patrick
 * @Description 租户拥护属性key值常量
 * @Date 2023-02-20 14:44
 * @Param No such property: code for class: Script1
 * @return No such property: code for class: Script1
 **/
public interface TenantPropertyKeyConstant {

	/**
	 * 是否允许租户一键登录H5
	 */
	String H5_LOGIN_KEY = "is_h5_login";

	/**
	 * 是否允许租户里一个手机号仅可绑定在同一个用户上
	 */
	String BIND_SAME_USER_KEY = "is_bind_same_user";

	/**
	 * 是否允许租户下用户使用短信登录
	 */
	String SMS_LOGIN_KEY = "is_sms_login";

	/**
	 * 是否允许租户下用户可以修改手机号
	 */
	String UPDATE_PHONE_KEY= "is_update_phone";

	/**
	 * 是否允许过期失败退款
	 */
	String OVERDUE_REFUND__KEY= "is_overdue_refund";
	/**
	 * 是否允许乱序退款
	 */
	String OUT_OF_ORDER_REFUND__KEY= "is_out_of_order_refund";


}
