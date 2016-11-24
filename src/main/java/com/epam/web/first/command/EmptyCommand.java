package com.epam.web.first.command;

import com.epam.web.first.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EmptyCommand implements ActionCommand {
    private static final String PATH_PAGE_INDEX = "path.page.index";
    private static final String PARAM_LOCALE = "locale";
    private static final String DEFAULT_LOCALE = "en_US";
    private static final String PARAM_LANGUAGE = "language";

    @Override
    public String execute(HttpServletRequest request) {
        ConfigurationManager manager = new ConfigurationManager();
        HttpSession session = request.getSession(true);

        if (session.getAttribute(PARAM_LANGUAGE) == null) {
            session.setAttribute(PARAM_LANGUAGE, DEFAULT_LOCALE);
        }

        String currLanguage = (String) session.getAttribute(PARAM_LANGUAGE);
        request.setAttribute(PARAM_LOCALE, currLanguage);

        String page = manager.getProperty(PATH_PAGE_INDEX);

        return page;
    }
}
