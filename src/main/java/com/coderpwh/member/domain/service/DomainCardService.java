package com.coderpwh.member.domain.service;

import com.coderpwh.member.domain.util.MD5;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coderpwh
 */
public class DomainCardService {



    @Resource
    private RestTemplate restTemplate;


    /***
     * 保存卡片
     * @return
     */
    public Boolean saveCard() {
        return  false;
    }

    public void getSign(String orderNumber,Integer countNumber,String product,String token,String notifyUrl,String key){
        String orderCode = orderNumber;
        Integer count = countNumber;
        String productCode = product;
        String signStr = "token=" + token + "&orderId=" + orderCode + "&count=" + count + "&productCode=" + productCode + "&notifyUrl=" + notifyUrl + "&key=" + key;
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("token", token);
        paramMap.put("orderId", orderCode);
        paramMap.put("productCode", productCode);
        paramMap.put("count", String.valueOf(count));
        paramMap.put("notifyUrl", notifyUrl);
        paramMap.put("sign", MD5.encode(signStr));
    }





}
