package com.automationqa.task01.controller;

import com.automationqa.task01.controller.impl.CommandConvert;
import com.automationqa.task01.controller.impl.CommandDebt;
import com.automationqa.task01.controller.impl.CommandDeposit;
import com.automationqa.task01.controller.impl.CommandGetBalance;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<CommandName, ICardCommand> mapCommand = new HashMap<>();

public CommandProvider(){
    mapCommand.put(CommandName.DEPOSIT_ACCOUNT, new CommandDeposit());
    mapCommand.put(CommandName. DEBT_ACCOUNT, new CommandDebt());
    mapCommand.put(CommandName.GET_BALANCE, new CommandGetBalance());
    mapCommand.put(CommandName.CONVERT_CURRENCY, new CommandConvert());
}

    public Map<CommandName, ICardCommand> getMapCommand() {
        return mapCommand;
    }

}
