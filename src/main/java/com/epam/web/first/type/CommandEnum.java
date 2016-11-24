package com.epam.web.first.type;

import com.epam.web.first.command.ActionCommand;
import com.epam.web.first.command.ChangeLanguageCommand;
import com.epam.web.first.command.ParseCommand;

public enum CommandEnum {
    CHANGE_LANGUAGE {
        {
            this.command = new ChangeLanguageCommand();
        }
    },
    PARSE {
        {
            this.command = new ParseCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}
