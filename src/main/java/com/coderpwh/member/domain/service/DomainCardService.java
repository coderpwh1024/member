package com.coderpwh.member.domain.service;

import com.coderpwh.member.domain.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coderpwh
 */
@Slf4j
public class DomainCardService {


    @Resource
    private RestTemplate restTemplate;


    /***
     * 保存卡片
     * @return
     */
    public Boolean saveCard(String orderNumber, Integer countNumber, String product, String token, String notifyUrl, String key) {
        String url = "";
        Map<String, String> map = getSign(orderNumber, countNumber, product, token, notifyUrl, key);
        String result = restTemplate.postForObject(url, map, String.class);
        log.info("请求结果为:{}",result);
        return false;
    }

    public Map<String, String> getSign(String orderNumber, Integer countNumber, String product, String token, String notifyUrl, String key) {
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
