package com.coderpwh.member.application.service;

import com.coderpwh.member.application.command.CardCommand;

/**
 * @author coderpwh
 */
public interface CardService {


    /***
     * 保存
     * @param cardCommand
     * @return
     */
    String saveCard(CardCommand cardCommand);

}
