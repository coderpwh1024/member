package com.coderpwh.member.web;

import com.coderpwh.member.application.command.CardCommand;
import com.coderpwh.member.application.command.OrderInfoQuery;
import com.coderpwh.member.application.service.CardService;
import com.coderpwh.member.common.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author coderpwh
 */

@Slf4j
@RequestMapping(value = "/card")
@RestController
public class CardController {


    @Resource
    private CardService cardService;



    /***
     * @param
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Result saveCard(@RequestBody @Valid CardCommand cardCommand) {
        return Result.ok(cardService.saveCard(cardCommand));
    }

}
