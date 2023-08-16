package com.coderpwh.member.web;

import com.coderpwh.member.common.util.result.Result;
import com.coderpwh.member.domain.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author coderpwh
 * @date 2023/8/14 14:10
 */
@Slf4j
@RestController
public class IndexController {


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result health() {
        Map<String, Object> map = new HashMap<>();
        map.put("time", DateUtils.getStringByDate(new Date()));
        map.put("contenxt", "当前系统运行正常!");
        return Result.ok(map);
    }

}
