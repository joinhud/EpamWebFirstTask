package com.epam.web.first.command;

import com.epam.web.first.manager.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements ActionCommand {
    private static final String PARAM_LANGUAGE = "language";
    private static final String PARAM_LOCALE = "locale";
    private static final String PATH_PAGE_INDEX = "path.page.index";
    private static final String DEFAULT_LOCALE_VALUE = "en_US";


    @Override
    public String execute(HttpServletRequest request) {
        String language = request.getParameter(PARAM_LANGUAGE);
        ConfigurationManager manager = new ConfigurationManager();
        HttpSession session = request.getSession(true);

        if(!language.isEmpty()) {
            session.setAttribute(PARAM_LANGUAGE, language);
            request.setAttribute(PARAM_LOCALE, language);
        } else {
            session.setAttribute(PARAM_LANGUAGE, DEFAULT_LOCALE_VALUE);
            request.setAttribute(PARAM_LOCALE, DEFAULT_LOCALE_VALUE);
        }

        return manager.getProperty(PATH_PAGE_INDEX);
    }
}
