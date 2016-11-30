package com.epam.web.first.factory;

import com.epam.web.first.command.ActionCommand;
import com.epam.web.first.command.EmptyCommand;
import com.epam.web.first.type.CommandEnum;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static final Logger LOG = LogManager.getLogger();
    private static final String PARAM_COMMAND = "command";
    private static final String PARSE_COMMAND = "parse";

    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        String action = null;

        if (ServletFileUpload.isMultipartContent(request)) {
            action = PARSE_COMMAND;
        } else {
            action = request.getParameter(PARAM_COMMAND);
        }

        if (action == null || action.isEmpty()) {
            return current;
        }

        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            LOG.log(Level.ERROR, e);
        }

        return current;
    }
}
